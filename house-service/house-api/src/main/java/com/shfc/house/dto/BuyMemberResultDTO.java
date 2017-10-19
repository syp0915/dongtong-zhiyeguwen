package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.BuyMemberResultDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 20:15
 * version V1.0.0
 */
public class BuyMemberResultDTO implements Serializable {
    private String orderInfo;//返回需要发往第三方支付的参数串（带签名）
    private String orderNo;//返回支付中心的订单号

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}

