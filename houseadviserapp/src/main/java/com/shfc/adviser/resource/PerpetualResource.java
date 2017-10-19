package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.ao.PerpetualAO;
import com.shfc.common.base.StringUtils;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.HouseEstimateQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.PerpetualResource
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/1/5 14:03
 * version V1.0.0
 */
@Component
@Path("/api/wnl")
public class PerpetualResource {

    public Logger logger = Logger.getLogger(PerpetualResource.class);

    @Autowired
    private PerpetualAO perpetualAO;

    /**
     * @Description: 获取老黄历
     * @Title estimate
     * @Author  wliao
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/huangli/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String selectHuangli(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String currentDate = object.getString("currentDate");
        return JSON.toJSONString(perpetualAO.selectWnlJsonStr(currentDate));
    }

    /**
     * @Description: 获取星座运势
     * @Title estimate
     * @Author  wliao
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/star/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String selectStar(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String currentDate = object.getString("currentDate");
        String astroid = object.getString("astroId");
        return JSON.toJSONString(perpetualAO.selectStarJsonStr(currentDate,astroid));
    }
}
