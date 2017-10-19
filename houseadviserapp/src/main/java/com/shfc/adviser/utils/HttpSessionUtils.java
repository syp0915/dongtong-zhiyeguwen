package com.shfc.adviser.utils;

import com.shfc.common.spring.SpringContext;
import com.shfc.house.dto.CurrentRealtorDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.shfc.house.service.RealtorService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Package com.fc.realtorAdmin.utils.HttpSessionUtils
 * @Description: session 会话工具类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2016/10/26 16:23
 * version V1.0.0
 */
public class HttpSessionUtils {

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    private static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @Description: 存放会话级别的值
     * @Title putObject
     * @Author  lv bin
     * @Date 2016/10/26 16:29
     * @param  sessionKey, obj
     * @return void
     * @throws
     */
    public static void putObject(String sessionKey, Object obj){
        getSession().setAttribute(sessionKey, obj);
    }

    /**
     * @Description: 根据 session key获取会话值
     * @Title getObject
     * @Author  lv bin
     * @Date 2016/10/26 16:27
     * @param  sessionKey
     * @return T
     * @throws
     */
    public static <T> T  getObject(String sessionKey){
        return  (T)getSession().getAttribute(sessionKey);
    }

    /**
      * @Description: 获取经纪人id
      * @Title getCurrentRealtorId
      * @Author  lv bin
      * @Date 2017/1/11 18:06
      * @param
      * @return Long
      * @throws
      */
    public static Long getCurrentRealtorId(){
        Object object =getSession().getAttribute(AuthSessionUtils.REALTOR_ACCOUNT_ID);
        if(object != null)
            return getObject(AuthSessionUtils.REALTOR_ACCOUNT_ID);
        return null;
    }

    /**
      * @Description: 获取经纪人对象
      * @Title getCurrentRealtor
      * @Author  lv bin
      * @Date 2017/1/16 10:44
      * @param
      * @return
      * @throws
      */
    public static CurrentRealtorDTO getCurrentRealtor(){
        CurrentRealtorDTO realtorDTO = null;
        RealtorService realtorService = SpringContext.getBean( RealtorService.class);
        if(realtorService != null){
            realtorDTO = realtorService.findCurrentRealtorById(getCurrentRealtorId());
        }
        return realtorDTO;
    }
}
