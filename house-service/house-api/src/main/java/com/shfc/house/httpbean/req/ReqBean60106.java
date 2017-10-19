package com.shfc.house.httpbean.req;

import com.shfc.house.base.BaseReqBean;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:18.
 */
public class ReqBean60106 extends BaseReqBean {
    private String agreementId;//	协议id
    private String name;//	姓名
    private String identityId;//	身份证号
    private String phone;//	手机号
    private String picUrl;//	用户签章图片url
    private Integer entrustPeriod;//	委托期限
    private String verifyCodeId;//验证码id
    private String verifyCode;//验证码
    private String operateType;//0-第一步提交 1-最终提交

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getEntrustPeriod() {
        return entrustPeriod;
    }

    public void setEntrustPeriod(Integer entrustPeriod) {
        this.entrustPeriod = entrustPeriod;
    }

    public String getVerifyCodeId() {
        return verifyCodeId;
    }

    public void setVerifyCodeId(String verifyCodeId) {
        this.verifyCodeId = verifyCodeId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}
