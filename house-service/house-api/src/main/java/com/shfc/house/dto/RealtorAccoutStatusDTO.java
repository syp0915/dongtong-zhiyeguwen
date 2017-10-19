package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人账户状态
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 09:54
 **/
public class RealtorAccoutStatusDTO implements Serializable {
    private static final long serialVersionUID = 2670866473928372392L;
    private String realtorId;//经纪人Id
    private String phone;//经纪人手机号
    private String status;//经纪人状态   0待审核;1审核通过;2不通过(冻结);3已解约;4审核中
    private String reason;//原因
    private String prizeRecordNum;//中奖次数

    public String getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(String realtorId) {
        this.realtorId = realtorId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPrizeRecordNum() {
        return prizeRecordNum;
    }

    public void setPrizeRecordNum(String prizeRecordNum) {
        this.prizeRecordNum = prizeRecordNum;
    }
}
