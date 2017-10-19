package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.AppAO;
import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.base.query.AliyunTokenQuery;
import com.shfc.base.query.AppUpdateQuery;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/14 下午2:06.
 */
@Component
@Path("/api/app")
public class AppResource {

    @Autowired(required = false)
    private AppAO appAO;

    @POST
    @Path("/getTmpAccessInfo/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getTmpAccessInfo(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        AliyunTokenQuery query = JsonUtils.parseJavaObject(reqStr, AliyunTokenQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(appAO.getAliyunTokenInfo(query));
    }

    @POST
    @Path("/checkUpdate/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String checkUpdate(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        AppUpdateQuery query = JsonUtils.parseJavaObject(reqStr, AppUpdateQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(appAO.queryAppUpdate(query));
    }
}
