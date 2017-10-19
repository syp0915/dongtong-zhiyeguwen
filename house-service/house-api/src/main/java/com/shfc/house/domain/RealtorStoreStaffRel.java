package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorStoreStaffRel.java
 * @Description: 经纪人门店和经纪人关联表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/01/11 14:59
 * version v1.0.0
 */
public class RealtorStoreStaffRel extends BaseBean {
    /**
     * 经纪人门店ID
     */
    private Long storeId;

    /**
     * 经纪人统一账户表ID
     */
    private Long realtorId;

    /**
     * 状态(0.有效、1.无效)
     */
    private Integer status;

    /**
     * 获取经纪人门店ID
     *
     * @return store_id
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * 设置经纪人门店ID
     *
     * @param storeId
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取经纪人统一账户表ID
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人统一账户表ID
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取状态(0.有效、1.无效)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0.有效、1.无效)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storeId=").append(storeId);
        sb.append(", realtorId=").append(realtorId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}