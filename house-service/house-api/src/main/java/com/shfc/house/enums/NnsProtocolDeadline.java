package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.NnsProtocolStatus
 * @Description: 委托协议期限
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:39
 * version V1.0.0
 */
public enum NnsProtocolDeadline {
    //委托期限(0-一个月;1-两个月;2-三个月;3-六个月;)
    ONE_MONTH("一个月", 0),
    TWO_MONTH("两个月", 1),
    THREE_MONTH("三个月", 2),
    SIX_MONTH("六个月", 3);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    NnsProtocolDeadline(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (NnsProtocolDeadline status : NnsProtocolDeadline.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public NnsProtocolDeadline getTypeByValue(int value) {
        for (NnsProtocolDeadline status : NnsProtocolDeadline.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
