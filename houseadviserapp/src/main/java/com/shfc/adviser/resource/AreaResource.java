package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.AreaAO;
import com.shfc.adviser.ao.HotPlotAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 区域板块信息
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-06 14:14
 **/
@Component
@Path("/api/area")
public class AreaResource {
    @Autowired
    private AreaAO areaAO;

    @Autowired
    private HotPlotAO hotPlotAO;

    /**
     * @Description: 区域板块
     * @Title queryArea
     * @Author  wuky
     * @Date 2017/1/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryArea/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryArea(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(areaAO.getRegionBlockInfo(object.getString("cityId")));
    }

    /**
     * @Description: 热门小区
     * @Title queryHotPlot
     * @Author  wuky
     * @Date 2017/1/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryHotPlot/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryHotPlot(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(hotPlotAO.queryPlot(object.getString("blockId")));
    }

    /**
     * @Description: 区域查询
     * @Title queryRegion
     * @Author  wuky
     * @Date 2017/4/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/region/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public String queryRegion(@FormParam("reqStr") String reqStr,@PathParam("version") String version){
        JSONObject jsonObject=JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(jsonObject==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参数不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(areaAO.queryRegion(jsonObject.getString("cityId")));
    }

    /**
     * @Description: 板块查询
     * @Title queryHotPlot
     * @Author  wuky
     * @Date 2017/4/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/block/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public String queryBlock(@FormParam("reqStr") String reqStr,@PathParam("version") String version){
        JSONObject jsonObject=JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(jsonObject==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参数不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(areaAO.queryBlock(jsonObject.getString("regionId")));
    }
}
