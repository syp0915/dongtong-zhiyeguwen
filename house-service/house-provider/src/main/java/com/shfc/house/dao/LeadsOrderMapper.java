package com.shfc.house.dao;

import com.shfc.house.domain.LeadsOrder;
import com.shfc.house.dto.OrderInfoDTO;
import com.shfc.house.dto.OrderParamDTO;
import com.shfc.house.dto.OrderListDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsOrderMapper.java
 * @Description: 订单表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/10 14:27
 * version v1.1.0
 */
@Repository
public interface LeadsOrderMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsOrder record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsOrder record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param id
     * @return com.shfc.house.domain.LeadsOrder
     * @throws []
     */
    LeadsOrder selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsOrder record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:27
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsOrder record);

    /**
     * 订单列表
     * @param orderParamDTO
     * @param page
     * @return
     */
    List<OrderListDTO> orderList(@Param("query")OrderParamDTO orderParamDTO, Page page);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderInfoDTO orderDetail(Long orderId);

    /**
     * 查询所有的待支付订单
     * @return
     */
    List<LeadsOrder> noPaymentList();

    /**
     * 支付成功和订单关闭修改订单状态
     * @param record
     * @return
     */
    int updateStatus(LeadsOrder record);

    /**
     * 确认支付——订单修改
     * @param record
     * @return
     */
    int updateInvitationCodeOrStatus(LeadsOrder record);

    /**
     * 根据订单编号查询订单
     * @param orderNum
     * @return
     */
    LeadsOrder selectByOrderNum(String orderNum);
}