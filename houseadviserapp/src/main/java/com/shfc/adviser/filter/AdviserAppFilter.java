package com.shfc.adviser.filter;

import com.alibaba.fastjson.JSON;
import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.errorCode.ErrorCode;
import com.shfc.adviser.utils.AuthSessionUtils;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.CurrentRealtorDTO;
import com.shfc.house.enums.RealtorStatus;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.adviser.filter.AdviserAppFilter
 * @Description: 过滤器
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 17:11
 * version V1.0.0
 */
public class AdviserAppFilter implements ContainerRequestFilter {

    @Context
    private static HttpServletRequest servletRequest;
    private static ResultDO<String> resultDO = null;
    private final static Long ACTIVE_TIME = 2592000L; // 有效时间 产品要求登录成功有效期就设置30天
    private static String[] interceptPaths = {"/api/nnsHouse",
            "/api/realtor/",
            "/api/entrustProtocol/",
            "/api/retroaction/",
            "/api/wnl",
            "/api/leadsHouse",
            "/api/member",
            "/api/order",
            "/api/building",
            "/api/service/",
            "/api/personal/",
            "/api/poster",
            "/api/realtorHouse"}; // 拦截路径

    private String[] excludeCheckUrls = {"/api/realtor/smsPush",
            "/api/leadsHouse/h5Info",
            "/api/leadsHouse/h5Grant",
            "/api/leadsHouse/redis",
            "/api/realtor/queryCompanyByKeyword",
            "/api/realtor/queryStoreByKeyword",
            "/api/building/list",
            "/api/service/h5/leadsService/",
            "/api/poster/templateList"}; // 免登陆接口

    public static final Logger LOGGER = Logger.getLogger(AdviserAppFilter.class);

    private static List<String> interceptPathList = null; // 拦截路径

    static {
        resultDO = new ResultDO<String>();
        resultDO.setErrCode(ErrorCode.UN_LOGIN);
    }

    /**
     * @return java.lang.Boolean
     * @throws
     * @Description: 拦截路径
     * @Title checkLogin
     * @Author lv bin
     * @Date 2016/10/28 15:12
     */
    public Boolean checkLogin() {

        if(interceptPathList == null){
            String contextPath = servletRequest.getContextPath();
            interceptPathList = new ArrayList<String>(interceptPaths.length);
            for (int i = 0; i < interceptPaths.length; i++) {
                interceptPathList.add(contextPath.concat(interceptPaths[i]));
            }
        }

        String requestURI = servletRequest.getRequestURI();
        for (String path : interceptPathList) {
            if (requestURI.startsWith(path))
                return true;
        }
        return false;
    }

    /**
     * @return java.lang.Boolean
     * @throws
     * @Description: 免登陆接口
     * @Title checkUrl
     * @Author lv bin
     * @Date 2016/10/28 15:12
     */
    public Boolean checkUrl() {
        if (excludeCheckUrls.length > 0) {
            String requestURI = servletRequest.getRequestURI();
            for (String exUrl : excludeCheckUrls) {
                if (requestURI.contains(exUrl)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        String object = request.getEntity(String.class);
        LOGGER.info("请求参数-----------" + object);
        request.setEntity(String.class, String.class, null, null, null, object);

        //版本检查，非v3.0.0全部返回错误
        String requestURI = servletRequest.getRequestURI();
        LOGGER.info("URI------------------>" + requestURI);
        String[] arrString = requestURI.split("/");
        String version = arrString[arrString.length - 1];
        LOGGER.info("version------>" + version);
        if (version.compareTo("v3.0.0")<0){
            resultDO.setErrCode(ErrorCode.FORCE_UPDATE_TO_3_0_0);
            Response response = Response.ok(JSON.toJSONString(resultDO)).status(401).type(MediaType.APPLICATION_JSON).build();
            throw new WebApplicationException(response);
        }

        if (checkLogin() && checkUrl()) {
            String tokenKey = null; // 标识令牌
            String[] arrs = object.split("&");
            for (String strs : arrs) {
                String[] strs2 = strs.split("=");
                for (int i = 0; i < strs2.length; i++) {
                    if (strs2[0].equals("tokenKey")) {
                        if (strs2[1] != null && !strs2[1].equals("")) {
                            tokenKey = strs2[1].trim();
                        }
                    }
                }
            }

            if (!StringUtils.isEmpty(tokenKey) && RedisUtil.get(tokenKey) != null) {
                CurrentRealtorDTO currentRealtorDTO = HttpSessionUtils.getCurrentRealtor();
                if(currentRealtorDTO != null && currentRealtorDTO.getStatus()!=null){
                    if(currentRealtorDTO.getStatus()!=null && currentRealtorDTO.getStatus().intValue()== RealtorStatus.CANCEL.getValue()){
                        resultDO.setErrCode(ErrorCode.UN_LOGIN);
                        Response response = Response.ok(JSON.toJSONString(resultDO)).status(401).type(MediaType.APPLICATION_JSON).build();
                        throw new WebApplicationException(response);
                    }/*else if(currentRealtorDTO.getStatus()!=null && currentRealtorDTO.getStatus().intValue()==RealtorStatus.PASS_AUDIT.getValue()){
                        // 设置会话的realtor
                        HttpSessionUtils.putObject(AuthSessionUtils.REALTOR_ACCOUNT_ID,
                                RedisUtil.get(tokenKey));
                        RedisUtil.set(tokenKey, RedisUtil.get(tokenKey), ACTIVE_TIME);
                    }*/else {
                        // 设置会话的realtor
                        HttpSessionUtils.putObject(AuthSessionUtils.REALTOR_ACCOUNT_ID,
                                RedisUtil.get(tokenKey));
                        RedisUtil.set(tokenKey, RedisUtil.get(tokenKey), ACTIVE_TIME);
                    }
                }else {
                    // 设置会话的realtor
                    HttpSessionUtils.putObject(AuthSessionUtils.REALTOR_ACCOUNT_ID,
                            RedisUtil.get(tokenKey));
                    RedisUtil.set(tokenKey, RedisUtil.get(tokenKey), ACTIVE_TIME);
                }
                return request;
            }

            resultDO.setErrCode(ErrorCode.UN_LOGIN);
            Response response = Response.ok(JSON.toJSONString(resultDO)).status(401).type(MediaType.APPLICATION_JSON).build();
            throw new WebApplicationException(response);
        }

        return request;
    }
}
