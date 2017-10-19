package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.PlotAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.NearbyPlotQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.PlotResource
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 14:06
 * version V1.0.0
 */
@Component
@Path("/api/plot")
public class PlotResource {

    public Logger logger = Logger.getLogger(PlotResource.class);

    @Autowired
    private PlotAO plotAO;

    /**
      * @Description: 根据地址/名称查询小区
      * @Title queryPlotByKeyword
      * @Author  lv bin
      * @Date 2017/1/4 14:16
      * @param  reqStr, version
      * @return String
      * @throws
      */
    @POST
    @Path("/queryPlotByKeyword/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryPlotByKeyword(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(plotAO.queryPlotByKeyword(object.getString("keyword")));
    }

    /**
     * @Description: 根据经纬度查询附近小区
     * @Title queryNearbyPlotGPS
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryNearbyPlotGPS/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryNearbyPlotGPS(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        NearbyPlotQuery query = JsonUtils.parseJavaObject(reqStr, NearbyPlotQuery.class);

        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(plotAO.queryNearbyPlotGPS(query));
    }

    /**
     * @Description: 根据小区id获取楼栋列表
     * @Title findPlotUnitByPlotId
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/findPlotUnitByPlotId/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String findPlotUnitByPlotId(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(plotAO.findPlotUnitByPlotId(object.getLong("plotId")));
    }

    /**
     * @Description: 根据楼栋id获取房号列表
     * @Title findRoomByPlotUnitId
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/findRoomByPlotUnitId/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String findRoomByPlotUnitId(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(plotAO.findRoomByPlotUnitId(object.getLong("plotUnitId")));
    }
}
