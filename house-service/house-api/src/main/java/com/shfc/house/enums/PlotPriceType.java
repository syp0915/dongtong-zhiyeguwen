package com.shfc.house.enums;

/**
 * @Title: PlotPriceType.java
 * @Package com.shfc.house.enums
 * @Description: 交易趋势类型
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author lvbin
 * @date 2016年9月13日 上午10:43:24
 * @version V1.0
 */
public enum PlotPriceType {
	PLOT_TREND("小区行情", 0),
	BLOCK_TREND("板块行情", 1),
	DISTRICT_TREND("区县行情", 2),
	CITY_TREND("城市行情", 3);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	PlotPriceType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (PlotPriceType type : PlotPriceType.values()) {
				if (type.value == value) {
					return type.name;
				}
			}
		}
		return "";
	}

	public PlotPriceType getTypeByValue(int value) {
		for (PlotPriceType type : PlotPriceType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
