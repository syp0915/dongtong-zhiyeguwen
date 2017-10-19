package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/3/2 下午2:45.
 */
public class WxSendRedPapperRespDTO implements Serializable{
    private String wxOpenId;//用户openId
    private String orderNo;//商户支付内部订单号
    private Long sendAmount;//支付金额
    private String wxPayOrderNo;//微信支付订单号

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(Long sendAmount) {
        this.sendAmount = sendAmount;
    }

    public String getWxPayOrderNo() {
        return wxPayOrderNo;
    }

    public void setWxPayOrderNo(String wxPayOrderNo) {
        this.wxPayOrderNo = wxPayOrderNo;
    }
}
