package com.shfc.base.enums;

/**
 * Created by SYP on 2017/5/19.
 */
public enum FloorType {
    LOW("低层",1),
    MIDDLE("中层",2),
    HIGN("高层",3);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    FloorType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (FloorType type : FloorType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public FloorType getTypeByValue(int value) {
        for (FloorType type : FloorType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
