package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.RealtorAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.RealtorShortcutQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.RealtorLoginResource
 * @Description: 经纪人快捷登录接口
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 10:36
 * version V1.0.0
 */
@Component
@Path("/api/login/")
public class RealtorLoginResource {
    @Autowired
    private RealtorAO realtorAO;
    /**
     * 发送短信验证码
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/sendCheckCode/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String sendCheckCode(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.sendCheckCode(object.getString("phone")));
    }
    /**
     * 发送语音验证码
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/sendVoiceCode/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String sendVoiceCode(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.sendVoiceCode(object.getString("phone")));
    }

    /**
     * 快捷登录
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/shortcut/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String shortcut(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorShortcutQuery query =JsonUtils.parseJavaObject(reqStr,RealtorShortcutQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.shortcut(query));
    }

    /**
     * 获取配置文件参数
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/getParam/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getParam(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.getParam(object.getString("appVersion")));
    }
}
