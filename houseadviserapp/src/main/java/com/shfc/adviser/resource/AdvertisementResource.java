package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.AdvertisementAO;
import com.shfc.base.query.AdvertisementsQuery;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-06 13:18
 **/
@Component
@Path("/api/advertisement")
public class AdvertisementResource {
    @Autowired
    private AdvertisementAO advertisementAO;
    /**
     * @Description: 广告信息
     * @Title estimate
     * @Author  wuky
     * @Date 2017/1/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("/queryAdvertisements/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryAdvertisements(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        AdvertisementsQuery query= JsonUtils.parseJavaObject(reqStr,AdvertisementsQuery.class);
        if(query==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        if(version.equals("v3.0.0")){
            return JSON.toJSONString(advertisementAO.queryAdvertisement(query));

        }else {
            return JSON.toJSONString(advertisementAO.queryAdvertisements(query));
        }
    }

}
