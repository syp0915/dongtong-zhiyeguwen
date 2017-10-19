package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsCommission.java
 * @Description: 佣金表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
public class LeadsCommission extends BaseBean {
    /**
     * 报备客户表ID
     */
    private Long leadsCustomerId;

    /**
     * 订单编号
     */
    private String number;

    /**
     * 佣金金额
     */
    private BigDecimal commission;

    /**
     * 订单状态(0-待结算-未申请、1-待结算-已申请、2-已结算)
     */
    private Integer status;

    private Long creator;

    private Date moidfyTime;

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
     * 获取订单编号
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置订单编号
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 获取佣金金额
     *
     * @return commission
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * 设置佣金金额
     *
     * @param commission
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * 获取订单状态(0-待结算-未申请、1-待结算-已申请、2-已结算)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态(0-待结算-未申请、1-待结算-已申请、2-已结算)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return moidfy_time
     */
    public Date getMoidfyTime() {
        return moidfyTime;
    }

    /**
     * @param moidfyTime
     */
    public void setMoidfyTime(Date moidfyTime) {
        this.moidfyTime = moidfyTime;
    }
}