package com.shfc.base.enums;

/**
 * @Package: com.shfc.base.domain.SysMessage.java
 * @Description: 系统消息表用户类型枚举
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/01/10 19:53
 * version v1.0.0
 */
public enum SysMessageUserType {
    REALTOR("经纪人", 1),
    USER("用户", 2);


    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    SysMessageUserType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (SysMessageUserType type : SysMessageUserType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public SysMessageUserType getTypeByValue(int value) {
        for (SysMessageUserType type : SysMessageUserType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
