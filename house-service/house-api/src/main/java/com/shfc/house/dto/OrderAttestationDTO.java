package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.OrderAttestationDTO
 * @Description:订单验签的DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/14 13:17
 * version V1.0.0
 */
public class OrderAttestationDTO implements Serializable {
    private String merchantNo;//商户号
    private Integer payType;//支付渠道类型    aliPay:支付宝(0) wxPay:微信支付(1)
    private String memo;//描述信息
    private String result;//处理结果
    private String resultStatus; //处理结果码

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }
}
