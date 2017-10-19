package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.NnsProtocolStatusText
 * @Description: 委托协议状态文案
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:39
 * version V1.0.0
 */
public enum NnsProtocolStatusText {
    WAIT_SIGN("等待业主签署", 0),
    SUCCESS_SIGN("剩余X天协议过期", 1),
    REJECT_SIGN("业主已拒绝签署", 2),
    CANCEL_SIGN("业主已撤销协议", 3),
    OVERDUE_SIGN("协议已过期", 4),
    OFFLINE_SIGN("协议已线下签署", 5);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    NnsProtocolStatusText(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (NnsProtocolStatusText status : NnsProtocolStatusText.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public NnsProtocolStatusText getTypeByValue(int value) {
        for (NnsProtocolStatusText status : NnsProtocolStatusText.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
