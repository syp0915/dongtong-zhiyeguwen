package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.RealtorMemberDTO
 * @Description: 经纪人会员DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/20 13:28
 * version V1.0.0
 */
public class RealtorMemberDTO implements Serializable {
    private Long realtorId;//经纪人id
    private String phone;//手机号
    private Integer memberStatus;//会员状态
    private String deviceId;//设备ID
    private Integer osType;//操作系统类型0-iOS 1-Android

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getOsType() {
        return osType;
    }

    public void setOsType(Integer osType) {
        this.osType = osType;
    }
}
