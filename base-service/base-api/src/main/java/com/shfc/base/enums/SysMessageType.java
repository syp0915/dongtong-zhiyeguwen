package com.shfc.base.enums;

/**
 * @Package: com.shfc.base.domain.SysMessage.java
 * @Description: 系统消息表类型枚举
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/01/10 19:53
 * version v1.0.0
 */
public enum SysMessageType {
    SUBSCRIBE_HOUSE("预约看房", 0),
    ENTRUST_HOUSE("房源委托", 1),
    SCHEDULE_REMIND("日程提醒", 2),
    FUND_SUPERVISION("资金监管", 3),
    SYSTEM_INFORM("系统通知", 4),
    SUBSCRIBE_MY_HOUSE("谁约看我的房子", 5),

    ENTRUST_COWRY("委托宝", 6),
    BROKERAGE_COWRY("佣金宝", 7);


    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    SysMessageType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (SysMessageType type : SysMessageType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public SysMessageType getTypeByValue(int value) {
        for (SysMessageType type : SysMessageType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
