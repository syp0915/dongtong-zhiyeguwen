package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.BaseReactionAO;
import com.shfc.base.dto.ReactionDTO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 14:38
 **/
@Component
@Path("api/retroaction")
public class BaseReactionResource {

    @Autowired
    private BaseReactionAO baseReactionAO;

    /**
     * @Description: 建议反馈
     * @Title addReaction
     * @Author  wuky
     * @Date 2017/1/10 14:16
     * @param  reqStr, version
     * @return String
     * @throws
     */
    @POST
    @Path("addReaction/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String addReaction(@FormParam("reqStr")String reqStr,@PathParam("version")String version){
        ReactionDTO dto= JsonUtils.parseJavaObject(reqStr,ReactionDTO.class);

        if(dto==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(baseReactionAO.addReaction(dto));

    }
}
