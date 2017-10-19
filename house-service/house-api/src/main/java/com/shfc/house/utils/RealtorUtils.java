package com.shfc.house.utils;

public class RealtorUtils {
	/**
	 * 生成编号
	 * @return
	 */
	public static String createCode( String prefix){
		StringBuffer retVal = new StringBuffer();
		int num = java.util.concurrent.ThreadLocalRandom.current().nextInt(99999999);
		return retVal.append(prefix).append(String.format("%04d", num)).toString();
	}

	public static String familyNameSplit(String name){
		if(name.length()==2 || name.length()==3){
			return name.substring(0,1);
		}else if(name.length()>=3){
			return name.substring(0,2);
		}
		return name;
	}
}
