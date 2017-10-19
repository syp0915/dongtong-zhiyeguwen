package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description :个人中心公用属性
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 15:41
 * version V1.0.0
 **/
public class PersonalDTO implements Serializable{

    private static final long serialVersionUID = 3870059026033315879L;


    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 服务名称
     */
    private String servicesName;

    /**
     * 所属公司名称
     */
    private String merchanismName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getMerchanismName() {
        return merchanismName;
    }

    public void setMerchanismName(String merchanismName) {
        this.merchanismName = merchanismName;
    }
}
