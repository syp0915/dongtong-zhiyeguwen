package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.BaseTagAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 标签
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-05 15:56
 **/
@Component
@Path("/api/baseTag")
public class BaseTagResource {
    @Autowired
    private BaseTagAO baseTagAO;

    /**
     * @Description: 特色标签
     * @Title queryFeatureList
     * @Author  wuky
     * @Date 2017/1/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryFeatureList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryFeatureList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(baseTagAO.getFeatureList(object.getString("tagType")));
    }
}
