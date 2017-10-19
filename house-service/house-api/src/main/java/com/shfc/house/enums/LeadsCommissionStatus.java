package com.shfc.house.enums;

/**
 * @author sunyaping
 * @Package com.shfc.house.enums
 * @Description :佣金-订单状态 0-待结算-未申请、1-待结算-已申请、2-已结算
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 14:03
 * version V1.0.0
 **/
public enum LeadsCommissionStatus {

    SETTLEMENT_COMMISSION("待结算-未申请", 0),
    COMMISSION_IN_SETTLEMENT("待结算-已申请", 1),
    SETTLED_COMMISSION("已结算", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    LeadsCommissionStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (LeadsCommissionStatus status : LeadsCommissionStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public LeadsCommissionStatus getTypeByValue(int value) {
        for (LeadsCommissionStatus status : LeadsCommissionStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
