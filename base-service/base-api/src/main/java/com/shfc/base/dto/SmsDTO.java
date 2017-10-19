package com.shfc.base.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.base.dto.SmsDTO
 * @Description: 短信发送的公共DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/7/10 13:40
 * version V1.0.0
 */
public class SmsDTO implements Serializable {
    private String phone;//手机号
    private Integer sendType;//发送类型 0-短信 1-语音，默认0
    private Integer useScene;//0-登录 1-贷款申请 2-租铺签约 3-寻租申请 4-带我踩盘 5-商铺纠错 6-预约看铺

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getUseScene() {
        return useScene;
    }

    public void setUseScene(Integer useScene) {
        this.useScene = useScene;
    }
}
