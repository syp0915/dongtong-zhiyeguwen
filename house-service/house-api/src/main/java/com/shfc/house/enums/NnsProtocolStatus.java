package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.NnsProtocolStatus
 * @Description: 委托协议状态
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:39
 * version V1.0.0
 */
public enum NnsProtocolStatus {
    //协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
    WAIT_SIGN("等待签约", 0),
    SUCCESS_SIGN("签约成功", 1),
    REJECT_SIGN("签约已拒绝", 2),
    CANCEL_SIGN("签约已撤销", 3),
    OVERDUE_SIGN("签约已过期", 4),
    OFFLINE_SIGN("协议已线下签署", 5);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    NnsProtocolStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (NnsProtocolStatus status : NnsProtocolStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public NnsProtocolStatus getTypeByValue(int value) {
        for (NnsProtocolStatus status : NnsProtocolStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
