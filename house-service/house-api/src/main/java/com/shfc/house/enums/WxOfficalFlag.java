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
public enum WxOfficalFlag {

	SFJJR("上房经纪人", "SFJJR"),
	AJSH("安居上海", "AJSH");

	private final String name;
	private final String value;

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	WxOfficalFlag(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public static String getNameByValue(String val) {
		if (val != null) {
			String value = val;
			for (WxOfficalFlag status : WxOfficalFlag.values()) {
				if (status.value == value) {
					return status.name;
				}
			}
		}
		return "";
	}

	public WxOfficalFlag getTypeByValue(String value) {
		for (WxOfficalFlag status : WxOfficalFlag.values()) {
			if (status.value == value) {
				return status;
			}
		}
		return null;
	}

}
