package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.NnsHouseAO;
import com.shfc.adviser.utils.AuthSessionUtils;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.query.NnsHousePublishQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.NnsHouseResource
 * @Description: 997房源
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:12
 * version V1.0.0
 */
@Component
@Path("/api/nnsHouse")
public class NnsHouseResource {
    @Autowired
    private NnsHouseAO nnsHouseAO;

    /**
     * @Description: 查询房源是否发布
     * @Title queryHousePublish
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryHousePublish/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryHousePublish(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        NnsHousePublishQuery query = JsonUtils.parseJavaObject(reqStr, NnsHousePublishQuery.class);

        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(nnsHouseAO.queryNnsHousePublish(query));
    }

    /**
     * @Description: 查询房源详情
     * @Title detail
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/detail/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String detail(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(nnsHouseAO.findDetailHouseById(object.getLong("houseId")));
    }

    /**
     * @Description: 添加委托协议
     * @Title entrust
     * @Author  lv bin
     * @Date 2017/1/4 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/entrust/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String entrust(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        NnsHouseEntrustDTO dto = JsonUtils.parseJavaObject(reqStr, NnsHouseEntrustDTO.class);

        if(dto == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        dto.setRealtorId(HttpSessionUtils.getCurrentRealtorId());

        return JSON.toJSONString(nnsHouseAO.saveNnsHouseEntrust(dto));
    }
}
