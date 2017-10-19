package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsCustomerFlow.java
 * @Description: 报备客户状态流表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
public class LeadsCustomerFlow extends BaseBean {
    /**
     * 报备客户表ID
     */
    private Long leadsCustomerId;

    /**
     * 客户状态(0-报备成功、1-确认有效、2-确认无效、3-签约成功、4-签约失败、5-可以结算、6-结算失败)
     */
    private Integer status;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 获取报备客户表ID
     *
     * @return leads_customer_id
     */
    public Long getLeadsCustomerId() {
        return leadsCustomerId;
    }

    /**
     * 设置报备客户表ID
     *
     * @param leadsCustomerId
     */
    public void setLeadsCustomerId(Long leadsCustomerId) {
        this.leadsCustomerId = leadsCustomerId;
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