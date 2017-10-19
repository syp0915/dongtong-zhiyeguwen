package com.shfc.base.service;

import com.shfc.base.dto.SmsDTO;
import com.shfc.common.result.ResultDO;

import java.util.HashMap;
import java.util.List;

/**
 * @Package com.shfc.base.service.SmsRemoteService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 14:48
 * version V1.0.0
 */
public interface SmsRemoteService {

    /**
     * 消息中心短信验证码
     * @param smsDTO
     * @return
     */
    public ResultDO<String> sendCheckCode(SmsDTO smsDTO);

    /**
     * 消息中心发送短信共享方法
     * @param paramMap
     * @param smsContentParamList
     * @param hashMap
     * @return
     */
    public ResultDO<String> sendSmsMessage(HashMap<String,Object> paramMap, List<String> smsContentParamList, HashMap<String,Object> hashMap);


    /**
     * 发送短信和push共享方法
     * @param paramMap
     * @param contentParamList
     * @param smsContentParamList
     * @param hashMap
     * @return
     */
    public ResultDO<String> pushSendNoticeMessage(HashMap<String,Object> paramMap, List<String> contentParamList, List<String> smsContentParamList, HashMap<String,Object> hashMap );

    /**
     * 发送语音验证码
     * @param phone
     * @return
     */
    public ResultDO<String> sendVoiceCode(String phone,String templateId);

    /**
     * 验证码的校验
     * @param msgId
     * @param checkCode
     * @param phone
     * @return
     */
    public ResultDO<String> checkCaptcha(String phone,String checkCode,String msgId);

}
