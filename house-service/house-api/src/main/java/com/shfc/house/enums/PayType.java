package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.PayType
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/13 14:14
 * version V1.0.0
 */
public enum  PayType {
    ALIPAY("aliPay",0),
    WXPAY("wxPay",1);
    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    PayType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (PayType type : PayType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public PayType getTypeByValue(int value) {
        for (PayType type : PayType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
