package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.HouseEstimateAO;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.HouseEstimateQuery;
import com.shfc.house.query.NearbyPlotQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.HouseEstimateResource
 * @Description: 估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 16:30
 * version V1.0.0
 */
@Component
@Path("/api/estimate")
public class HouseEstimateResource {
    @Autowired
    private HouseEstimateAO houseEstimateAO;

    /**
     * @Description: 估价
     * @Title estimate
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/calculation/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String calculations(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        HouseEstimateQuery query = JsonUtils.parseJavaObject(reqStr, HouseEstimateQuery.class);

        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        query.setRealtorId(HttpSessionUtils.getCurrentRealtorId());

        return JSON.toJSONString(houseEstimateAO.estimate(query));
    }
}
