package com.shfc.base.enums;

/**
 * Created by SYP on 2017/5/19.
 */
public enum Orientation {
    EAST("东",1),
    SOUTH("南",2),
    WEST("西",3),
    NORTH("北",4),
    SOUTHEAST("东南",5),
    NORTHEAST("东北",6),
    SOUTHWEST("西南",7),
    NORTHWEST("西北",8),
    WESTEAST("东西",9),
    NORTHSOUTH("南北",10);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    Orientation(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (Orientation type : Orientation.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public Orientation getTypeByValue(int value) {
        for (Orientation type : Orientation.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
