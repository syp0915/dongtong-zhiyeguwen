package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.BuildingAO;
import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.building.query.OperateAttentionBuildingListQuery;
import com.shfc.building.query.RealtorAttentionBuildingListQuery;
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
 * @date 2017/6/14 上午11:02.
 */
@Component
@Path("/api/building")
public class BuildingResource {

    @Autowired(required = false)
    private BuildingAO buildingAO;

    @POST
    @Path("/list/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getBuildingList(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        BuildingListQuery query = JsonUtils.parseJavaObject(reqStr, BuildingListQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(buildingAO.getBuildingList(query));
    }

    @POST
    @Path("/attention/list/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getRealtorAttentionBuildingList(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        RealtorAttentionBuildingListQuery query = JsonUtils.parseJavaObject(reqStr, RealtorAttentionBuildingListQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(buildingAO.getRealtorAttendBuildingList(query));
    }

    @POST
    @Path("/attention/operate/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String operateBuildingAttention(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        OperateAttentionBuildingListQuery query = JsonUtils.parseJavaObject(reqStr, OperateAttentionBuildingListQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(buildingAO.operateBuildingAttention(query));
    }

    @POST
    @Path("/recommend/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String recommendBuilding(@FormParam("reqStr") String reqStr,@PathParam("version")String version){
        JSONObject object=JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(buildingAO.recommendBuilding(object.getString("longitude"),object.getString("latitude")));
    }

    @POST
    @Path("/detail/basic/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String buildingBasicDetail(@FormParam("reqStr") String reqStr,@PathParam("version")String version){
        JSONObject object=JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(buildingAO.buildingBasicDetail(object.getLong("buildingId")));
    }

}
