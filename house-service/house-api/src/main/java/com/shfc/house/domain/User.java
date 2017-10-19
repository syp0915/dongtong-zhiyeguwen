package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

import java.util.Date;

/**
 * @Package: User.java
 * @Description: 用户
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author Li Jianguo
 * @date 2017/01/09 17:36
 * version v1.0.0
 */
public class User extends BaseBean {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 性别（0-男性 1-女性）
     */
    private Integer gender;

    /**
     * 用户签名
     */
    private String userAutograph;

    /**
     * 用户email
     */
    private String userEmail;

    /**
     * 电话号码
     */
    private String mobile;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String headerUrl;

    /**
     * 所在城市
     */
    private Long cityId;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 登录IP
     */
    private String userLoginIp;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 操作编号
     */
    private String operatorNo;

    /**
     * 微信绑定id
     */
    private String wxOpenId;

    /**
     * 绑定时间
     */
    private Date bindingTime;

    /**
     * 状态（0-正常 1-冻结 3-异常）
     */
    private Integer status;

    /**
     * 是否白名单
     */
    private Boolean isWhite;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 身份证号
     */
    private String identityNo;

    /**
     * 银行预留手机号
     */
    private String bankLeavePhone;

    /**
     * 四要素认证  0否 1是
     */
    private Boolean fourElementsAuth;

    /**
     * 是否实名认证 0否 1是
     */
    private Boolean isAuth;

    /**
     * 账号来源(1-app,2-web,3-专业终端,4-微信H5(997))
     */
    private Boolean source;

    /**
     * 获取用户名
     *
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码
     *
     * @return user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置用户密码
     *
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 获取性别（0-男性 1-女性）
     *
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别（0-男性 1-女性）
     *
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取用户签名
     *
     * @return user_autograph
     */
    public String getUserAutograph() {
        return userAutograph;
    }

    /**
     * 设置用户签名
     *
     * @param userAutograph
     */
    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph == null ? null : userAutograph.trim();
    }

    /**
     * 获取用户email
     *
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置用户email
     *
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取电话号码
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置电话号码
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取头像
     *
     * @return header_url
     */
    public String getHeaderUrl() {
        return headerUrl;
    }

    /**
     * 设置头像
     *
     * @param headerUrl
     */
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl == null ? null : headerUrl.trim();
    }

    /**
     * 获取所在城市
     *
     * @return city_id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置所在城市
     *
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取用户地址
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置用户地址
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取登录IP
     *
     * @return user_login_ip
     */
    public String getUserLoginIp() {
        return userLoginIp;
    }

    /**
     * 设置登录IP
     *
     * @param userLoginIp
     */
    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp == null ? null : userLoginIp.trim();
    }

    /**
     * 获取设备ID
     *
     * @return device_id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备ID
     *
     * @param deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * 获取操作编号
     *
     * @return operator_no
     */
    public String getOperatorNo() {
        return operatorNo;
    }

    /**
     * 设置操作编号
     *
     * @param operatorNo
     */
    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    /**
     * 获取微信绑定id
     *
     * @return wx_open_id
     */
    public String getWxOpenId() {
        return wxOpenId;
    }

    /**
     * 设置微信绑定id
     *
     * @param wxOpenId
     */
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    /**
     * 获取绑定时间
     *
     * @return binding_time
     */
    public Date getBindingTime() {
        return bindingTime;
    }

    /**
     * 设置绑定时间
     *
     * @param bindingTime
     */
    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    /**
     * 获取状态（0-正常 1-冻结 3-异常）
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0-正常 1-冻结 3-异常）
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否白名单
     *
     * @return is_white
     */
    public Boolean getIsWhite() {
        return isWhite;
    }

    /**
     * 设置是否白名单
     *
     * @param isWhite
     */
    public void setIsWhite(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    /**
     * 获取银行账号
     *
     * @return bank_account
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账号
     *
     * @param bankAccount
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取身份证号
     *
     * @return identity_no
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * 设置身份证号
     *
     * @param identityNo
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * 获取银行预留手机号
     *
     * @return bank_leave_phone
     */
    public String getBankLeavePhone() {
        return bankLeavePhone;
    }

    /**
     * 设置银行预留手机号
     *
     * @param bankLeavePhone
     */
    public void setBankLeavePhone(String bankLeavePhone) {
        this.bankLeavePhone = bankLeavePhone == null ? null : bankLeavePhone.trim();
    }

    /**
     * 获取四要素认证  0否 1是
     *
     * @return four_elements_auth
     */
    public Boolean getFourElementsAuth() {
        return fourElementsAuth;
    }

    /**
     * 设置四要素认证  0否 1是
     *
     * @param fourElementsAuth
     */
    public void setFourElementsAuth(Boolean fourElementsAuth) {
        this.fourElementsAuth = fourElementsAuth;
    }

    /**
     * 获取是否实名认证 0否 1是
     *
     * @return is_auth
     */
    public Boolean getIsAuth() {
        return isAuth;
    }

    /**
     * 设置是否实名认证 0否 1是
     *
     * @param isAuth
     */
    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    /**
     * 获取账号来源(1-app,2-web,3-专业终端,4-微信H5(997))
     *
     * @return source
     */
    public Boolean getSource() {
        return source;
    }

    /**
     * 设置账号来源(1-app,2-web,3-专业终端,4-微信H5(997))
     *
     * @param source
     */
    public void setSource(Boolean source) {
        this.source = source;
    }

    /**
     * @Title toString
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userName=").append(userName);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", gender=").append(gender);
        sb.append(", userAutograph=").append(userAutograph);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", mobile=").append(mobile);
        sb.append(", phone=").append(phone);
        sb.append(", realName=").append(realName);
        sb.append(", headerUrl=").append(headerUrl);
        sb.append(", cityId=").append(cityId);
        sb.append(", address=").append(address);
        sb.append(", userLoginIp=").append(userLoginIp);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", operatorNo=").append(operatorNo);
        sb.append(", wxOpenId=").append(wxOpenId);
        sb.append(", bindingTime=").append(bindingTime);
        sb.append(", status=").append(status);
        sb.append(", isWhite=").append(isWhite);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", identityNo=").append(identityNo);
        sb.append(", bankLeavePhone=").append(bankLeavePhone);
        sb.append(", fourElementsAuth=").append(fourElementsAuth);
        sb.append(", isAuth=").append(isAuth);
        sb.append(", source=").append(source);
        sb.append("]");
        return sb.toString();
    }
}