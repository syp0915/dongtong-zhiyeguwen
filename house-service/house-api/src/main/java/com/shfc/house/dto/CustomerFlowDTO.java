package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description:状态流
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-19 14:46
 * version V1.0.0
 **/
public class CustomerFlowDTO implements Serializable{

    private static final long serialVersionUID = -4279933066021336522L;

    /**
     * 客户状态
     */
    private Integer customerStatus;


    /**
     * 客户状态变化时间
     */
    private String changeTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }
}
