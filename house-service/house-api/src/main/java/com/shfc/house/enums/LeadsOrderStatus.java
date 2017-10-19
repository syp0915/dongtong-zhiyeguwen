package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.LeadsOrderType
 * @Description: 订单支付状态
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 16:38
 * version V1.0.0
 */
public enum LeadsOrderStatus {
    NO_PAYMENT("待支付", 0),
    HAVE_PAID("已支付", 1),
    ORDER_CLOSE("订单关闭", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    LeadsOrderStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (LeadsOrderStatus type : LeadsOrderStatus.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public LeadsOrderStatus getTypeByValue(int value) {
        for (LeadsOrderStatus type : LeadsOrderStatus.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
