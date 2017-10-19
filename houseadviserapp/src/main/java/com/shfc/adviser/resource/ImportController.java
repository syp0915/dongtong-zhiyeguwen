package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.ImportAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.house.dto.ImportReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.ImportController
 * @Description: 导入Excel服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/6/7 13:57
 * version V1.0.0
 */
@Component
@Path("/api/import")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class ImportController {
    @Autowired
    private ImportAO importAO;
    @POST
    @Path("/ajk/{version}")
    public String importAjkData(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        ImportReqBean reqBean = JsonUtils.parseJavaObject(reqStr, ImportReqBean.class);
        return JSON.toJSONString(importAO.importAjkData(reqBean));
    }

}
