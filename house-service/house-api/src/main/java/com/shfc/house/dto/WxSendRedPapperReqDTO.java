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
public class WxSendRedPapperReqDTO implements Serializable{
    private String wxOpenId;
    private Long sendAmount;
    private String orderNo;

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Long getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(Long sendAmount) {
        this.sendAmount = sendAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
