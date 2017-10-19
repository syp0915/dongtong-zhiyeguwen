package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.HbRunPrizeDTO
 * @Description: 红包项目-抽奖
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/15 16:49
 * version V1.0.0
 */
public class HbRunPrizeDTO implements Serializable {
    private String wxOpenId;//微信wxOpenId

    private Long realtorId;//经纪人id
    private String phone;//经纪人手机号

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

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
}
