package com.shfc.house.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 获取验证码
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-16 13:42
 **/
public class CheckCodeQuery implements Serializable {
    private static final long serialVersionUID = 1370535677738588567L;
    private String phone;
    private String picCheckCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicCheckCode() {
        return picCheckCode;
    }

    public void setPicCheckCode(String picCheckCode) {
        this.picCheckCode = picCheckCode;
    }
}
