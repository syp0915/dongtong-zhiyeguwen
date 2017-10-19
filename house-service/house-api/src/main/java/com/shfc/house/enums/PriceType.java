package com.shfc.house.enums;

/**
 * @Title: PriceType.java
 * @Package com.shfc.house.enums
 * @Description: 房价类型	（0-实际到手 1-税费各付）
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author lvbin
 * @date 2016年9月13日 上午10:43:24
 * @version V1.0
 */
public enum PriceType {
	ACTUAL_HAND("实际到手", 0),
	DUTCH_TAX("税费各付", 1);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	PriceType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (PriceType type : PriceType.values()) {
				if (type.value == value) {
					return type.name;
				}
			}
		}
		return "";
	}

	public PriceType getTypeByValue(int value) {
		for (PriceType type : PriceType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
