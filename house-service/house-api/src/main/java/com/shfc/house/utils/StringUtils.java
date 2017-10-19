package com.shfc.house.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/11 下午3:11.
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     * @param str
     * null、“ ”、“null”都返回true
     * @return
     */
    public static boolean isNullString(String str) {
        return (null == str || org.springframework.util.StringUtils.isEmpty(str.trim()) || "null".equals(str.trim().toLowerCase())) ? true : false;
    }

    /**
     * 手机号中间四位加*号
     * @param phone
     * @return
     */
    public static String phoneNumberAddasterisk(String phone){
        return phone.substring(0, 3) + "****" + phone.substring(7, 11);
    }

    /**
     * 校验手机号
     * @param num
     * @return
     */
    public static boolean checkPhone(final String num){
        if(inputIsNum(num)){
            if(num.length()==11&& num.startsWith("1")){
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * Created by zhoujun on 2014/5/30
     * 验证输入的是否是数字
     * @param num 字符串数字
     * @return
     *
     */
    public static boolean inputIsNum(final String num) {
        boolean flag = true;
        try {
            Long.valueOf(num);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 国内手机号正则表达式校验
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    /**
     * 电子邮件正则表达式校验
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean isEmailAddressLegal(String str) throws PatternSyntaxException {
        String regExp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 获取指定长度随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取本机ip
     * @return
     */
    public static String getClientIp(){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * map对象转xml字符串，微信专用
     * @param map
     * @return
     */
    public static String map2XmlString(Map<String, Object> map) {
        String xmlResult = "";
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : map.keySet()) {
            System.out.println(key + "========" + map.get(key));

            String value = "<![CDATA[" + map.get(key) + "]]>";
            sb.append("<" + key + ">" + value + "</" + key + ">");
            System.out.println();
        }
        sb.append("</xml>");
        xmlResult = sb.toString();

        return xmlResult;
    }
}
