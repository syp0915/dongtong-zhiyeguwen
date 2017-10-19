package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.NnsHouseStatus
 * @Description: 房源在状态--状态(0-待上架 1-上架 2-下架 )
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/10 10:41
 * version V1.0.0
 */
public enum  NnsHouseStatus {
    STAY_PUTAWAY("待上架", 0),
    PUTAWAY("已上架", 1),
    SOLD_OUT("已下架", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    NnsHouseStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (NnsHouseStatus status : NnsHouseStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public NnsHouseStatus getTypeByValue(int value) {
        for (NnsHouseStatus status : NnsHouseStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
