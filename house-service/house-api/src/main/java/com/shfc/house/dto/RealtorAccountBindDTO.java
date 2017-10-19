package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人账户跟微信绑定
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 09:45
 **/
public class RealtorAccountBindDTO implements Serializable{

    private static final long serialVersionUID = 9096216233934427458L;
    private String wxOpenId;//微信openId
    private String phone;//上海房产注册手机号
    private String checkCode;//    短信验证码
    private String msgId;//短信验证码Id
    private String picCheckCode;//图片验证码  验证超过三次时需要
    //private Integer type;//绑定类型  0：首次绑定，1：修改绑定

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

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

    public String getPicCheckCode() {
        return picCheckCode;
    }

    public void setPicCheckCode(String picCheckCode) {
        this.picCheckCode = picCheckCode;
    }
//
//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
}


