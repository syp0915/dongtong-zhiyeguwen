package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsOrder.java
 * @Description: 订单表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/10 14:27
 * version v1.1.0
 */
public class LeadsOrder extends BaseBean {
    /**
     * 套餐ID
     */
    private Long comboId;
    /**
     * 经纪人ID
     */
    private Long realtorId;
    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 支付类型（0支付宝1微信）
     */
    private Integer payType;

    /**
     * 订单支付流水号
     */
    private String orderPaySerialNum;

    /**
     * 订单邀请码
     */
    private String invitationCode;

    /**
     * 状态(0待支付1已支付2订单关闭)
     */
    private Integer status;

    /**
     * 订单财务状态（0未到账，1已到账）
     */
    private Integer financialStatus;

    /**
     * 订单支付时间
     */
    private Date payTime;

    /**
     * 获取套餐ID
     *
     * @return combo_id
     */
    public Long getComboId() {
        return comboId;
    }

    /**
     * 设置套餐ID
     *
     * @param comboId
     */
    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取订单编号
     *
     * @return order_num
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单编号
     *
     * @param orderNum
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 获取支付类型（0支付宝1微信）
     *
     * @return pay_type
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付类型（0支付宝1微信）
     *
     * @param payType
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取订单支付流水号
     *
     * @return order_pay_serial_num
     */
    public String getOrderPaySerialNum() {
        return orderPaySerialNum;
    }

    /**
     * 设置订单支付流水号
     *
     * @param orderPaySerialNum
     */
    public void setOrderPaySerialNum(String orderPaySerialNum) {
        this.orderPaySerialNum = orderPaySerialNum == null ? null : orderPaySerialNum.trim();
    }

    /**
     * 获取订单邀请码
     *
     * @return invitation_code
     */
    public String getInvitationCode() {
        return invitationCode;
    }

    /**
     * 设置订单邀请码
     *
     * @param invitationCode
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    /**
     * 获取状态(0待支付1已支付2订单关闭)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0待支付1已支付2订单关闭)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取订单财务状态（0未到账，1已到账）
     *
     * @return financial_status
     */
    public Integer getFinancialStatus() {
        return financialStatus;
    }

    /**
     * 设置订单财务状态（0未到账，1已到账）
     *
     * @param financialStatus
     */
    public void setFinancialStatus(Integer financialStatus) {
        this.financialStatus = financialStatus;
    }

    /**
     * 获取订单支付时间
     *
     * @return pay_time
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置订单支付时间
     *
     * @param payTime
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/10 14:27
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comboId=").append(comboId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", payType=").append(payType);
        sb.append(", orderPaySerialNum=").append(orderPaySerialNum);
        sb.append(", invitationCode=").append(invitationCode);
        sb.append(", status=").append(status);
        sb.append(", financialStatus=").append(financialStatus);
        sb.append(", payTime=").append(payTime);
        sb.append("]");
        return sb.toString();
    }
}