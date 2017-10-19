package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.mybatis.pagination.Page;

/**
 * @Package com.shfc.house.service.OrderService
 * @Description: 订单服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 19:21
 * version V1.0.0
 */
public interface OrderService {
    /**
     *生成待支付订单
     * @param orderParamDTO
     * @return
     */
    ResultDO<OrderInfoDTO> createOrder(OrderParamDTO orderParamDTO);

    /**
     * 订单列表
     * @param query
     * @return
     */
    ResultDO<Page<OrderListDTO>> orderList(OrderParamDTO query);

    /**
     * 订单详情
     * @param query
     * @return
     */
    ResultDO<OrderInfoDTO> orderDetail(OrderParamDTO query);

    /**
     * 订单支付成功验签
     * @param payCheckDTO
     * @return
     */
    ResultDO<Boolean> orderAttestation(OrderAttestationDTO payCheckDTO);
    /**
     * 查询所有的待支付订单
     * 并关闭过期订单
     * @return
     */
    void closeNoPaymentList();

    /**
     * 订单状态查询
     * 返回支付信息
     * @param orderId
     * @return
     */
    ResultDO<PayOrderResultDTO> queryOrderStatus(Long orderId,Integer payType);
}
