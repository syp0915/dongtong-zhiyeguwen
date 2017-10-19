package com.shfc.house.remote;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunyaping
 * @Package com.shfc.house.remote
 * @Description:东方金融客户管理系统接口调用(用户)
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-04-06 16:28
 * version V1.0.0
 **/
@Service
public class SmsInnerUserRemoteServe {
    public Logger logger = Logger.getLogger(SmsInnerRemoteServe.class);
    @Autowired
    private RemoteReqService remoteReqService;

    private final String CREATEPERSONOPERATOR_PERSON_URL = "cif/customer/createPersonOperator/";//用户注册

    private final String QUERY_USER_INFO_URL = "cif/customer/queryUserInfo/";//用户查询

    private final String RELA_CUSTOMER_URL = "manageMsg/relaCustomer/";//更新设备id

    /**
     * 注册用户到东方金融
     * @param phone
     * @param checkCode
     * @param msgId
     * @param deviceId
     * @return
     */
    public ResultDO<String> createUser(String phone, String checkCode, String msgId, String deviceId) {
        ResultDO<String> resultDO = new ResultDO<String>();
        String version = "V1.0.0";
        String operatorNo = null;
        //东方金融的用户注册接口
        Map<String, String> resultMap = createPersonOperatorMap(phone, checkCode, msgId, deviceId);
        String custParamsString = new Gson().toJson(resultMap);
        //调用 东方金融的用户注册接口
        String custCheckResult = remoteReqService.remoteReq(CREATEPERSONOPERATOR_PERSON_URL, version, custParamsString);
        HashMap<String, Object> custMapResult = JSON.parseObject(custCheckResult, HashMap.class);
        String custResStatus = (String) custMapResult.get("resStatus");
        if (custResStatus.equals("01001200000")) {
            //解析 "result":[{"brokerNo":"71000000846266"}]，并回写
            List<Map<String, Object>> resultStr = (List<Map<String, Object>>) custMapResult.get("result");
            for (int i = 0; i < resultStr.size(); i++) {
                Map<String, Object> ss = resultStr.get(i);
                operatorNo = (String) ss.get("operatorNo");
            }
            logger.info("createUser==operatorNo=="+operatorNo);
            resultDO.setSuccess(true);
            resultDO.setData(operatorNo);
            return resultDO;
        } else {
            String errorMsg = (String) custMapResult.get("resMessage");
            //已注册用户获取操作编号 {"remark":"","resMessage":"该登录号已注册","resStatus":"01001200006","result":[]}
            if (custResStatus.equals("01001200006")) {
                ResultDO<String> realtorInfo =  queryUserInfo(phone,"LOGINNO");
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
     * 查询东方金融用户信息
     * @param entityNo
     * @param entityType
     * @return
     */
    public ResultDO<String> queryUserInfo(String entityNo,String entityType){
        ResultDO<String> resultDO = new ResultDO<String>();
        String version = "V1.0.0";
        String operatorNo = null;
        Map<String, String> queryUserMap = new HashMap<String, String>();
        queryUserMap.put("entityNo", entityNo);
        queryUserMap.put("entityType", entityType);
        queryUserMap.put("customerType", "PERSON");
        String queryUserMapString = new Gson().toJson(queryUserMap);
        String queryUserResult =  remoteReqService.remoteReq(QUERY_USER_INFO_URL, version, queryUserMapString);
        HashMap<String,Object> userInfoMap = JSON.parseObject(queryUserResult,HashMap.class);
        String userInfoStatus = (String) userInfoMap.get("resStatus");
        if(userInfoStatus.equals("01001200000")){
            List<Map<String,Object>> resultStr = (List<Map<String,Object>>) userInfoMap.get("result");
            for(int i=0;i<resultStr.size();i++){
                Map<String,Object> ss  = resultStr.get(i);
                operatorNo = (String) ss.get("operatorNo");
            }
            resultDO.setSuccess(true);
            resultDO.setData(operatorNo);
            return resultDO;
        }else {
            String errorMsg = (String) userInfoMap.get("resMessage");
            resultDO.setErrMsg(errorMsg);
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
    //东方金融的用户注册接口
    private Map<String, String> createPersonOperatorMap(String phone,String captcha,String msgId,String uid){
        Map<String, String> params = new HashMap<String, String>();
        params.put("loginNo", phone);
        params.put("loginPwd", "");
        params.put("pwdType", "DYNAMIC");
        params.put("loginType", "MOBILE");
        params.put("regChannel", "COMMON");
        params.put("createdBy", "USER");
        params.put("dataSourceType", "APP");
        params.put("gustNo", "50000000092472");
        params.put("captcha", captcha);
        params.put("msgId", msgId);
        params.put("uid", uid);
        params.put("description", "");
        params.put("receiver", phone);
        return params;
    }

}
