package com.shfc.user.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.sign.query.SignSendPDFToEmail;
import com.shfc.sign.service.SignService;
import com.shfc.user.base.BaseServiceImpl;
import com.shfc.user.httpbean.req.ReqBean60105;
import com.shfc.user.httpbean.req.ReqBean60109;
import com.shfc.user.httpbean.req.ReqBean60110;
import com.shfc.user.httpbean.req.ReqBean60111;
import com.shfc.user.httpbean.resp.RespBean60105;
import com.shfc.user.httpbean.resp.RespBean60109;
import com.shfc.user.httpbean.resp.RespBean60110;
import com.shfc.user.httpbean.resp.RespBean60111;
import com.shfc.user.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午11:20.
 */
@Service
public class AssistantServiceImpl extends BaseServiceImpl implements AssistantService {

    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;

    @Autowired(required = false)
    private SignService signService;

    @Override
    public ResultDO<RespBean60105> shareEntrustViaEmail(ReqBean60105 reqBean60105) {
        ResultDO<RespBean60105> resultDO = new ResultDO<RespBean60105>();
        RespBean60105 respBean60105 = new RespBean60105();
        String agreementId = reqBean60105.getAgreementId();
        String email = reqBean60105.getEmail();
        if (isNullOrEmpty(email) || isNullOrEmpty(agreementId)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        if (!StringUtils.isEmailAddressLegal(email)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("请输入合法的Email地址");
            return resultDO;
        }
        SignSendPDFToEmail signSendPDFToEmail = new SignSendPDFToEmail();
        signSendPDFToEmail.setEmail(email);
        signSendPDFToEmail.setId(agreementId);
        ResultDO<Boolean> result = signService.sendSignPDFToEmail(signSendPDFToEmail);
        if (!result.isSuccess()) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60105);
        return resultDO;
    }

    public ResultDO<String> checkSendNoteMaxNumber(String phone, int MAX_COUNT) {
        ResultDO<String> resultDO = new ResultDO<String>();
        String key = "NOTE" + phone;
        Integer maxCount = (Integer) RedisUtil.get(key);
        if (maxCount == null) {
            //第一条记录存到redis ，count=1
            String nowDate = DateUtils.getCurrentTime();
            String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ") + "23:59:59";
            int secondCount = DateUtils.compareTime(nowDate, nextTime, 3);
            if (secondCount > 0) {
                RedisUtil.set(key, 1, secondCount);
            }
        } else {
            if (maxCount > MAX_COUNT) {
                resultDO.setErrMsg("您收取验证码数量已达上限,请明日再试！");
                return resultDO;
            } else {
                //没执行一次 initCount+1
                String nowDate = DateUtils.getCurrentTime();
                String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ") + "23:59:59";
                int secondCount = DateUtils.compareTime(nowDate, nextTime, 3);
                if (secondCount > 0) {
                    RedisUtil.set(key, maxCount + 1, secondCount);
                }
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60109> sendVerifyCode(ReqBean60109 reqBean60109) {
        ResultDO<RespBean60109> resultDO = new ResultDO<RespBean60109>();
        RespBean60109 respBean60109 = new RespBean60109();
        String phone = reqBean60109.getPhone();
        if (isNullOrEmpty(phone)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        ResultDO<String> checkResult = checkSendNoteMaxNumber(phone, 9);
        if (!checkResult.isSuccess()) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(888);
            resultDO.setErrMsg(checkResult.getErrMsg());
            return resultDO;
        }
        ResultDO<String> result = smsRemoteService.sendCheckCode(phone, "CAPTCHA253532");
        if (!result.isSuccess()) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }
        if (result.getData() == null) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("消息中心获取数据异常");
            return resultDO;
        }
        respBean60109.setVerifyCodeId(result.getData());
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60109);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60110> checkVerifyCode(ReqBean60110 reqBean60110) {
        ResultDO<RespBean60110> resultDO = new ResultDO<RespBean60110>();
        RespBean60110 respBean60110 = new RespBean60110();
        String verifyCodeId = reqBean60110.getVerifyCodeId();
        String verifyCode = reqBean60110.getVerifyCode();
        String phone = reqBean60110.getPhone();
        if (isNullOrEmpty(verifyCodeId) || isNullOrEmpty(verifyCode) || isNullOrEmpty(phone)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        ResultDO<String> result = smsRemoteService.checkCaptcha(phone, verifyCode, verifyCodeId);
        if (!result.isSuccess()) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60110);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60111> getShfcOfficialAccountQrCode(ReqBean60111 reqBean60111) {
        ResultDO<RespBean60111> resultDO = new ResultDO<RespBean60111>();
        RespBean60111 respBean60111 = new RespBean60111();
        String resourceType = reqBean60111.getResourceType();
        if (isNullOrEmpty(resourceType)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        if (!resourceType.equals("0")) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        respBean60111.setQrCodeUrl("http://shfc-img.oss-cn-shanghai.aliyuncs.com/142010086821541174.jpg");
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60111);
        return resultDO;
    }
}
