package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsMemberCombo.java
 * @Description: 会员套餐表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/10 14:25
 * version v1.1.0
 */
public class LeadsCombo extends BaseBean {
    /**
     * 套餐名称
     */
    private String comboName;

    /**
     * 套餐价格
     */
    private BigDecimal comboPrice;

    /**
     * 套餐周期/月
     */
    private Integer periodUnit;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 失效日期
     */
    private Date overdueDate;

    /**
     * 状态(0正常1失效)
     */
    private Integer status;

    /**
     * 获取套餐名称
     *
     * @return combo_name
     */
    public String getComboName() {
        return comboName;
    }

    /**
     * 设置套餐名称
     *
     * @param comboName
     */
    public void setComboName(String comboName) {
        this.comboName = comboName == null ? null : comboName.trim();
    }

    /**
     * 获取套餐价格
     *
     * @return combo_price
     */
    public BigDecimal getComboPrice() {
        return comboPrice;
    }

    /**
     * 设置套餐价格
     *
     * @param comboPrice
     */
    public void setComboPrice(BigDecimal comboPrice) {
        this.comboPrice = comboPrice;
    }

    /**
     * 获取套餐周期/月
     *
     * @return period_unit
     */
    public Integer getPeriodUnit() {
        return periodUnit;
    }

    /**
     * 设置套餐周期/月
     *
     * @param periodUnit
     */
    public void setPeriodUnit(Integer periodUnit) {
        this.periodUnit = periodUnit;
    }

    /**
     * 获取生效日期
     *
     * @return effective_date
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 设置生效日期
     *
     * @param effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 获取失效日期
     *
     * @return overdue_date
     */
    public Date getOverdueDate() {
        return overdueDate;
    }

    /**
     * 设置失效日期
     *
     * @param overdueDate
     */
    public void setOverdueDate(Date overdueDate) {
        this.overdueDate = overdueDate;
    }

    /**
     * 获取状态(0正常1失效)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0正常1失效)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/10 14:25
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comboName=").append(comboName);
        sb.append(", comboPrice=").append(comboPrice);
        sb.append(", periodUnit=").append(periodUnit);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", overdueDate=").append(overdueDate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}