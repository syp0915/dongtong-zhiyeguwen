package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsHouseCall.java
 * @Description: 房源拨打记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:16
 * version v1.1.0
 */
public class LeadsHouseCall extends BaseBean {
    /**
     * 二手房id
     */
    private Long leadsHouseId;

    /**
     * 经纪人id
     */
    private Long realtorId;

    /**
     * 业主id
     */
    private Long leadsOwnerId;

    /**
     * 状态(0-正常 1-失效)
     */
    private Integer status;

    /**
     * 获取二手房id
     *
     * @return leads_house_id
     */
    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    /**
     * 设置二手房id
     *
     * @param leadsHouseId
     */
    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }

    /**
     * 获取经纪人id
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人id
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取业主id
     *
     * @return leads_owner_id
     */
    public Long getLeadsOwnerId() {
        return leadsOwnerId;
    }

    /**
     * 设置业主id
     *
     * @param leadsOwnerId
     */
    public void setLeadsOwnerId(Long leadsOwnerId) {
        this.leadsOwnerId = leadsOwnerId;
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
     * @Date 2017/04/06 14:16
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
        sb.append(", realtorId=").append(realtorId);
        sb.append(", leadsOwnerId=").append(leadsOwnerId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}