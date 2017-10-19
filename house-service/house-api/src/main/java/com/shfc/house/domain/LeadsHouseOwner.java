package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsHouseOwner.java
 * @Description: 业主表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:09
 * version v1.1.0
 */
public class LeadsHouseOwner extends BaseBean {
    /**
     * 房源id
     */
    private Long leadsHouseId;

    /**
     * 业主
     */
    private String owner;

    /**
     * 性别(0-男 1-女)
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 产证号码
     */
    private String ownerNo;

    /**
     * 状态(0-正常 1-失效)
     */
    private Integer status;

    /**
     * 获取房源id
     *
     * @return leads_house_id
     */
    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    /**
     * 设置房源id
     *
     * @param leadsHouseId
     */
    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }

    /**
     * 获取业主
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置业主
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * 获取性别(0-男 1-女)
     *
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(0-男 1-女)
     *
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取手机号
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取产证号码
     *
     * @return owner_no
     */
    public String getOwnerNo() {
        return ownerNo;
    }

    /**
     * 设置产证号码
     *
     * @param ownerNo
     */
    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo == null ? null : ownerNo.trim();
    }

    /**
     * 获取状态(0-正常 1-失效)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0-正常 1-失效)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/06 14:09
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leadsHouseId=").append(leadsHouseId);
        sb.append(", owner=").append(owner);
        sb.append(", gender=").append(gender);
        sb.append(", mobile=").append(mobile);
        sb.append(", ownerNo=").append(ownerNo);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}