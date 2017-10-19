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
public enum AccountType {

	Realtor("经纪人", 0),
	User("用户", 1);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	AccountType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (AccountType status : AccountType.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public AccountType getTypeByValue(int value) {
		for (AccountType status : AccountType.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
