package com.shfc.house.enums;

/**
 * @author sunyaping
 * @Package com.shfc.house.enums
 * @Description :客户状态 0-报备成功、1-确认有效、2-确认无效、3-签约成功、4-签约失败、5-可以结算、6-结算失败
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 16:24
 * version V1.0.0
 **/
public enum LeadCustomerStatus {

    REPORT_SUCCESS("报备成功", 0),
    AFFIRM_VALID("确认有效", 1),
    AFFIRM_INVALID("确认无效",2),
    SIGN_SUCCESS("签约成功", 3),
    SIGN_FAILURE("签约失败", 4),
    CAN_SETTLEMENT("可以结算", 5),
    SETTLEMENT_FAILURE("结算失败", 6);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    LeadCustomerStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (LeadCustomerStatus status : LeadCustomerStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public LeadCustomerStatus getTypeByValue(int value) {
        for (LeadCustomerStatus status : LeadCustomerStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
