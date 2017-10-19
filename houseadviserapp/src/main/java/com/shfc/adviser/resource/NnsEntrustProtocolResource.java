package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.NnsEntrustProtocolAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.house.dto.SendSignNoteDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.NnsEntrustProtocolResource
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 17:40
 * version V1.0.0
 */
@Component
@Path("/api/entrustProtocol/")
public class NnsEntrustProtocolResource {
    @Autowired
    private NnsEntrustProtocolAO nnsEntrustProtocolAO;

    /**
     * 委托宝-房源委托协议列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/houseEntrustList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String houseEntrustList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        Page page =  JsonUtils.parseJavaObject(reqStr, Page.class);
        return JSON.toJSONString(nnsEntrustProtocolAO.houseEntrustList(page));
    }

    /**
     * 委托宝-房源委托协议详情
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/houseEntrustDetail/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String houseEntrustDetail(@FormParam("reqStr")String reqStr,@PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        return JSON.toJSONString(nnsEntrustProtocolAO.houseEntrustDetail(object.getLong("protocolId")));
    }

    /**
     *  委托宝-房源委托协议工作流
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/entrustWorkflowList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String entrustWorkflowList(@FormParam("reqStr")String reqStr,@PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        return JSON.toJSONString(nnsEntrustProtocolAO.entrustWorkflowList(object.getLong("protocolId")));
    }

    /**
     * 发起签署-发送签署短信
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/sendSignNote/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String sendSignNote(@FormParam("reqStr")String reqStr,@PathParam("version") String version){
        SendSignNoteDTO object = JsonUtils.parseJavaObject(reqStr,SendSignNoteDTO.class);
        return JSON.toJSONString(nnsEntrustProtocolAO.sendSignNote(object));
    }
}
