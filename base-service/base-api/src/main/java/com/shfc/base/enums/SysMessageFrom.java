package com.shfc.base.enums;

/**
 * @Package: com.shfc.base.domain.SysMessage.java
 * @Description: 系统消息表,消息来源枚举
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/01/10 19:53
 * version v1.0.0
 */
public enum SysMessageFrom {
    SYS("系统推送",0),
    SHFC("上海房产", 1),
    TV_997("997项目", 2);



    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    SysMessageFrom(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (SysMessageFrom type : SysMessageFrom.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public SysMessageFrom getTypeByValue(int value) {
        for (SysMessageFrom type : SysMessageFrom.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
