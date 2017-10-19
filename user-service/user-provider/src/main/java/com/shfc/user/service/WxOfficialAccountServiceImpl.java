package com.shfc.user.service;

import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.user.base.BaseServiceImpl;
import com.shfc.user.dao.UserMapper;
import com.shfc.user.domain.User;
import com.shfc.user.dto.CurrentUserDTO;
import com.shfc.user.dto.WxMessageDTO;
import com.shfc.user.file.WxEnvPropertiesFileValue;
import com.shfc.user.httpbean.req.ReqBean60107;
import com.shfc.user.httpbean.req.ReqBean60108;
import com.shfc.user.httpbean.req.ReqBean60113;
import com.shfc.user.httpbean.resp.RespBean60107;
import com.shfc.user.httpbean.resp.RespBean60108;
import com.shfc.user.httpbean.resp.RespBean60113;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageDataBean;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageReqBean;
import com.shfc.user.httpbean.wxBean.WxVerifyReqBean;
import com.shfc.user.httpbean.wxBean.WxVerifyRespBean;
import com.shfc.user.manager.UserManager;
import com.shfc.user.manager.WxManager;
import com.shfc.user.query.UserShortcutQuery;
import com.shfc.user.utils.Sha1Utils;
import com.shfc.user.utils.StringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午11:21.
 */
@Service
public class WxOfficialAccountServiceImpl extends BaseServiceImpl implements WxOfficialAccountService {

    Logger logger = Logger.getLogger(WxOfficialAccountServiceImpl.class);

    @Autowired(required = false)
    private WxEnvPropertiesFileValue wxEnvPropertiesFileValue;

    @Autowired(required = false)
    private WxManager wxManager;

    @Autowired(required = false)
    private UserManager userManager;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;

    @Override
    public ResultDO<RespBean60107> bindShfcAccount(ReqBean60107 reqBean60107) {
        ResultDO<RespBean60107> resultDO = new ResultDO<RespBean60107>();
        RespBean60107 respBean60107 = new RespBean60107();
        String wxOpenId = reqBean60107.getWxOpenId();
        String shfcPhone = reqBean60107.getShfcPhone();
        Integer bindType = reqBean60107.getBindType();
        String verifyCode = reqBean60107.getVerifyCode();
        String verifyCodeId = reqBean60107.getVerifyCodeId();
        if (isNullOrEmpty(wxOpenId) || isNullOrEmpty(shfcPhone) || bindType == null || isNullOrEmpty(verifyCode) || isNullOrEmpty(verifyCodeId)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        User user = null;
        List<User> userList = userMapper.findUserByPhone(shfcPhone);
        if (userList == null || userList.size() == 0){
            UserShortcutQuery userShortcutQuery = new UserShortcutQuery();
            userShortcutQuery.setPhone(shfcPhone);
            userShortcutQuery.setMsgId(verifyCodeId);
            userShortcutQuery.setCheckCode(verifyCode);
            try {
                ResultDO<CurrentUserDTO> userResult = userService.shortcutUser(userShortcutQuery);
                if (userResult == null){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg(ERROR_INNER_SYSTEM_ERROR);
                    return resultDO;
                }
                if (!userResult.isSuccess()){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(userResult.getErrCode());
                    resultDO.setErrMsg(userResult.getErrMsg());
                    return resultDO;
                }
                Long userId = userResult.getData().getUserId();
                user = userManager.selectById(userId);
            } catch (AppException e) {
                e.printStackTrace();
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_INNER_SYSTEM_ERROR);
                return resultDO;
            }
        }else {
            if (0 == bindType){
                ResultDO<String> checkResult = smsRemoteService.checkCaptcha(shfcPhone, verifyCode, verifyCodeId);
                if (checkResult == null){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg(ERROR_INNER_SYSTEM_ERROR);
                    return resultDO;
                }
                if (!checkResult.isSuccess()){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(checkResult.getErrCode());
                    resultDO.setErrMsg(checkResult.getErrMsg());
                    return resultDO;
                }
            }
            user = userList.get(0);
            if (!isNullOrEmpty(user.getWxOpenId()) && bindType == 0){
                resultDO.setSuccess(false);
                resultDO.setErrCode(999);
                resultDO.setErrMsg("该上海房产帐号已经和其他微信号绑定，是否重新绑定？");
                return resultDO;
            }
        }
        try {
            userManager.bindShfcAccount(user, wxOpenId);
        } catch (Exception e) {
            e.printStackTrace();
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(e.getMessage());
            return resultDO;
        }
        respBean60107.setUserId(user.getId() + "");
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60107);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60108> getAccountInfoByWxCode(ReqBean60108 reqBean60108) {
        ResultDO<RespBean60108> resultDO = new ResultDO<RespBean60108>();
        RespBean60108 respBean60108 = new RespBean60108();
        String wxCode = reqBean60108.getWxCode();
        if (isNullOrEmpty(wxCode)) {
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        String openId = wxManager.getWxOpenId(wxCode);
        if (isNullOrEmpty(openId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("微信信息获取失败");
            return resultDO;
        }
        respBean60108.setWxOpenId(openId);
        List<User> userList = userMapper.findUserByWxOpenId(openId);
        if (userList == null || userList.size() == 0){
            resultDO.setSuccess(true);
            resultDO.setErrCode(999);
            resultDO.setErrMsg("尚未绑定上海房产帐号");
            resultDO.setData(respBean60108);
            return resultDO;

        }
        User user = userList.get(0);
        respBean60108.setUserId(user.getId().toString());
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60108);
        return resultDO;
    }

    @Override
    public WxVerifyRespBean wxPassageVerify(WxVerifyReqBean wxVerifyReqBean) {
        WxVerifyRespBean wxVerifyRespBean = new WxVerifyRespBean();
        String token = wxEnvPropertiesFileValue.getWxOfficialAccountToken();
        String signature = wxVerifyReqBean.getSignature();
        String timestamp = wxVerifyReqBean.getTimestamp();
        String nonce = wxVerifyReqBean.getNonce();
        String echostr = wxVerifyReqBean.getEchostr();
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder sourceString = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sourceString.append(arr[i]);
        }
        if (Sha1Utils.getSha1(sourceString.toString()).equals(signature)) {
            wxVerifyRespBean.setEchostr(echostr);
        }
        return wxVerifyRespBean;
    }

    public ResultDO<RespBean60113> getWxJsInfo(ReqBean60113 reqBean60113){
        ResultDO<RespBean60113> resultDO = new ResultDO<RespBean60113>();
        RespBean60113 respBean60113 = new RespBean60113();
        String wxAccountType = reqBean60113.getWxAccountType();
        String url = reqBean60113.getUrl();
        if (isNullOrEmpty(wxAccountType) || isNullOrEmpty(url)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        if (!"ajsh".equals(wxAccountType)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("非法请求参数");
            return resultDO;
        }
        respBean60113.setAppId(wxEnvPropertiesFileValue.getWxOfficicalAccountAppId());
        respBean60113.setDebug(true);
        Long timestamp = System.currentTimeMillis();
        String nonceStr = StringUtils.getRandomString(20);
        String jsapi_ticket = wxManager.getJsApiTicket();
        if (isNullOrEmpty(jsapi_ticket)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("微信信息获取失败");
            return resultDO;
        }
        String[] arr = new String[] { "jsapi_ticket=" + jsapi_ticket,
                "timestamp=" + timestamp, "noncestr=" + nonceStr, "url=" + url };
        Arrays.sort(arr);
        String str = arr[0].concat("&"+arr[1]).concat("&"+arr[2]).concat("&"+arr[3]);
//        StringBuilder str = new StringBuilder();
//        str.append("jsapi_ticket=").append(jsapi_ticket);
//        str.append("&nonceStr=").append(nonceStr);
//        str.append("&timestamp=").append(timestamp);
//        str.append("&url=").append(url);

        List<String> jsApiList = new ArrayList<String>();
        jsApiList.add("onMenuShareTimeline");
        jsApiList.add("onMenuShareAppMessage");
        jsApiList.add("onMenuShareQQ");
        jsApiList.add("onMenuShareWeibo");
        jsApiList.add("onMenuShareQZone");
        jsApiList.add("startRecord");
        jsApiList.add("stopRecord");
        jsApiList.add("onVoiceRecordEnd");
        jsApiList.add("playVoice");
        jsApiList.add("pauseVoice");
        jsApiList.add("stopVoice");
        jsApiList.add("onVoicePlayEnd");
        jsApiList.add("uploadVoice");
        jsApiList.add("downloadVoice");
        jsApiList.add("chooseImage");
        jsApiList.add("previewImage");
        jsApiList.add("uploadImage");
        jsApiList.add("downloadImage");
        jsApiList.add("translateVoice");
        jsApiList.add("getNetworkType");
        jsApiList.add("openLocation");
        jsApiList.add("getLocation");
        jsApiList.add("hideOptionMenu");
        jsApiList.add("showOptionMenu");
        jsApiList.add("hideMenuItems");
        jsApiList.add("showMenuItems");
        jsApiList.add("hideAllNonBaseMenuItem");
        jsApiList.add("showAllNonBaseMenuItem");
        jsApiList.add("closeWindow");
        jsApiList.add("scanQRCode");
        jsApiList.add("chooseWXPay");
        jsApiList.add("openProductSpecificView");
        jsApiList.add("addCard");
        jsApiList.add("chooseCard");
        jsApiList.add("openCard");
        respBean60113.setJsApiList(jsApiList);
        respBean60113.setSignature(Sha1Utils.getSha1(str.toString()));
        respBean60113.setNonceStr(nonceStr);
        respBean60113.setTimestamp(timestamp);
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60113);
        return resultDO;
    }

    /**
     * 发送微信模板消息
     * @param wxAccountType
     * @param wxTemplateMessageReqBean
     * @return
     */
    public ResultDO<WxMessageDTO> sendWxTempleteMessage(String wxAccountType, WxTemplateMessageReqBean wxTemplateMessageReqBean){
        ResultDO<WxMessageDTO> resultDO = new ResultDO<WxMessageDTO>();
        WxMessageDTO wxMessageDTO = new WxMessageDTO();
        String templeteId = wxTemplateMessageReqBean.getTemplate_id();
        String wxOpenId = wxTemplateMessageReqBean.getTouser();
        String callBackUrl = wxTemplateMessageReqBean.getUrl();
        WxTemplateMessageDataBean data = wxTemplateMessageReqBean.getData();
        if (isNullOrEmpty(wxAccountType) || wxTemplateMessageReqBean == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        JSONObject jsonObject = wxManager.sendWxTempleteMessage(templeteId, wxOpenId, callBackUrl, data);
        if (jsonObject == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("消息发送失败");
            return resultDO;
        }
        int errcode = jsonObject.getInt("errcode");
        String errmsg = jsonObject.getString("errmsg");
        if (0 != errcode){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(errmsg);
            return resultDO;
        }
        wxMessageDTO.setMsgId(jsonObject.getLong("msgid"));
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(wxMessageDTO);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> unsubscribeWx(String wxOpenId) {
        ResultDO<Boolean> resultDO = new ResultDO<Boolean>();
        resultDO.setSuccess(wxManager.unsubscribeWxByOpenId(wxOpenId));
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        if (!resultDO.isSuccess()){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("解绑错误");
        }
        return resultDO;
    }
}
