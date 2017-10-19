package com.shfc.base.remote;

import com.alibaba.fastjson.JSON;
import com.shfc.base.enums.DeviceType;
import com.shfc.common.base.Logger;
import com.shfc.common.encrypt.AESUtils;
import okhttp3.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Package com.shfc.base.remote.MessageCenterNetRequest
 * @Description: 消息中心网络请求
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/7/10 16:43
 * version V1.0.0
 */
@Service
public class MessageCenterNetRequest {
    @Value("${mc.base.appId}")
    private String appId;
    @Value("${mc.base.url}")
    private String mcBaseUrl;
    @Value("${mc.sms.verify.code.business.id}")
    private String verifyCodeBusinessId;
    @Value("${mc.environment}")
    private Integer environment;
    @Value("${mc.apiKey}")
    private String apiKey;//短信验签的key
    @Value("${mc.encrypKey}")
    private String encrypKey;//加密key
    /**
     * 发送验证码
     * @param phone
     * @param contentParamList
     * @return
     */
    public String sendVerifyCode(String phone,List<String> contentParamList){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("appId",appId);
        paramMap.put("phone",phone);
        paramMap.put("businessId", verifyCodeBusinessId);
        return sendSmsMessage(paramMap,contentParamList,null);
    }


    /**
     * 短信通知
     * @param paramMap
     * @param contentParamList
     * @param contentParamList
     * @return
     */
    public String sendSmsMessage(HashMap<String,Object> paramMap,List<String> contentParamList,HashMap hashMap){
        Map<String, Object> quesgtParams = new HashMap<>();//拼装验签的请求参数
        Long timestamp = System.currentTimeMillis();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", paramMap.get("appId"));
        params.put("businessId", paramMap.get("businessId"));
        params.put("mobile", paramMap.get("phone"));
        if(contentParamList!=null && !contentParamList.isEmpty()){
            Map<String, Object> contentParam = new HashMap<String, Object>();
            contentParam.put("sms", StringUtils.join(contentParamList, '|'));
            params.put("paramter", contentParam);
        }
        quesgtParams.put("reqJson",params);
        quesgtParams.put("apiKey",apiKey);
        quesgtParams.put("timestamp",timestamp);
        String value = JSON.toJSONString(params);
        String signature = null;
        try {
            signature = AESUtils.encrypt(value,encrypKey,timestamp+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        quesgtParams.put("signature",signature);
        System.out.println("quesgtParams==="+JSON.toJSONString(quesgtParams));
        return this.requestMessageCenter(mcBaseUrl, quesgtParams);
    }

    /**
     * 消息推送
     * @param paramMap
     * @param contentParamList
     * @return
     */
    public String sendNotifyMessage(HashMap<String,Object> paramMap,List<String> contentParamList,HashMap hashMap){
        Map<String, Object> quesgtParams = new HashMap<>();//拼装验签的请求参数
        Long timestamp = System.currentTimeMillis();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", paramMap.get("appId"));
        params.put("businessId", paramMap.get("businessId"));
        Integer osType=Integer.valueOf(paramMap.get("osType").toString());
        params.put("deviceType",  DeviceType.getNameByValue(osType));
        params.put("deviceId", paramMap.get("deviceId"));

        if(osType.intValue()==0){  //ios
            params.put("type",2);
        }
        if(osType.intValue()==1){  //android
            params.put("type",0);
        }
        params.put("notifyChannel","jpush");  //消息发送通道
        Map<String, Object> contentParam = new HashMap<String, Object>();
        if(contentParam==null){
            contentParam.put("notify", "notify");
        }else {
            contentParam.put("sms", StringUtils.join(contentParamList, '|'));
        }
        params.put("paramter", contentParam);
        //拼装验签参数
        params.put("environment",0);
        quesgtParams.put("reqJson",params);
        quesgtParams.put("apiKey",apiKey);
        quesgtParams.put("timestamp",timestamp);
        String value = JSON.toJSONString(params);
        String signature = null;
        try {
            signature = AESUtils.encrypt(value,encrypKey,timestamp+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        quesgtParams.put("signature",signature);
        return this.requestMessageCenter(mcBaseUrl, quesgtParams);
    }

    /**
     * 短信发送和消息推送
     * @param paramMap
     * @param contentParamList
     * @param hashMap
     * @return
     */
    public String pushSendNoticeMessage(HashMap<String,Object> paramMap, List<String> contentParamList,List<String> smsContentParamList,HashMap hashMap){
        Map<String, Object> quesgtParams = new HashMap<>();//拼装验签的请求参数
        Long timestamp = System.currentTimeMillis();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", paramMap.get("appId"));
        params.put("businessId", paramMap.get("businessId"));
        Object osTypeObj = paramMap.get("osType");
        Integer osType= null;
        if(osTypeObj!=null){
            osType=Integer.valueOf(paramMap.get("osType").toString());
            params.put("deviceId",paramMap.get("deviceId"));       //设备号
        }else {
            osType=0;
            params.put("deviceId","00000");       //设备号默认00000，置业顾问设备ID可能为空
        }
        params.put("notifyChannel","jpush");  //消息发送通道
        params.put("deviceType", DeviceType.getNameByValue(osType));  //设备类型
        if(osType.intValue()==0){  //ios
            params.put("type",2);
        }
        if(osType.intValue()==1){  //android
            params.put("type",0);
        }
        params.put("mobile", paramMap.get("phone"));
        params.put("environment",environment);//0 是测试环境  1是正式环境
        Map<String, Object> contentParam = new HashMap<String, Object>();
        if(contentParamList==null || contentParamList.isEmpty()){
            contentParam.put("notify","notify");
        }else{
            contentParam.put("notify", StringUtils.join(contentParamList, '|'));
        }
        if(smsContentParamList==null || smsContentParamList.isEmpty()){
            contentParam.put("sms","");
        }else{
            contentParam.put("sms", StringUtils.join(smsContentParamList, '|'));
        }
        params.put("paramter", contentParam);

        //拼装验签参数
        /*JSONObject object = JSONObject.fromObject(hashMap);
        params.put("bussParam",object.toString());*/
        quesgtParams.put("reqJson",params);
        quesgtParams.put("apiKey",apiKey);
        quesgtParams.put("timestamp",timestamp);
        String value = JSON.toJSONString(params);
        String signature = null;
        try {
            signature = AESUtils.encrypt(value,encrypKey,timestamp+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        quesgtParams.put("signature",signature);
        Logger.info(MessageCenterNetRequest.class,"URL:"+mcBaseUrl+"---参数:"+JSON.toJSONString(quesgtParams));//增加日志功能
        return this.requestMessageCenter(mcBaseUrl, quesgtParams);
    }

    /**
     * 统一封装参数，向消息中心发起请求
     * @param url
     * @param params
     * @return
     */
    public String requestMessageCenter(String url, Map<String, Object> params){
        Logger.info(this,"message center request params----------->" + JSON.toJSONString(params));
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .build();
        client.connectTimeoutMillis();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), JSON.toJSONString(params));
        Request request = new Request.Builder().url(url).post(requestBody).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()){
                String result = response.body().string();
                Logger.info(this,"message center response string----------->" + result);
                return result;
            }else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new MessageCenterNetRequest().requestMessageCenter("http://www.baidu.com", null);
    }
}
