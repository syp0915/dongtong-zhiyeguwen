package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.LeadsServiceAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.LeadsCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 增值服务service
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 16:14
 **/
@Component
@Path("/api/service")
public class LeadsAddServiceResource {
    @Autowired
    private LeadsServiceAO leadsServiceAO;

    @POST
    @Path("/h5/leadsService/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String serviceInfo(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        JSONObject object= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<JSONObject> resultDO=new ResultDO<>();
            resultDO.setErrMsg("请求参数不能为空");
            return JSON.toJSONString(resultDO);
        }
        return  JSON.toJSONString(leadsServiceAO.serviceDetail(object.getLong("serviceId")));
    }

    @POST
    @Path("/addCustomer/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String addCustomer(@FormParam("reqStr") String reqStr, @PathParam("version") String version){
        LeadsCustomerDTO object= JsonUtils.parseJavaObject(reqStr,LeadsCustomerDTO.class);
        if(object==null){
            ResultDO<JSONObject> resultDO=new ResultDO<>();
            resultDO.setErrMsg("请求参数不能为空");
            return JSON.toJSONString(resultDO);
        }
        return  JSON.toJSONString(leadsServiceAO.addCustomer(object));
    }

    @POST
    @Path("/calculateCommission/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String calculateCommission(@FormParam("reqStr")String reqStr,@PathParam("version")String version){

        return JSON.toJSONString(leadsServiceAO.calculateCommission());
    }
}
