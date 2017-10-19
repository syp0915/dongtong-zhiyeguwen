package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description：结算明细
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 14:30
 * version V1.0.0
 **/
public class SettlementDetailDTO extends PersonalDTO implements Serializable{


    private static final long serialVersionUID = -2916560000655777990L;


    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态
     */
    private Integer orderStatus;


    /**
     * 佣金
     */
    private BigDecimal commission;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}
