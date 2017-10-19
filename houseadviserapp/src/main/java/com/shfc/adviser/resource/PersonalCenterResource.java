package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.PersonalCenterAO;
import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.CommissionQuery;
import org.apache.log4j.Logger;
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
 * @date 2017-07-13 9:32
 * version V1.0.0
 **/
@Component
@Path("/api/personal")
public class PersonalCenterResource {

    public Logger logger = Logger.getLogger(PersonalCenterResource.class);

    @Autowired
    private PersonalCenterAO personalCenterAO;

    @POST
    @Path("/commissionStatistics/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String commissionStatistics(@PathParam("version")String version){
        return JSON.toJSONString(personalCenterAO.commissionStatistics());
    }

    @POST
    @Path("/settlementDetailList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getSettlementDetailList(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        CommissionQuery query= JsonUtils.parseJavaObject(reqStr,CommissionQuery.class);
        if(query==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(personalCenterAO.getSettlementDetailList(query));
    }


    @POST
    @Path("/applyForSettlement/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String applyForSettlement(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        String orderNumber = object.getString("orderNumber");
        return JSON.toJSONString(personalCenterAO.applyForSettlement(orderNumber));
    }


    @POST
    @Path("/reportList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getReportList(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        CommissionQuery query= JsonUtils.parseJavaObject(reqStr,CommissionQuery.class);
        if(query==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(personalCenterAO.getReportList(query));
    }


    @POST
    @Path("/customerDetail/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getCustomerDetail(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrCode(ErrorConstant.PARSE_JSON_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.PARSE_JSON_EXCEPTION.getMsg());
            return JSON.toJSONString(resultDO);
        }
        Long reportId = object.getLong("reportId");
        return JSON.toJSONString(personalCenterAO.getCustomerDetail(reportId));
    }

}
