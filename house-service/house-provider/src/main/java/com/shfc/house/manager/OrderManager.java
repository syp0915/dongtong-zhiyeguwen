package com.shfc.house.manager;

import com.fc.common.redis.RedisUtil;
import com.shfc.common.base.Logger;
import com.shfc.common.base.StringUtils;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.LeadsComboMapper;
import com.shfc.house.dao.LeadsOrderMapper;
import com.shfc.house.dao.LeadsRealtorComboRelMapper;
import com.shfc.house.dao.LeadsRealtorMemberMapper;
import com.shfc.house.domain.LeadsCombo;
import com.shfc.house.domain.LeadsOrder;
import com.shfc.house.domain.LeadsRealtorComboRel;
import com.shfc.house.domain.LeadsRealtorMember;
import com.shfc.house.dto.OrderInfoDTO;
import com.shfc.house.dto.OrderParamDTO;
import com.shfc.house.dto.OrderListDTO;
import com.shfc.house.enums.LeadsOrderStatus;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Package com.shfc.house.manager.OrderManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 19:55
 * version V1.0.0
 */
@Service
public class OrderManager {
    @Autowired
    private LeadsOrderMapper leadsOrderMapper;
    @Autowired
    private LeadsRealtorComboRelMapper leadsRealtorComboRelMapper;
    @Autowired
    private LeadsRealtorMemberMapper leadsRealtorMemberMapper;
    @Autowired
    private LeadsComboMapper leadsComboMapper;
    /**
     * 订单编号生成规则
     * @return
     */
    public static String orderNumBuilder(){
        String number  = StringUtils.toString(RedisUtil.get("order_"+ DateUtils.getCurrentTime("yyyy-MM-dd")),"1");//初始值是1
        String key = "H"+ DateUtils.getCurrentTime("yyyy").substring(2)+DateUtils.getCurrentTime("MMdd");
        DecimalFormat df = new DecimalFormat("0000");
        int numberInt = 0;
        String result = df.format(Integer.parseInt(number));
        result = key+result;
        numberInt = Integer.parseInt(number);
        RedisUtil.set("order_"+DateUtils.getCurrentTime("yyyy-MM-dd"),++numberInt,86400L);//设置过期时间是24小时
        return result;

    }
    public LeadsOrder selectByPrimaryKey(Long id){
        return leadsOrderMapper.selectByPrimaryKey(id);
    }
    /**
     * 创建待支付订单
     * 添加到经纪人购买套餐关系表
     * @param orderParamDTO
     * @return
     */
    @Transactional(rollbackFor = AppException.class)
    public Long  createOrder(OrderParamDTO orderParamDTO) throws AppException{
        Long comboId  = orderParamDTO.getComboId();
        Long realtorId = orderParamDTO.getRealtorId();
        LeadsOrder record = new LeadsOrder();
        String orderNumber = orderNumBuilder();//生成订单编号
        record.setOrderNum(orderNumber);
        record.setComboId(comboId);
        record.setRealtorId(realtorId);
        leadsOrderMapper.insert(record);
        Long orderId  = record.getId();//插入返回的订单ID
        LeadsRealtorComboRel comboRel = new LeadsRealtorComboRel();
        comboRel.setOrderId(orderId);
        comboRel.setComboId(comboId);
        comboRel.setRealtorId(realtorId);
        leadsRealtorComboRelMapper.insert(comboRel);
        return orderId;
    }

    /**
     * 根据订单编号查询订单
     * @param orderNum
     * @return
     */
    public LeadsOrder selectByOrderNum(String orderNum){
        return leadsOrderMapper.selectByOrderNum(orderNum);
    }
    /**
     * 订单列表
     * @param query
     * @param page
     * @return
     */
    public Page<OrderListDTO> orderList(OrderParamDTO query, Page page){
        leadsOrderMapper.orderList(query,page);
        return page;
    }

    /**
     * 查询所有的待支付订单
     * 并关闭过期订单
     * @return
     */
    public void closeNoPaymentList(){
        List<LeadsOrder> orderList =  leadsOrderMapper.noPaymentList();
        Iterator<LeadsOrder> integer = orderList.iterator();
        while (integer.hasNext()){
            LeadsOrder record = integer.next();
            String orderCreateDate = DateUtils.date2String(record.getCreateTime());
            int second  = DateUtils.compareTime(orderCreateDate,DateUtils.getCurrentTime(),3);
            if(second>=1800){ //创建时间到当前时间过了30分钟，置为 订单关闭
                try {
                    closeNoPaymentOrder(record);
                } catch (AppException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 更新待支付订单为订单关闭，超过30分钟订单未支付
     * @param record
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void  closeNoPaymentOrder(LeadsOrder record) throws AppException{
        record = leadsOrderMapper.selectByPrimaryKey(record.getId());
        if(record.getStatus().intValue() == LeadsOrderStatus.NO_PAYMENT.getValue()){
            record.setStatus(LeadsOrderStatus.ORDER_CLOSE.getValue());
            leadsOrderMapper.updateStatus(record);
        }
    }

    /**
     * 更新未支付的订单为已支付 来源于kafka消费
     * @param leadsOrder
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateNoPaymentOrder(LeadsOrder leadsOrder) throws AppException{
        LeadsOrder record = leadsOrderMapper.selectByPrimaryKey(leadsOrder.getId());
        if(record.getStatus().intValue() == LeadsOrderStatus.NO_PAYMENT.getValue()){
            record.setStatus(LeadsOrderStatus.HAVE_PAID.getValue());
            record.setPayTime(DateUtils.getCurrentDate());
            record.setOrderPaySerialNum(leadsOrder.getOrderPaySerialNum());
            leadsOrderMapper.updateStatus(record);
        }
        //查询套餐的状态和失效日期
        LeadsCombo leadsCombo  = leadsComboMapper.selectByPrimaryKey(record.getComboId());
        int periodUnit = leadsCombo.getPeriodUnit();//套餐周期
        String overdueDate = DateUtils.addMothToDate(periodUnit,DateUtils.getCurrentDate(),null);
        //先查询本地是否有记录
        LeadsRealtorMember realtorMember = leadsRealtorMemberMapper.selectUniqueByRealtorId(record.getRealtorId());
        if(realtorMember==null){
            realtorMember = new LeadsRealtorMember();
            realtorMember.setRealtorId(record.getRealtorId());
            realtorMember.setDeadline(DateUtils.string2Date(overdueDate));
            leadsRealtorMemberMapper.insert(realtorMember);
        }else {
            realtorMember.setStatus(0);//状态重新置为有效
            realtorMember.setDeadline(DateUtils.string2Date(overdueDate));
            leadsRealtorMemberMapper.updateByPrimaryKey(realtorMember);
        }
    }



    /**
     * 更新订单的邀请码、支付类型、支付中心订单状态
     * @param query
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public int updateInvitationCodeOrStatus(LeadsOrder query)throws AppException{
        LeadsOrder record = leadsOrderMapper.selectByPrimaryKey(query.getId());
        record.setInvitationCode(query.getInvitationCode());
        record.setPayType(query.getPayType());
        record.setOrderPaySerialNum(query.getOrderPaySerialNum());
        Logger.info(OrderManager.class,record.getOrderPaySerialNum());
        return leadsOrderMapper.updateInvitationCodeOrStatus(record);
    }
    /**
     * 订单详情
     * @param orderId
     * @return
     */
    public OrderInfoDTO orderDetail(Long orderId){
        return leadsOrderMapper.orderDetail(orderId);
    }
}
