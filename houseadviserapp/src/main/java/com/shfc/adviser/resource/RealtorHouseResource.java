package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.RealtorHouseAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.RealtorHouseQuery;
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
 * @date 2017-08-23 15:40
 * version V1.0.0
 **/
@Component
@Path("/api/realtorHouse")
public class RealtorHouseResource {

    @Autowired
    private RealtorHouseAO realtorHouseAO;


    /**
     * 经纪人发布房源
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/addRealtorHouse/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String addRealtorHouse(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        RealtorHouseDTO realtorHouseDTO= JsonUtils.parseJavaObject(reqStr,RealtorHouseDTO.class);
        if(realtorHouseDTO==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorHouseAO.addRealtorHouse(realtorHouseDTO));

    }

    /**
     * 经纪人修改房源信息
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/modifyRealtorHouse/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String modifyRealtorHouse(@FormParam("reqStr")String reqStr,@PathParam("version")String version){
        RealtorHouseDTO realtorHouseDTO=JsonUtils.parseJavaObject(reqStr,RealtorHouseDTO.class);
        if(realtorHouseDTO==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorHouseAO.modifyRealtorHouse(realtorHouseDTO));

    }

    @POST
    @Path("/queryPublishHouseList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getRealtorHouseList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        BaseQuery query = JsonUtils.parseJavaObject(reqStr, BaseQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        Integer pageNumber = query.getPageNumber();
        pageNumber = (pageNumber == null || pageNumber <= 0)? 1 : pageNumber;
        query.setPageNumber(pageNumber);
        Integer pageSize = query.getPageSize();
        pageSize = (pageSize == null || pageSize <= 0)? 10 : pageSize;
        query.setPageSize(pageSize);
        return JSON.toJSONString(realtorHouseAO.getRealtorHouseList(query));
    }

    @POST
    @Path("/queryDetail/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getRealtorHouseDetail(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        Long houseId = object.getLong("houseId");
        return JSON.toJSONString(realtorHouseAO.getRealtorHouseDetail(houseId));
    }

    @POST
    @Path("/upDownDel/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String upDownOrDel(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorHouseQuery query = JsonUtils.parseJavaObject(reqStr, RealtorHouseQuery.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorHouseAO.upDownOrDel(query));
    }
}
