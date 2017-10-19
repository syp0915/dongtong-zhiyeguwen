package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shfc.adviser.ao.BuildingDetailAO;
import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author sunyaping
 * @Package com.shfc.adviser.resource
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-14 15:47
 * version V1.0.0
 **/
@Component
@Path("/api/buildingDetail")
public class BuildingDetailResource {

    @Autowired
    private BuildingDetailAO buildingDetailAO;


    /**
     * 获取同区域楼盘列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/householdList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getHouseTypeList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        Long buildingId=object.getLong("buildingId");
        return JSON.toJSONString(buildingDetailAO.getHouseTypeList(buildingId), SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 获取同区域楼盘列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/sameAreaBuildinglist/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getSameAreaBuildingList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        Long buildingId=object.getLong("buildingId");
        return JSON.toJSONString(buildingDetailAO.getSameAreaBuildingList(buildingId));
    }
}
