package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.MemberAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.BuyMemberDTO;
import com.shfc.house.dto.InterestQueryDTO;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 会员服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-11 14:18
 **/
@Component
@Path("/api/member")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class MemberResource {
    @Autowired
    private MemberAO memberAO;


    @POST
    @Path("/status/{version}")
    public String queryMemberStatus(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(memberAO.queyStatus());
    }

    /**
     * 开通会员_会员中心展示
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/showMemberCenter/{version}")
    public String showMemberCenter(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object= JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(memberAO.showMemberCenter());
    }
    @POST
    @Path("/buyMember/{version}")
    public String buyMember(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        BuyMemberDTO object= JsonUtils.parseJavaObject(reqStr,BuyMemberDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(memberAO.buyMember(object));
    }

    /**
     * 拨打电话权益
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/checkPhoneInterest/{version}")
    public String checkPhoneInterest(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        InterestQueryDTO object= JsonUtils.parseJavaObject(reqStr,InterestQueryDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        ResultDO<Boolean> resultDO = memberAO.checkPhoneInterest(object);
        return JSON.toJSONString(resultDO);
    }
}
