package com.shfc.adviser.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.ao.RealtorAO;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.query.CustomerStoreQuery;
import com.shfc.house.query.RealtorMessageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Package com.shfc.adviser.resource.RealtorInfoResource
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/11 9:42
 * version V1.0.0
 */
@Component
@Path("/api/realtor/")
public class RealtorInfoResource {

    @Autowired
    private RealtorAO realtorAO;

    /**
     * 基本信息认证
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/basicInfo/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String basicInfo1(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorInfoDTO realtorInfoDTO = JsonUtils.parseJavaObject(reqStr,RealtorInfoDTO.class);
        if(realtorInfoDTO == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.basicInfo(realtorInfoDTO,version));
    }

    /**
     * 查询门店代码有效性
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/queryStoreCode/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String queryStoreCode(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject query = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(query == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.queryStoreCode(query.getString("storeCode")));
    }

    /**
     * 经纪人身份认证（两要素）
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/identityAuth/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String identityAuth(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorInfoDTO realtorInfoDTO = JsonUtils.parseJavaObject(reqStr,RealtorInfoDTO.class);
        if(realtorInfoDTO == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.identityAuth(realtorInfoDTO));
    }

    /**
     * 展示经纪人个人信息
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/showCompleteInfo/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String showCompleteInfo(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorInfoDTO realtorInfoDTO = JsonUtils.parseJavaObject(reqStr,RealtorInfoDTO.class);
        if(realtorInfoDTO == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.showCompleteInfo(realtorInfoDTO));
    }
    /**
     * 经纪人-我的
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/myInfo/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String myInfo(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        return JSON.toJSONString(realtorAO.myInfo());
    }
    /**
     * 999项目-通知列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/nnsMessageList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String nnsMessageList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        return JSON.toJSONString(realtorAO.messageList());
    }

    /**
     * 999项目-通知列表分类明细列表
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/nnsMessageClassifyList/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String nnsMessageClassifyList(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorMessageQuery messageQuery = JsonUtils.parseJavaObject(reqStr,RealtorMessageQuery.class);
        if(messageQuery == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.nnsMessageClassifyList(messageQuery));
    }

    /**
     * 查询经纪人是否认证
     */
    @POST
    @Path("/realtorIfAuth/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String realtorIfAuth(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        return JSON.toJSONString(realtorAO.realtorIfAuth());
    }
    /**
     * 修改经纪人个性签名
     */
    @POST
    @Path("/updateUserAutograph/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String updateUserAutograph(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.updateUserAutograph(object.getString("userAutograph")));
    }


    /**
     * 999项目-未读消息通知
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/nnsUnReadMsg/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String nnsUnReadMsg(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        return JSON.toJSONString(realtorAO.nnsUnReadMsg());
    }

    /**
     *拷贝了周敏 红包项目经纪人审核发送短信的代码
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/smsPush/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String smsPush(@FormParam("reqStr")String reqStr, @PathParam("version")String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr, JSONObject.class);
        if (object == null){
            ResultDO<Object> resultDO = new ResultDO<>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.smsPush(object.getLong("realtorId"),
                object.getIntValue("status"),object.getString("reason")));
    }


    /**
     * 修改经纪人基本信息
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/updateInfo/{version}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String updateInfo(@FormParam("reqStr")String reqStr, @PathParam("version") String version){
        RealtorInfoDTO realtorInfoDTO = JsonUtils.parseJavaObject(reqStr,RealtorInfoDTO.class);
        if(realtorInfoDTO == null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.updateInfo(realtorInfoDTO,version));
    }

    /**
     * 经纪人公司模糊查询
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/queryCompanyByKeyword/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String queryCompanyByKeyword(@FormParam("reqStr") String reqStr,@PathParam("version") String version){
        JSONObject reqJson=JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(reqJson==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }

        return JSON.toJSONString(realtorAO.queryCompanyByKeyword(reqJson.getString("keyword")));

    }


    /**
     * 经纪人门店模糊查询
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/queryStoreByKeyword/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String queryStoreByKeyword(@FormParam("reqStr") String reqStr,@PathParam("version") String version){
        CustomerStoreQuery reqJson=JsonUtils.parseJavaObject(reqStr,CustomerStoreQuery.class);
        if(reqJson==null){
            ResultDO<Object> resultDO = new ResultDO<Object>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        //未传分页时
        if(reqStr.indexOf("pageNumber")==-1){
            return JSON.toJSONString(realtorAO.queryStoreByKeyword(reqJson.getKeyword(),reqJson.getRealtorCompanyId()));
        }else{
            return JSON.toJSONString(realtorAO.queryStoreByKeyword(reqJson));
        }


    }

    /**
     * 修改设备ID
     * @param reqStr
     * @param version
     * @return
     */
    @POST
    @Path("/updateDeviceId/{version}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String updateDeviceId(@FormParam("reqStr") String reqStr,@PathParam("version") String version){
        JSONObject object = JsonUtils.parseJavaObject(reqStr,JSONObject.class);
        if(object==null){
            ResultDO<Object> resultDO = new ResultDO<>();
            resultDO.setErrMsg("json格式错误,请检查请求参数");
            return JSON.toJSONString(resultDO);
        }
        return JSON.toJSONString(realtorAO.updateDeviceId(object.getString("deviceId"),object.getInteger("osType")));
    }

}
