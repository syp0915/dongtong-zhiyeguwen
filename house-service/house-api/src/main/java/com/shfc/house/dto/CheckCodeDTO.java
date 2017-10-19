package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 验证码信息
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 09:36
 **/
public class CheckCodeDTO implements Serializable {
    private static final long serialVersionUID = 2359481439700870306L;
    private String verifyCodeId;//验证码Id
    private String times;//验证码请求次数

    public String getVerifyCodeId() {
        return verifyCodeId;
    }

    public void setVerifyCodeId(String verifyCodeId) {
        this.verifyCodeId = verifyCodeId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
