package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsCustomer.java
 * @Description: 报备客户表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
public class LeadsCustomer extends BaseBean {
    /**
     * 增值服务ID
     */
    private Long leadsServicesId;

    /**
     * 客户手机
     */
    private String phone;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户性别(0-男、1-女)
     */
    private Integer gender;

    /**
     * 客户状态(0-报备成功、1-确认有效、2-确认无效、3-签约成功、4-签约失败、5-可以结算、6-结算失败)
     */
    private Integer status;

    /**
     * 所属公司id
     */
    private Long merchanismId;

    /**
     * 推荐人ID
     */
    private Long referrerId;

    /**
     * 推荐人姓名
     */
    private String referrerName;

    /**
     * 推荐人电话
     */
    private String referrerPhone;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 获取增值服务ID
     *
     * @return leads_services_id
     */
    public Long getLeadsServicesId() {
        return leadsServicesId;
    }

    /**
     * 设置增值服务ID
     *
     * @param leadsServicesId
     */
    public void setLeadsServicesId(Long leadsServicesId) {
        this.leadsServicesId = leadsServicesId;
    }

    /**
     * 获取客户手机
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置客户手机
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取客户姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置客户姓名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取客户性别(0-男、1-女)
     *
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置客户性别(0-男、1-女)
     *
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取客户状态(0-报备成功、1-确认有效、2-确认无效、3-签约成功、4-签约失败、5-可以结算、6-结算失败)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置客户状态(0-报备成功、1-确认有效、2-确认无效、3-签约成功、4-签约失败、5-可以结算、6-结算失败)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取所属公司id
     *
     * @return merchanism_id
     */
    public Long getMerchanismId() {
        return merchanismId;
    }

    /**
     * 设置所属公司id
     *
     * @param merchanismId
     */
    public void setMerchanismId(Long merchanismId) {
        this.merchanismId = merchanismId;
    }

    /**
     * 获取推荐人ID
     *
     * @return referrer_id
     */
    public Long getReferrerId() {
        return referrerId;
    }

    /**
     * 设置推荐人ID
     *
     * @param referrerId
     */
    public void setReferrerId(Long referrerId) {
        this.referrerId = referrerId;
    }

    /**
     * 获取推荐人姓名
     *
     * @return referrer_name
     */
    public String getReferrerName() {
        return referrerName;
    }

    /**
     * 设置推荐人姓名
     *
     * @param referrerName
     */
    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName == null ? null : referrerName.trim();
    }

    /**
     * 获取推荐人电话
     *
     * @return referrer_phone
     */
    public String getReferrerPhone() {
        return referrerPhone;
    }

    /**
     * 设置推荐人电话
     *
     * @param referrerPhone
     */
    public void setReferrerPhone(String referrerPhone) {
        this.referrerPhone = referrerPhone == null ? null : referrerPhone.trim();
    }

    /**
     * 获取创建者
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }
}