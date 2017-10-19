package com.shfc.house.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.common.base.StringUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.constant.ConstantService;
import com.shfc.house.domain.LeadsCombo;
import com.shfc.house.domain.LeadsOrder;
import com.shfc.house.dto.*;
import com.shfc.house.enums.PayType;
import com.shfc.house.enums.YesNo;
import com.shfc.house.manager.LeadsComboManager;
import com.shfc.house.manager.OrderManager;
import com.shfc.house.utils.DateFormatUtils;
import com.shfc.kafka.comsumer.KafkaConsumerClient;
import com.shfc.kafka.comsumer.dto.KafkaConsumerDto;
import com.shfc.mybatis.pagination.Page;
import com.shfc.pay.dto.PayCheckResultDTO;
import com.shfc.pay.dto.PayOrderStatusDTO;
import com.shfc.pay.dto.PayOrderStatusResultDTO;
import com.shfc.pay.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.service.OrderServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 19:54
 * version V1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private PayService payService;
    @Autowired
    private LeadsComboManager leadsComboManager;


    @Override
    public ResultDO<OrderInfoDTO> createOrder(OrderParamDTO orderParamDTO) {
        ResultDO<OrderInfoDTO> resultDO = new ResultDO<>();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        Long orderId  = null;
        Long comboId  = orderParamDTO.getComboId();
        LeadsCombo leadsCombo = leadsComboManager.select(comboId);
        if(leadsCombo==null){
            resultDO.setErrMsg("套餐不存在！");
            return resultDO;
        }
        if(leadsCombo.getStatus().intValue()!= YesNo.NO.getValue()){
            resultDO.setErrMsg("套餐状态不正确！");
            return resultDO;
        }
        try {
            orderId = orderManager.createOrder(orderParamDTO);
            orderInfoDTO.setSecond(1800);//生成30分钟
            orderInfoDTO.setOrderId(orderId);
            resultDO.setData(orderInfoDTO);
            resultDO.setSuccess(true);
            return resultDO;
        } catch (AppException e) {
            e.printStackTrace();
            resultDO.setErrMsg("待支付订单创建失败！");
            return resultDO;
        }

        //orderInfoDTO.setOderCreateTime(DateUtils.getCurrentTime());
        //订单保存到redis,默认时间30分钟
        //orderList = (List<OrderInfoDTO>)RedisUtil.get(REDIS_KEY_ORDER);
        //orderList.add(orderInfoDTO);
        //RedisUtil.set(orderNumber,orderInfoDTO,30L);

    }


    @Override
    public ResultDO<Page<OrderListDTO>> orderList(OrderParamDTO query) {
        ResultDO<Page<OrderListDTO>> resultDO = new ResultDO<>();
        Page<OrderListDTO> listPage = orderManager.orderList(query,query.getPage());
        resultDO.setSuccess(true);
        resultDO.setData(listPage);
        return resultDO;
    }

    @Override
    public ResultDO<OrderInfoDTO> orderDetail(OrderParamDTO query) {
        ResultDO<OrderInfoDTO> resultDO = new ResultDO<>();
        Long orderId = query.getOrderId();
        if(orderId==null){
            resultDO.setErrMsg("订单ID不能为空！");
            return resultDO;
        }
        OrderInfoDTO infoDTO = orderManager.orderDetail(orderId);
        if(infoDTO==null){
            resultDO.setErrMsg("订单信息不正确！");
            return resultDO;
        }
        if(!ValidateHelper.isEmptyString(infoDTO.getOderCreateTime())){
            int second  = DateUtils.compareTime(infoDTO.getOderCreateTime(),null,3);
            second = 1800-second;
            infoDTO.setSecond(second);
        }
        resultDO.setSuccess(true);
        resultDO.setData(infoDTO);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> orderAttestation(OrderAttestationDTO payCheckDTO) {
        ResultDO<Boolean> resultDO = new ResultDO<>();
        PayCheckResultDTO remoteQuery = new PayCheckResultDTO();
        BeanUtils.copyProperties(payCheckDTO,remoteQuery);
        int type = payCheckDTO.getPayType().intValue();
        if(type== PayType.ALIPAY.getValue()){
            remoteQuery.setPayType(PayType.getNameByValue(type));
        }else if(type == PayType.WXPAY.getValue()){
            remoteQuery.setPayType(PayType.getNameByValue(type));
        }
        remoteQuery.setMerchantNo(ConstantService.MERCHANT_NO);//默认的商户编号
        ResultDO payCheck  =payService.checkSyncPayResultSign(remoteQuery);
        if(!payCheck.isSuccess()){
            resultDO.setErrMsg(payCheck.getErrMsg());
            resultDO.setErrCode(payCheck.getErrCode());
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public void closeNoPaymentList() {
        orderManager.closeNoPaymentList();
    }

    /**
     * 该接口暂不实现
     * @param orderId
     * @return
     */
    @Override
    public ResultDO<PayOrderResultDTO> queryOrderStatus(Long orderId,Integer payType){
        ResultDO<PayOrderResultDTO> resultDO = new ResultDO<>();
        PayOrderResultDTO result = new PayOrderResultDTO();
        LeadsOrder order = orderManager.selectByPrimaryKey(orderId);
        if(order==null){
            resultDO.setErrMsg("订单信息不存在！");
            return resultDO;
        }
        PayOrderStatusDTO query = new PayOrderStatusDTO();
        query.setMerchantNo(ConstantService.MERCHANT_NO);//默认的商户编号.
        if(payType== PayType.ALIPAY.getValue()){
            query.setPayType(PayType.getNameByValue(payType));
        }else if(payType == PayType.WXPAY.getValue()){
            query.setPayType(PayType.getNameByValue(payType));
        }
        query.setOrderNo(order.getOrderPaySerialNum());
        ResultDO<PayOrderStatusResultDTO> payResultDO = payService.getOrderStatus(query);
        if(!payResultDO.isSuccess()){
            resultDO.setErrMsg(payResultDO.getErrMsg());
            return resultDO;
        }
        BeanUtils.copyProperties(payResultDO.getData(),result);
        resultDO.setData(result);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
