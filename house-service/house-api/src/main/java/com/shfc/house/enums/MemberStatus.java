
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
public enum MemberStatus {

	OPEN("正常", 0),
	EXPIRE("过期", 1),
	NOT_OPEN("未开通",2);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	MemberStatus(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (MemberStatus status : MemberStatus.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public MemberStatus getTypeByValue(int value) {
		for (MemberStatus status : MemberStatus.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
