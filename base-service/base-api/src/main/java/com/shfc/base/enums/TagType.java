package com.shfc.base.enums;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 标签类型枚举
 *
 * @author wky
 * @version V1.0
 * @create 2016-12-29 18:13
 **/
public enum TagType {
    HOUSE_TAG("二手房标签", 2),
    CUSTOMER_TAG("经纪人客户标签", 4);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    TagType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (TagType type : TagType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public TagType getTypeByValue(int value) {
        for (TagType type : TagType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
