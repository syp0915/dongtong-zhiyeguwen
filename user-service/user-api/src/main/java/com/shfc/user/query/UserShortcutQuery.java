package com.shfc.user.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.RealtorShortcutQuery
 * @Description: 用户快捷登录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 11:43
 * version V1.0.0
 */
public class UserShortcutQuery implements Serializable {
    private String phone;//手机号
    private String checkCode;//验证码
    private String msgId;//消息id
    private String deviceId;//设备ID

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
