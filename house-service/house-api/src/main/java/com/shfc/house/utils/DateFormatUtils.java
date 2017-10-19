package com.shfc.house.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Package com.shfc.house.utils.DateFormatUtils
 * @Description: 格式化时间
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/20 16:57
 * version V1.0.0
 */
public class DateFormatUtils {

    private final static String DATE_TIME_FORMAT_14 = "yyyy-MM-dd HH:mm:ss";
    private final static String DATE_FORMAT_8 = "yyyy-MM--dd";
    /**
     * 传入yyyy-MM-dd HH:mm:ss格式字符串，发布时间显示规则：
     *
     * 1小时内，x分钟前
     *
     * 24小时以内，显示x小时前
     *
     * 超过一天显示 具体发布日期 2016-11-11
     *
     * @param
     * @return
     */
    public static String getTimesToNow(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        String returnText = null;

        try {
            long from = sdf.parse(beginDate).getTime();
            long end = sdf.parse(now).getTime();
            int days = (int) ((end - from) / (1000 * 60 * 60 * 24));
            if (days == 0) {// 24小时以内，显示x小时前
                int hours = (int) (end - from) / (1000 * 60 * 60);
                if (hours == 0) {// 1小时内，x分钟前
                    int minutes = (int) (end - from) / (1000 * 60);
                    if (minutes == 0) {
                        returnText = "刚刚";
                    } else {
                        returnText = minutes + "分钟前";
                    }
                } else {
                    returnText = hours + "小时前";
                }
            } else {// 超过一天显示 具体发布日期 2016-11-11
                returnText = sdf.format(sdf.parse(beginDate)).substring(0, 10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnText;
    }

    /**
     * 传入yyyy-MM-dd HH:mm:ss格式字符串，发布时间显示规则：
     * 当日的显示今天
     * 24小时以后，显示明天
     * 48小时以后，显示后天
     * 当日时间之后的显示 具体发布日期 2016-11-11
     *
     * @param
     * @return
     */
    public static String getFormateTimeToNow(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String now = sdf.format(new Date());
        StringBuffer returnText = new StringBuffer();
        try {
            Calendar calendar = Calendar.getInstance();
            long from = sdf.parse(beginDate).getTime();
            calendar.setTimeInMillis(from);
            long end = sdf.parse(now).getTime();
            int days = (int) ((end - from) / (1000 * 60 * 60 * 24));
            int house = calendar.get(Calendar.HOUR_OF_DAY);
            int minute  = calendar.get(Calendar.MINUTE);
            if(days == 0){
                returnText.append("今天 ").append(house).append(":").append(minute);
            } else if (days == -1) { // 24小时以后，显示明天
                returnText.append("明天 ").append(house).append(":").append(minute);
            } else if(days == -2){
                returnText.append("后天 ").append(house).append(":").append(minute);
            }else {	// 其他时间段显示具体发布日期
                returnText = returnText.append(sdf1.format(sdf1.parse(beginDate)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnText.toString();
    }



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

    /**
     * 计算两个时间的分钟数
     * @param beginDate
     * @return
     */
    public static Integer calculateMinute(String beginDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        try {
            long from = sdf.parse(beginDate).getTime();
            long end = sdf.parse(now).getTime();
            int minutes = (int) (end - from) / (1000 * 60);
            return minutes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
