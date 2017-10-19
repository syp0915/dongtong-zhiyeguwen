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
public enum RealtorBindWxStatus {

	Binding("已绑定", 0),
	UnBinding("已解绑", 1);

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	RealtorBindWxStatus(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(Integer val) {
		if (val != null) {
			int value = val;
			for (RealtorBindWxStatus status : RealtorBindWxStatus.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public RealtorBindWxStatus getTypeByValue(int value) {
		for (RealtorBindWxStatus status : RealtorBindWxStatus.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
