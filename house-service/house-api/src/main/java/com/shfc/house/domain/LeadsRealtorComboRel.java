package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsRealtorComboRel.java
 * @Description: 经纪人购买套餐关系表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/10 14:28
 * version v1.1.0
 */
public class LeadsRealtorComboRel extends BaseBean {
    /**
     * 经纪人ID
     */
    private Long realtorId;

    /**
     * 套餐表ID
     */
    private Long comboId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 获取经纪人ID
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人ID
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取套餐表ID
     *
     * @return combo_id
     */
    public Long getComboId() {
        return comboId;
    }

    /**
     * 设置套餐表ID
     *
     * @param comboId
     */
    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    /**
     * 获取订单ID
     *
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/10 14:28
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", realtorId=").append(realtorId);
        sb.append(", comboId=").append(comboId);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}