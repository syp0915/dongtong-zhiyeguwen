package com.shfc.house.remote;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.shfc.common.date.DateUtils;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.house.remote.SmsRemoteServe
 * @Description: 东方金融客户管理系统接口调用
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 10:52
 * version V1.0.0
 */
@Service
public class SmsInnerRemoteServe {
    public Logger logger = Logger.getLogger(SmsInnerRemoteServe.class);
    @Autowired
    private RemoteReqService remoteReqService;

    private final String CREATE_REALTOR_URL = "cif/broker/createBroker/";//经纪人注册

    private final String QUERY_REALTOR_URL = "cif/broker/queryBroker/";//经纪人信息查询

    private final String RELA_CUSTOMER_URL = "manageMsg/relaCustomer/";//更新设备id

    /**
     * 注册经纪人到东方金融
     * @param phone
     * @param checkCode
     * @param msgId
     * @param deviceId
     * @return
     */
    public ResultDO<String> createRealtor(String phone,String checkCode,String msgId,String deviceId) {
        ResultDO<String> resultDO = new ResultDO<String>();
        String version = "V1.0.0";
        String operatorNo = null;
        //东方金融的用户注册接口
        Map<String, String> resultMap = createRealtorMap(phone, checkCode, msgId, deviceId);
        String custParamsString = new Gson().toJson(resultMap);
        //调用 东方金融的用户注册接口
        String custCheckResult = remoteReqService.remoteReq(CREATE_REALTOR_URL, version, custParamsString);
        HashMap<String, Object> custMapResult = JSON.parseObject(custCheckResult, HashMap.class);
        String custResStatus = (String) custMapResult.get("resStatus");
        if (custResStatus.equals("01001200000")) {
            //解析 "result":[{"brokerNo":"71000000846266"}]，并回写
            List<Map<String, Object>> resultStr = (List<Map<String, Object>>) custMapResult.get("result");
            for (int i = 0; i < resultStr.size(); i++) {
                Map<String, Object> ss = resultStr.get(i);
                operatorNo = (String) ss.get("brokerNo");
            }
            logger.info("createBroker==brokerNo=="+operatorNo);
            resultDO.setSuccess(true);
            resultDO.setData(operatorNo);
            return resultDO;
        } else {
            String errorMsg = (String) custMapResult.get("resMessage");
            //已注册用户获取操作编号 {"remark":"","resMessage":"该登录号已注册","resStatus":"01001200006","result":[]}
            if (custResStatus.equals("01001200006")) {
                ResultDO<String> realtorInfo =  queryRealtorInfo(phone,"LOGINNO");
                if(realtorInfo.isSuccess()){
                    resultDO.setData(realtorInfo.getData());
                    resultDO.setSuccess(true);
                    return resultDO;
                }else {
                    resultDO.setErrMsg(realtorInfo.getErrMsg());
                    return resultDO;
                }
            }else { //不是报已经注册，直接返回错误
                resultDO.setErrMsg(errorMsg);
                return resultDO;
            }
        }
    }

    /**
     * 查询东方金融经纪人信息
     * @param entityNo
     * @param entityType
     * @return
     */
    public ResultDO<String> queryRealtorInfo(String entityNo,String entityType){
        ResultDO<String> resultDO = new ResultDO<String>();
        String version = "V1.0.0";
        String operatorNo = null;
        Map<String, String> queryBrokerMap = new HashMap<String, String>();
        queryBrokerMap.put("entityNo", entityNo);
        queryBrokerMap.put("entityType", entityType);
        String queryBrokerMapString = new Gson().toJson(queryBrokerMap);
        String queryBrokerResult =  remoteReqService.remoteReq(QUERY_REALTOR_URL, version, queryBrokerMapString);
        HashMap<String,Object> brokerInfoMap = JSON.parseObject(queryBrokerResult,HashMap.class);
        String brokerInfoStatus = (String) brokerInfoMap.get("resStatus");
        if(brokerInfoStatus.equals("01001200000")){
            List<Map<String,Object>> resultStr = (List<Map<String,Object>>) brokerInfoMap.get("result");
            for(int i=0;i<resultStr.size();i++){
                Map<String,Object> ss  = resultStr.get(i);
                operatorNo = (String) ss.get("brokerNo");
            }
            resultDO.setSuccess(true);
            resultDO.setData(operatorNo);
            return resultDO;
        }else {
            String errorMsg = (String) brokerInfoMap.get("resMessage");
            resultDO.setErrMsg("该手机号已被使用不能注册经纪人!");
            return resultDO;
        }
    }

    /**
     * 更新设备id
     * @param operatorNo
     * @param deviceId
     * @return
     */
    public ResultDO<String> relaCustomer(String operatorNo,String deviceId){
        ResultDO<String> resultDO = new ResultDO<String>();
        String version = "V1.0.0";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId",operatorNo);
        params.put("uid",deviceId);
        String paramsString = new Gson().toJson(params);
        String relaResult = remoteReqService.remoteReq(RELA_CUSTOMER_URL, version, paramsString);
        HashMap<String,Object> relaMapResult = JSON.parseObject(relaResult,HashMap.class);
        String resStatus = (String) relaMapResult.get("resStatus");
        if(!resStatus.equals("90001200000")){
            String errorMsg = (String) relaMapResult.get("resMessage");
            resultDO.setErrMsg(errorMsg);
            return resultDO;
        }else {
            resultDO.setSuccess(true);
            return resultDO;
        }
    }
    //东方金融的经纪人注册接口
    private Map<String, String> createRealtorMap(String phone,String captcha,String msgId,String uid){
        Map<String, String> params = new HashMap<String, String>();
        params.put("loginNo", phone);
        params.put("loginPwd", "");
        params.put("pwdType", "DYNAMIC");
        params.put("regDate", DateUtils.date2String(new Date(),"yyyyMMdd hh:mm:ss"));
        params.put("loginType", "MOBILE");
        params.put("regChannel", "COMMON");
        params.put("createdBy", "USER");
        params.put("dataSourceType", "APP");
        params.put("guestNo", "50000000092472");
        params.put("captcha", captcha);
        params.put("msgId", msgId);
        params.put("uid", uid);
        params.put("description", "");
        params.put("receiver", phone);
        return params;
    }
}