package com.shfc.house.enums;

/**
 * @Title: HouseType.java
 * @Package com.shfc.house.enums
 * @Description: 房产证类型 (0-未满两年 1-满两年 2-满五年)
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author lvbin
 * @date 2016年9月13日 上午10:43:24
 * @version V1.0
 */
public enum HouseType {
	UNDER_TWO_YEAR("未满两年", 0),
	FULL_TWO_YEAR("满两年", 1),
	FULL_FIVE_YEAR("满五年", 2);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	HouseType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (HouseType type : HouseType.values()) {
				if (type.value == value) {
					return type.name;
				}
			}
		}
		return "";
	}

	public HouseType getTypeByValue(int value) {
		for (HouseType type : HouseType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
