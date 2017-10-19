package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.ao.LeadsHouseAO;
import com.shfc.common.base.UUIDUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.LeadsHouseCorrectDTO;
import com.shfc.house.dto.LeadsHouseDetailDTO;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.LeadsHouseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

/**
 * @Package com.shfc.adviser.resource.LeadsHouseResource
 * @Description: leads 房源
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/6 18:41
 * version V1.0.0
 */
@Component
@Path("/api/leadsHouse")
public class LeadsHouseResource {

    @Autowired
    private LeadsHouseAO leadsHouseAO;

    /**
     * 推荐房源
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/recommend/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String recommend(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);

        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        Integer count = object.getInteger("count");
        String longitude = object.getString("longitude");
        String latitude = object.getString("latitude");

        return JSON.toJSONString(leadsHouseAO.recommendLeadsHouse(count, longitude, latitude));
    }

    /**
     * 房源筛选
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/query/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String query(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        LeadsHouseQuery query = JsonUtils.parseJavaObject(reqStr, LeadsHouseQuery.class);

        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        Integer pageNumber = query.getPageNumber();
        pageNumber = (pageNumber == null || pageNumber <= 0)? 1 : pageNumber;
        query.setPageNumber(pageNumber);
        Integer pageSize = query.getPageSize();
        pageSize = (pageSize == null || pageSize <= 0)? 20 : pageSize;
        query.setPageSize(pageSize);

        return JSON.toJSONString(leadsHouseAO.queryLeadsHouse(query));
    }

    /**
     * 房源纠错
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/correct/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String correct(@FormParam("reqStr")String reqStr, @PathParam("version") String version){

        LeadsHouseCorrectDTO dto = JsonUtils.parseJavaObject(reqStr, LeadsHouseCorrectDTO.class);

        if(dto == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(leadsHouseAO.correctLeadsHouse(dto));
    }

    /**
     * 房源详情
     * @param reqStr
     * @param version
     * @return
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

        return JSON.toJSONString(leadsHouseAO.detailLeadsHouse(object.getLong("leadsHouseId")));
    }

    /**
     * 按小区名称或地址检索房源
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/queryByKeyword/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryByKeyword(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return  JSON.toJSONString(leadsHouseAO.queryByKeyword(object.getString("keyword")));
    }

    /**
     * 已看过的房源
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/scan/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String scan(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        Integer pageNumber = object.getInteger("pageNumber");
        pageNumber = (pageNumber == null || pageNumber <= 0)? 1 : pageNumber;
        Integer pageSize = object.getInteger("pageSize");
        pageSize = (pageSize == null || pageSize <= 0)? 20 : pageSize;

        return JSON.toJSONString(leadsHouseAO.scanLeadsHouse(new BaseQuery(pageNumber, pageSize)));
    }

    /**
     * 已拨打过电话的房源
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/call/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String call(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        Integer pageNumber = object.getInteger("pageNumber");
        pageNumber = (pageNumber == null || pageNumber <= 0)? 1 : pageNumber;
        Integer pageSize = object.getInteger("pageSize");
        pageSize = (pageSize == null || pageSize <= 0)? 20 : pageSize;

        return JSON.toJSONString(leadsHouseAO.callLeadsHouse(new BaseQuery(pageNumber, pageSize)));
    }

    /**
     * leads house 2.1 h5房源信息
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/h5Info/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String info(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        ResultDO<Object> resultDO = new ResultDO<Object>();
        if(object == null){
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String uuid = object.getString("uuid");
        if(ValidateHelper.isEmpty(uuid)){
            resultDO.setErrMsg("uuid不能为空,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        Object ob = RedisUtil.get(uuid);
        String leadsHouseId = (String)RedisUtil.get(uuid);
        if(ValidateHelper.isEmpty(leadsHouseId)){
            resultDO.setErrMsg("房源id不存在,请求已过期");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(leadsHouseAO.h5LeadsHouseInfo(Long.valueOf(leadsHouseId)));
    }

    /**
     * leads house 2.1 h5房源授权
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/h5Grant/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String grant(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        ResultDO<Object> resultDO = new ResultDO<Object>();
        if(object == null){
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String uuid = object.getString("uuid");
        if(ValidateHelper.isEmpty(uuid)){
            resultDO.setErrMsg("uuid不能为空,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String leadsHouseId = (String)RedisUtil.get(uuid);
        if(ValidateHelper.isEmpty(leadsHouseId)){
            resultDO.setErrMsg("房源id不存在,请求已过期");
            return JSON.toJSONString(resultDO);
        }

        Integer agree = object.getInteger("agree");
        if(agree == null || agree.intValue() < 0 || agree.intValue() > 1){
            resultDO.setErrMsg("agree参数错误");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(leadsHouseAO.h5Grant(Long.valueOf(leadsHouseId), agree));
    }

    /**
     * redis设置
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/redis/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String redis(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        ResultDO<Object> resultDO = new ResultDO<Object>();
        if(object == null){
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        String uuid = UUIDUtils.getUUID();
        String val = object.getString("val");
        String second = object.getString("second");
        if(ValidateHelper.isEmpty(val) || ValidateHelper.isEmpty(second)){
            resultDO.setErrMsg("请求参数不完整");
            return JSON.toJSONString(resultDO);
        }
        RedisUtil.set(uuid, val, Long.valueOf(second));

        resultDO.setSuccess(true);
        resultDO.setData(uuid);
        return JSON.toJSONString(resultDO);
    }
}
