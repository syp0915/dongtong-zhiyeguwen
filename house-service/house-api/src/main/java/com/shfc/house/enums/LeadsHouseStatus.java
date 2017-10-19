package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.LeadsHouseStatus
 * @Description: 状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 12:05
 * version V1.0.0
 */
public enum LeadsHouseStatus {
    STAY_AUDIT("待审核", 0),
    EFFECT("有效", 1),
    SOLD("已售", 2),
    STOP("暂缓", 3),
    UNKNOWN("未知", 4),
    NO_EFFECT("房源无效", 5),
    NO_PHONE_EFFECT("电话无效", 6);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    LeadsHouseStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (LeadsHouseStatus status : LeadsHouseStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public LeadsHouseStatus getTypeByValue(int value) {
        for (LeadsHouseStatus status : LeadsHouseStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
