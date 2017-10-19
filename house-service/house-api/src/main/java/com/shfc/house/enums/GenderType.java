/**
 * @Title: AuditStatus.java
 * @Package com.fc.house.enums
 * @Description: 审核状态
 * Copyright: Copyright (c) 2016 
 * Company:上海房产
 * 
 * @author lvbin
 * @date 2016年9月13日 上午10:11:31
 * @version V1.0
 */
package com.shfc.house.enums;
public enum GenderType {

	MAN("男", 0),
	WOMAN("女", 1),
	SIR("先生", 2),
	LADY("女士", 3);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	GenderType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (GenderType status : GenderType.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public GenderType getTypeByValue(int value) {
		for (GenderType status : GenderType.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
