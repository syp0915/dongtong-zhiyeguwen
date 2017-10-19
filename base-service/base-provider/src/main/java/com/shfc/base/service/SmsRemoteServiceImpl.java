package com.shfc.base.service;

import com.alibaba.fastjson.JSON;
import com.fc.common.redis.RedisUtil;
import com.google.gson.Gson;
import com.shfc.base.dto.SmsDTO;
import com.shfc.base.remote.MessageCenterNetRequest;
import com.shfc.common.base.UUIDUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.math.RandomUtils;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.base.service.SmsRemoteServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 14:52
 * version V1.0.0
 */
@Service
public class SmsRemoteServiceImpl implements SmsRemoteService {
    public Logger logger = Logger.getLogger(SmsRemoteServiceImpl.class);


    private final String NOTE_TITLE ="NOTE";//短信开头

    private final String  MSG_ID ="MSGID_";//短信msgId

    @Autowired
    private MessageCenterNetRequest messageCenterNetRequest;


    @Override
    public ResultDO<String> sendCheckCode(SmsDTO smsDTO) {
        ResultDO<String> resultDO = new ResultDO<>();
        String phone = smsDTO.getPhone();
        String verifyCode = RandomUtils.generateNumberString(6);
        if(ValidateHelper.isEmptyString(phone)){
            resultDO.setErrMsg("手机号不能为空！");
            return resultDO;
        }
        //短信发送上限校验
        ResultDO<String> checkResult = checkSendNoteMaxNumber(phone);
        if(!checkResult.isSuccess()){
            resultDO.setErrMsg(checkResult.getErrMsg());
            return resultDO;
        }
        List<String> contentParamList = new ArrayList<>();
        contentParamList.add(verifyCode);
        String remote  = messageCenterNetRequest.sendVerifyCode(phone,contentParamList);
        if(ValidateHelper.isEmptyString(remote)){
            resultDO.setErrMsg("调用消息中心异常！");
            return resultDO;
        }
        resultDO = JSON.parseObject(remote,ResultDO.class);
        if(resultDO.isSuccess()){
            String msgId = UUIDUtils.getUUID();
            String msgValue = phone+"&&"+verifyCode;
            RedisUtil.set(MSG_ID+msgId,msgValue,900);
            resultDO.setData(msgId);
            return resultDO;
        }
        return resultDO;
    }

    /**
     * 消息中心发送短信共享方法
     * @add by xiehh
     */
    @Override
    public ResultDO<String> sendSmsMessage(HashMap<String, Object> paramMap, List<String> contentParamList, HashMap<String, Object> hashMap) {
        ResultDO<String> resultDO = new ResultDO<>();
        String remote = messageCenterNetRequest.sendSmsMessage(paramMap,contentParamList,hashMap);
        if(ValidateHelper.isEmptyString(remote)){
            resultDO.setErrMsg("调用消息中心异常！");
            return resultDO;
        }
        resultDO = JSON.parseObject(remote,ResultDO.class);
        return resultDO;
    }

    /**
     * 发送短信和push共享方法
     * @return
     * add by xiehb
     */
    @Override
    public ResultDO<String> pushSendNoticeMessage(HashMap<String, Object> paramMap, List<String> contentParamList, List<String> smsContentParamList, HashMap<String, Object> hashMap) {
        ResultDO<String> resultDO = new ResultDO<>();
        String remote = messageCenterNetRequest.pushSendNoticeMessage(paramMap,contentParamList,smsContentParamList,hashMap);
        if(ValidateHelper.isEmptyString(remote)){
            resultDO.setErrMsg("调用消息中心异常！");
            return resultDO;
        }
        resultDO = JSON.parseObject(remote,ResultDO.class);
        return resultDO;
    }

    public ResultDO<String> checkSendNoteMaxNumber(String phone){
        ResultDO<String> resultDO = new ResultDO<String>();
        String key  = NOTE_TITLE.concat(phone);
        Integer  maxCount = (Integer) RedisUtil.get(key);
        if(maxCount==null){
            //第一条记录存到redis ，count=1
            String nowDate  = DateUtils.getCurrentTime();
            String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ")+"23:59:59";
            int secondCount  = DateUtils.compareTime(nowDate,nextTime,3);
            if(secondCount>0){
                RedisUtil.set(key,1,secondCount);
            }
        }else {
            if(maxCount>9){
                resultDO.setErrMsg("您收取验证码数量已达上限,请明日再试！");
                return resultDO;
            }else {
                //没执行一次 initCount+1
                String nowDate  = DateUtils.getCurrentTime();
                String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ")+"23:59:59";
                int secondCount  = DateUtils.compareTime(nowDate,nextTime,3);
                if(secondCount>0){
                    RedisUtil.set(key,maxCount+1,secondCount);
                }
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }
    public ResultDO<String> sendVoiceCode(String phone,String templateId){
        ResultDO<String> resultDO = new ResultDO<String>();

        return resultDO;
    }

    public ResultDO<String> checkCaptcha(String phone,String checkCode,String msgId){
        ResultDO<String> resultDO = new ResultDO<String>();
        Map<String, Object> params = new HashMap<String, Object>();
        String version = "V1.0.0";
        params.put("msgId",msgId);
        params.put("captcha",checkCode);
        params.put("receiver",phone);
        String paramsString = new Gson().toJson(params);
        String checkResult =null;
        checkResult = null;// remoteReqService.remoteReq(CHECK_SMS_CAPTCHA, version, paramsString);
        HashMap<String,Object> mapResult = JSON.parseObject(checkResult,HashMap.class);
        String resStatus = (String) mapResult.get("resStatus");
        if(!resStatus.equals("90001200000")){
            String error = (String) mapResult.get("resMessage");
            resultDO.setErrMsg(error);
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }
}
