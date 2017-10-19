package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.OrderListDTO
 * @Description: 订单列表DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 9:13
 * version V1.0.0
 */
public class OrderListDTO implements Serializable {
    private Long orderId;//订单ID
    private String oderCreateTime= "";//下单时间
    private Integer orderStatus;//订单状态
    private String comboPrice= "";//套餐价格

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOderCreateTime() {
        return oderCreateTime;
    }

    public void setOderCreateTime(String oderCreateTime) {
        this.oderCreateTime = oderCreateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(String comboPrice) {
        this.comboPrice = comboPrice;
    }
}

