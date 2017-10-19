package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.PastProtocolDTO
 * @Description: 过期协议处理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/10 12:47
 * version V1.0.0
 */
public class PastProtocolDTO implements Serializable{
    private Long protocolId;//协议id
    private String userPhone;//用户手机号
    private String wxOpenId;//微信openid
    private String protocolNumber;//协议编号
    private String districtName;//区名
    private String address;//房屋地址
    private String plotName;//小区名
    private String successTime;//签约成功时间
    private String overdueTime;//协议失效日期
    private Long realtorId;//职业顾问id
    private String realName;//置业顾问姓名
    private String realtorPhone;//职业顾问手机号

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealtorPhone() {
        return realtorPhone;
    }

    public void setRealtorPhone(String realtorPhone) {
        this.realtorPhone = realtorPhone;
    }
}
