package com.shfc.house.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseServiceImpl {

	protected final static String SUCCESS = "操作成功";
	protected final static String ERROR_REQUEST_PARAMS_EXCEPTION = "请求参数异常";
	protected final static String ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST = "请求参数错误或请求对象不存在";
	protected final static String ERROR_DB_OPERATE_EXCEPTION = "数据库操作异常";
	protected final static String ERROR_PRARMS_FORMAT_EXCEPTION = "请求参数数据格式错误";
	protected final static String ERROR_DATA_FORMAT_EXCEPTION = "数据异常";
	protected final static String ERROR_DB_DATA_EXCEPTION = "数据库数据异常";
	protected final static String ERROR_PARSE_DATA_EXCEPTION = "数据解析异常";
	protected final static String ERROR_INNER_SYSTEM_ERROR = "内部系统异常";

	protected final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	
	protected boolean isNullOrEmpty(String str){
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
	
	protected String checkStringMapObject(Object object){
		if (object == null) {
			return "";
		}
		return object.toString();
	}
	
	protected String checkDecimalMapObject(Object object){
		if (object == null) {
			return "0.00";
		}
		return object.toString();
	}
	
	protected String checkIntMapObject(Object object){
		if (object == null) {
			return "0";
		}
		return object.toString();
	}
	
	protected String checkDateTimeMapObject(Object object) throws ParseException{
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if (object == null) {
			return "1970-01-01 12:00:00";
		}
		return sdf.format((Date)object);
	}

	protected String checkDateTimeMapObjectAviableNull(Object object) throws ParseException{
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if (object == null) {
			return "";
		}else {
			return sdf.format((Date)object);
		}
	}
	
	protected String checkDateMapObject(Object object) throws ParseException{
		String DATE_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if (object == null) {
			return "1970-01-01";
		}
		return sdf.format((Date)object);
	}

	protected String checkDateMapObjectAviableNull(Object object) throws ParseException{
		String DATE_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if (object == null) {
			return "";
		}else {
			return sdf.format((Date)object);
		}
	}
}
