package com.shfc.user.httpbean.req;

import com.shfc.user.base.BaseReqBean;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:18.
 */
public class ReqBean60107 extends BaseReqBean {
    private String wxOpenId;//	微信openId
    private String shfcPhone;//	上海房产注册手机号
    private Integer bindType;//	绑定类型
    private String verifyCode;//验证码
    private String verifyCodeId;//验证码id

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getShfcPhone() {
        return shfcPhone;
    }

    public void setShfcPhone(String shfcPhone) {
        this.shfcPhone = shfcPhone;
    }

    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyCodeId() {
        return verifyCodeId;
    }

    public void setVerifyCodeId(String verifyCodeId) {
        this.verifyCodeId = verifyCodeId;
    }
}
