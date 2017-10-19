package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.PayOrderResultDTO
 * @Description: 订单支付查询结果DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/16 14:00
 * version V1.0.0
 */
public class PayOrderResultDTO implements Serializable {
    //第三方订单号
    private String tradeNo;
    //商户订单号
    private String merOrderNo;
    //支付订单号
    private String orderNo;
    //买家账号
    private String buyerLogonId;
    //交易状态
    private String tradeStatus;
    //订单金额
    private String totalAmount;
    //实收金额
    private String receiptAmount;
    //打款时间
    private String sendPayDate;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getSendPayDate() {
        return sendPayDate;
    }

    public void setSendPayDate(String sendPayDate) {
        this.sendPayDate = sendPayDate;
    }
}
