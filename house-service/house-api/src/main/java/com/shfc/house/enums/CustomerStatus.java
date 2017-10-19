package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.CustomerStatus
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wuky
 * @date 2017/4/13 14:14
 * version V1.0.0
 */
public enum CustomerStatus {
    SUCCESS("SUCCESS",0),//报备成功
    CONFIRM("CONFIRM",1),//确认有效
    INVALID("INVALID",2),//确认无效
    SIGN("SIGN",3)//签约成功
    ;
    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    CustomerStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (CustomerStatus type : CustomerStatus.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public CustomerStatus getTypeByValue(int value) {
        for (CustomerStatus type : CustomerStatus.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
