package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.RealtorUnitiveAccount.java
 * @Description: 经纪人/经纪公司/门店统一的账户表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:25
 * version v1.0.0
 */
public class RealtorUnitiveAccount extends BaseBean {
    /**
     * 账户名称
     */
    private String userName;

    /**
     * 账户密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 操作系统类型0
     */
    private Integer osType;

    /**
     * 操作编号
     */
    private String operatorNo;

    /**
     * 0经纪人、1经纪公司(作废)、2经纪门店(作废)、3专业终端扫码登录、4专业终端校验码登录
     */
    private Integer type;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 账号状态(0待审核;1审核通过;2不通过(冻结);3已解约;4审核中)
     */
    private Integer status;

    /**
     * 帐号来源(1-经纪人App，2-经纪人App（997），3-经纪合作平台，4-运营后台(997)
     */
    private int source;

    /**
     * 是否有效（0有效1无效）
     */
    private Integer disable;

    /**
     * 获取账户名称
     *
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置账户名称
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取账户密码
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置账户密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
     * 获取角色id
     *
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public Integer getOsType() {
        return osType;
    }

    public void setOsType(Integer osType) {
        this.osType = osType;
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
     * 获取0经纪人、1经纪公司(作废)、2经纪门店(作废)、3专业终端扫码登录、4专业终端校验码登录
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0经纪人、1经纪公司(作废)、2经纪门店(作废)、3专业终端扫码登录、4专业终端校验码登录
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取登录次数
     *
     * @return login_count
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * 设置登录次数
     *
     * @param loginCount
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取账号状态(0待审核;1审核通过;2不通过(冻结);3已解约;4审核中)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置账号状态(0待审核;1审核通过;2不通过(冻结);3已解约;4审核中)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取帐号来源(1-经纪人App，2-经纪人App（997），3-经纪合作平台，4-运营后台(997)
     *
     * @return source
     */
    public int getSource() {
        return source;
    }

    /**
     * 设置帐号来源(1-经纪人App，2-经纪人App（997），3-经纪合作平台，4-运营后台(997)
     *
     * @param source
     */
    public void setSource(int source) {
        this.source = source;
    }

    /**
     * 获取是否有效（0有效1无效）
     *
     * @return disable
     */
    public Integer getDisable() {
        return disable;
    }

    /**
     * 设置是否有效（0有效1无效）
     *
     * @param disable
     */
    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/08 13:25
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
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", roleId=").append(roleId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", osType=").append(osType);
        sb.append(", operatorNo=").append(operatorNo);
        sb.append(", type=").append(type);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", status=").append(status);
        sb.append(", source=").append(source);
        sb.append(", disable=").append(disable);
        sb.append("]");
        return sb.toString();
    }
}