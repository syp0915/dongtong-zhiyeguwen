package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.PosterAO;
import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 海报
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-03 09:22
 **/
@Component
@Path("/api/poster")
public class PosterResource {
    @Autowired
    private PosterAO posterAO;


    @POST
    @Path("/templateList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String templateList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject jsonObject= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(jsonObject == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(posterAO.templateList(jsonObject.getInteger("type")));
    }

    @POST
    @Path("/addHousePoster/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String addHousePoster(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        HousePosterDTO jsonObject= JsonUtils.parseJavaObject(reqStr,HousePosterDTO.class);
        if(jsonObject == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(posterAO.addHousePoster(jsonObject));
    }

//    @POST
//    @Path("/describeHousePoster/{version}")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
//    public String describeHousePoster(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
//        JSONObject jsonObject= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
//        if(jsonObject == null){
//            ResultDO<Object> resultDO = new ResultDO<Object>();
//            resultDO.setErrMsg("json格式错误,请检查请求参数");
//            return JSON.toJSONString(resultDO);
//        }
//        return JSON.toJSONString(posterAO.describeHousePoster(jsonObject.getLong("templateId"),jsonObject.getLong("houseId")));
//    }

    @POST
    @Path("/addBuildingPoster/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String addBuildingPoster(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        BuildingPosterDTO jsonObject= JsonUtils.parseJavaObject(reqStr,BuildingPosterDTO.class);
        if(jsonObject == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(posterAO.addBuildingPoster(jsonObject));
    }


//    @POST
//    @Path("/describeBuildingPoster/{version}")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
//    public String describeBuildingPoster(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
//        JSONObject jsonObject= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
//        if(jsonObject == null){
//            ResultDO<Object> resultDO = new ResultDO<Object>();
//            resultDO.setErrMsg("json格式错误,请检查请求参数");
//            return JSON.toJSONString(resultDO);
//        }
//        return JSON.toJSONString(posterAO.describeBuildingPoster(jsonObject.getLong("templateId"),jsonObject.getLong("buildingId")));
//    }

    @POST
    @Path("/queryBuildingPoster/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryBuildingPoster(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject jsonObject= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(jsonObject == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(posterAO.queryBuildingPoster(jsonObject.getLong("buildingId")));
    }
}
