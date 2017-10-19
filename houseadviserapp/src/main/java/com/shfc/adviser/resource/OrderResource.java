package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.OrderAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.OrderAttestationDTO;
import com.shfc.house.dto.OrderParamDTO;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.OrderResource
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/12 15:37
 * version V1.0.0
 */
@Component
@Path("/api/order")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class OrderResource {
    @Autowired
    private OrderAO orderAO;

    /**
     * 生成待支付订单
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/createOrder/{version}")
    public String createOrder(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        OrderParamDTO object= JsonUtils.parseJavaObject(reqStr,OrderParamDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(orderAO.createOrder(object));
    }

    /**
     * 订单列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/orderList/{version}")
    public String orderList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        OrderParamDTO object= JsonUtils.parseJavaObject(reqStr,OrderParamDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(orderAO.orderList(object));
    }

    /**
     * 订单详情
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/orderDetail/{version}")
    public String orderDetail(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        OrderParamDTO object= JsonUtils.parseJavaObject(reqStr,OrderParamDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(orderAO.orderDetail(object));
    }

    /**
     * 支付成功验签
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/orderAttestation/{version}")
    public String orderAttestation(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        OrderAttestationDTO object= JsonUtils.parseJavaObject(reqStr,OrderAttestationDTO.class);
        if(object==null){
            ResultDO<Object> resultDO=new ResultDO<Object>();
            resultDO.setErrMsg("请求参不能为空");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(orderAO.orderAttestation(object));
    }

    /**
     * 查询第三方支付状态
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/queryOrderStatus/{version}")
    public String queryOrderStatus(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JSON.parseObject(reqStr);
        return JSON.toJSONString(orderAO.queryOrderStatus(object.getLong("orderId"),object.getInteger("payType")));
    }
}
