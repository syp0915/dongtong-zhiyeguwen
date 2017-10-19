package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description :客户详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 15:55
 * version V1.0.0
 **/
public class CustomerDetailDTO extends PersonalDTO implements Serializable{


    private static final long serialVersionUID = 2080315676051454331L;


    /**
     * 客户性别 0-男 1-女
     */
    private Integer customerGender;

    /**
     * 客户状态
     */
    private Integer customerStatus;


    /**
     * 客户状态流时间集合
     */
    private List<CustomerFlowDTO> customerFlowList;

    /**
     * 佣金奖励
     */
    private String commissionAward;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public List<CustomerFlowDTO> getCustomerFlowList() {
        return customerFlowList;
    }

    public void setCustomerFlowList(List<CustomerFlowDTO> customerFlowList) {
        this.customerFlowList = customerFlowList;
    }

    public String getCommissionAward() {
        return commissionAward;
    }

    public void setCommissionAward(String commissionAward) {
        this.commissionAward = commissionAward;
    }
}
