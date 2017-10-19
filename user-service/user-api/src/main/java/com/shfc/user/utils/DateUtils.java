package com.shfc.user.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/11 下午4:21.
 */
public class DateUtils {

    private final static String DATE_TIME_FORMAT_14 = "yyyy-MM-dd HH:mm:ss";
    private final static String DATE_FORMAT_8 = "yyyy-MM--dd";

    /**
     * 给指定日期加上指定月数，得到计算后的日期，时间指定为23:59:59
     * @Author: Jianguo_li
     * @Date 2017/1/11 下午4:24
     * @Param [sourceDate, monthCount]
     * @Return java.utils.Date
     */
    public static Date addMonth(Date sourceDate, int monthCount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.MONTH, monthCount);
        //calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new SimpleDateFormat(DATE_TIME_FORMAT_14).format(addMonth(date, 1)));
    }
}
