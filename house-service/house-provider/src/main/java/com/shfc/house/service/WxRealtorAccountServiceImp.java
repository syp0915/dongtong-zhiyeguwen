package com.shfc.house.service;

import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.domain.WxAccountRelation;
import com.shfc.house.dto.*;
import com.shfc.house.enums.*;
import com.shfc.house.manager.RealtorInfoManager;
import com.shfc.house.manager.WxManager;
import com.shfc.house.query.RealtorShortcutQuery;
import com.shfc.house.query.WxJsQuery;
import com.shfc.house.utils.Sha1Utils;
import com.shfc.house.utils.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.*;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 微信经纪人账户
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 10:03
 **/
@Service
public class WxRealtorAccountServiceImp implements WxRealtorAccountService {
    @Autowired(required = false)
    private WxManager wxManager;

    @Autowired(required = false)
    private RealtorService realtorService;

    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;

    @Autowired(required = false)
    private RealtorInfoManager realtorInfoManager;

    @Value("${mc.house.appId}")
    private String houseAppId;

    @Value("${wx_official_account_token}")
    private String wxOfficialAccountToken;

    @Value("${wx_official_account_app_id}")
    private String wxOfficicalAccountAppId;

    @Value("${realtor.audit.pass.business.id}")
    private String auditPassBusinessId;

    @Value("${realtor.audit.noPass.business.id}")
    private String auditNoPassBusinessId;

    @Override
    public ResultDO<RealtorAccountInfoDTO> getAccountInfoByWxCode(String wxCode) {
        ResultDO<RealtorAccountInfoDTO> resultDO=new ResultDO<RealtorAccountInfoDTO>();
        RealtorAccountInfoDTO realtorAccountInfoDTO=new RealtorAccountInfoDTO();
        if(ValidateHelper.isEmpty(wxCode)){
            resultDO.setErrMsg("请求查询wxCode不能为空");
            return resultDO;
        }

        String openId = wxManager.getWxOpenId(wxCode);

        if(ValidateHelper.isEmpty(openId)){
            resultDO.setErrMsg("微信信息获取失败");
            return resultDO;
        }
        realtorAccountInfoDTO.setWxopenId(openId);

        List<WxAccountRelation> list=wxManager.queryByOpenId(openId);
        if(list==null ||list.size()==0){
            resultDO.setSuccess(true);
            resultDO.setErrCode(999);
            resultDO.setErrMsg("尚未绑定上海房产帐号");
            resultDO.setData(realtorAccountInfoDTO);
            return resultDO;
        }

        WxAccountRelation wxOpenBindingRecord=list.get(0);

        realtorAccountInfoDTO.setRealtorId(wxOpenBindingRecord.getAccountId().toString());
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setData(realtorAccountInfoDTO);
        return resultDO;
    }

    @Override
    public ResultDO<String> wxPassageVerify(WxVerifyDTO wxVerifyDTO) {
        ResultDO<String> resultDO = new ResultDO<String>();
        String token = wxOfficialAccountToken;
        String signature = wxVerifyDTO.getSignature();
        String timestamp = wxVerifyDTO.getTimestamp();
        String nonce = wxVerifyDTO.getNonce();
        String echostr = wxVerifyDTO.getEchostr();
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder sourceString = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sourceString.append(arr[i]);
        }
        if (Sha1Utils.getSha1(sourceString.toString()).equals(signature)) {
            resultDO.setData(echostr);
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<RealtorAccoutStatusDTO> bindRealtorAccount(RealtorAccountBindDTO realtorAccountBindDTO) {
        ResultDO<RealtorAccoutStatusDTO> resultDO = new ResultDO<RealtorAccoutStatusDTO>();
        RealtorAccoutStatusDTO realtorAccoutStatusDTO = new RealtorAccoutStatusDTO();
        String wxOpenId = realtorAccountBindDTO.getWxOpenId();//微信openId
        String phone = realtorAccountBindDTO.getPhone();//上海房产注册手机号
        String checkCode = realtorAccountBindDTO.getCheckCode();//    短信验证码
        String msgId = realtorAccountBindDTO.getMsgId();//短信验证码Id

        if (ValidateHelper.isEmpty(wxOpenId) || ValidateHelper.isEmpty(phone) || ValidateHelper.isEmpty(checkCode) /*|| ValidateHelper.isEmpty(msgId)*/) {
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        //经纪人快捷登录
        RealtorShortcutQuery query = new RealtorShortcutQuery();
        query.setPhone(phone);
        query.setCheckCode(checkCode);
        query.setMsgId(msgId);
        query.setSource(RealtorSource.WECHAT_REALTOTR_HB.getValue());

        ResultDO<CurrentRealtorDTO> currentRealtor = realtorService.shortcut(query);
        if (!currentRealtor.isSuccess()) {
            resultDO.setErrMsg(currentRealtor.getErrMsg());
            return resultDO;
        }

        Long accountId = currentRealtor.getData().getRealtorId();

        //取绑定记录
        List<WxAccountRelation> bindRecords = wxManager.queryBingRecordByaccountId(accountId);
        if (bindRecords == null || bindRecords.size() == 0) {
            //写绑定记录
            WxAccountRelation record = new WxAccountRelation();
            record.setAccountId(accountId);
            record.setType(AccountType.Realtor.getValue());
            record.setWxOpenId(wxOpenId);
            record.setBindingStatus(RealtorBindWxStatus.Binding.getValue());
            record.setWxOfficeAccountFlag(WxOfficalFlag.SFJJR.getValue());
            record.setBindingTime(new Date());
            wxManager.addBingRecord(record);
        } else if (bindRecords.size() == 1) {
            if (!bindRecords.get(0).getWxOpenId().equals(wxOpenId)) {
                //修改绑定的微信OpenId
                WxAccountRelation record = new WxAccountRelation();
                record.setAccountId(accountId);
                record.setWxOpenId(wxOpenId);
                record.setBindingStatus(RealtorBindWxStatus.Binding.getValue());
                record.setWxOfficeAccountFlag(WxOfficalFlag.SFJJR.getValue());
                wxManager.updateBingRecord(record);
            }
        }

        realtorAccoutStatusDTO.setRealtorId(accountId.toString());
        realtorAccoutStatusDTO.setStatus(currentRealtor.getData().getStatus().toString());
        resultDO.setData(realtorAccoutStatusDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }


    /**
     * 身份审核－微信推送
     * @param realtorId
     * @param status
     * @param reason
     * @return
     */
    @Override
    public ResultDO<Object> wxPush(Long realtorId , int status , String reason , String auditTime){
        ResultDO<Object> resultDO = new ResultDO<>();
        //根据经纪人ID查询经纪人微信账号信息
        WxOpenBindingRecordDTO wxOpenBindingRecordDTO = wxManager.queryWxInfo(realtorId);

        if (null == wxOpenBindingRecordDTO || ValidateHelper.isEmpty(wxOpenBindingRecordDTO.getWxOpenId())){
            resultDO.setErrMsg("经纪人未绑定公众号");
            return resultDO;
        }

        //调用微信发送接口
        String wxAccountType = "knhb";
        String callBackUrl = null;
        String templeteId = null;
        String openId = wxOpenBindingRecordDTO.getWxOpenId();
        WxTemplateMessageDTO wxTemplateMessageDTO = new WxTemplateMessageDTO();
        WxTemplateMessageDataDTO dataBean = new WxTemplateMessageDataDTO();
        WxMessageVCDTO vcBean = new WxMessageVCDTO();
        //判断审核是否通过
        if (status == 1){//通过
            callBackUrl = "http://wx.shfc999.com/dist/draw.html?wxOpenId="+openId+"&realtorId="+realtorId;
            templeteId = "-q-GRmlUUANAUTyxWl2SmLwVtAKkDs1wENuE3-AjjqI";

            vcBean.setValue("恭喜您，身份验证审核通过！");
            dataBean.setFirst(vcBean);

            vcBean = new WxMessageVCDTO();
            vcBean.setValue("请进入“上房经纪人”微信公众号进行抽奖");
            dataBean.setRemark(vcBean);
        }else if (status == 2){//未通过
            try {
                callBackUrl = "http://wx.shfc999.com/dist/failAudit.html?wxOpenId="+openId+"&realtorId="+realtorId
                        +"&reason="+ URLEncoder.encode(reason,"utf-8")+"&flag=true";
            }catch (Exception e){
                resultDO.setErrMsg("编码失败！");
                return resultDO;
            }
            templeteId = "o23aXt6KEMNDb4CVcE9zeUvkr9bHNlhss3wfkGfDPFk";

            vcBean.setValue("很抱歉，身份验证审核未通过！");
            dataBean.setFirst(vcBean);

            vcBean = new WxMessageVCDTO();
            vcBean.setValue(reason);
            dataBean.setKeyword4(vcBean);

            vcBean = new WxMessageVCDTO();
            vcBean.setValue("审核通过后，才可以进行抽奖哦。");
            dataBean.setRemark(vcBean);
        }else{//其他入参
            resultDO.setErrMsg("状态参数不符合要求");
            return resultDO;
        }

        vcBean = new WxMessageVCDTO();
        vcBean.setValue(AccountType.getNameByValue(wxOpenBindingRecordDTO.getType()) + "身份验证");
        dataBean.setKeyword1(vcBean);

        vcBean = new WxMessageVCDTO();
        vcBean.setValue(NnsHouseAuditStatus.getNameByValue(status));
        dataBean.setKeyword2(vcBean);

        vcBean = new WxMessageVCDTO();
        vcBean.setValue(auditTime);
        dataBean.setKeyword3(vcBean);

        wxTemplateMessageDTO.setTouser(openId);
        wxTemplateMessageDTO.setUrl(callBackUrl);
        wxTemplateMessageDTO.setTemplate_id(templeteId);
        wxTemplateMessageDTO.setData(dataBean);

        ResultDO<WxMessageDTO> resultDOWx = sendWxTempleteMessage(wxAccountType, wxTemplateMessageDTO);
        if (!resultDOWx.isSuccess()){//发送失败
            resultDO.setErrMsg(resultDOWx.getErrMsg());
        }else{//发送成功
            resultDO.setSuccess(true);
        }

        return resultDO;
    }

    /**
     * 身份审核－短信推送
     * @param realtorId
     * @param status
     * @param reason
     * @return
     */
    @Override
    public ResultDO<String> smsPush(Long realtorId , int status , String reason){

        ResultDO<String> resultDO = new ResultDO<>();
        //根据经纪人ID查询对应经纪人信息
        RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
        if (null == account){
            resultDO.setErrMsg("经纪人信息不正确！");
            return resultDO;
        }
        //调用短信发送接口,参数拼装
        HashMap<String,Object> paramMap = new HashMap<>();
        List<String> contentParamList = new ArrayList<>();//push 参数
        List<String> smsContentParamList = new ArrayList<>();//sms 参数
        String phone = account.getPhone();
        Integer osType = account.getOsType();
        String deviceId = account.getDeviceId();
        paramMap.put("appId",houseAppId);
        paramMap.put("phone",phone);
        paramMap.put("osType",osType);
        paramMap.put("deviceId",deviceId);
        if (status == 1){ //通过
            paramMap.put("auditType",0);
            paramMap.put("businessId", auditPassBusinessId);
        }else if (status == 2){ //未通过
            paramMap.put("auditType",1);
            paramMap.put("businessId", auditNoPassBusinessId);
            contentParamList.add(reason);
            smsContentParamList.add(reason);
        }else{ //其他入参
            resultDO.setErrMsg("状态参数不符合要求");
            return resultDO;
        }
        asyncPushAndSmsMessage(paramMap,contentParamList,smsContentParamList,null);
        resultDO.setSuccess(true);
        return resultDO;
    }
    @Async
    private void asyncPushAndSmsMessage(HashMap<String,Object> paramMap,List<String> contentParamList,List<String> smsContentParamList,HashMap hashMap){
        smsRemoteService.pushSendNoticeMessage(paramMap,contentParamList,smsContentParamList,null);
    }

    @Override
    public ResultDO<WxJsDTO> getWxJsInfo(WxJsQuery query) {
        ResultDO<WxJsDTO> resultDO = new ResultDO<WxJsDTO>();
        WxJsDTO dto = new WxJsDTO();
        String wxAccountType = query.getWxAccountType();
        String url = query.getUrl();
        if (ValidateHelper.isEmpty(wxAccountType) || ValidateHelper.isEmpty(url)){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        if (!"knhb".equals(wxAccountType)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("非法请求参数");
            return resultDO;
        }
        dto.setAppId(wxOfficicalAccountAppId);
        dto.setDebug(false);
        Long timestamp = System.currentTimeMillis()/1000;
        String nonceStr = StringUtils.getRandomString(20);
        String jsapi_ticket = wxManager.getJsApiTicket();
        if (ValidateHelper.isEmpty(jsapi_ticket)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("微信信息获取失败");
            return resultDO;
        }

//        String[] arr = new String[] { "jsapi_ticket=" + jsapi_ticket,
//                "timestamp=" + timestamp, "noncestr=" + nonceStr, "url=" + url };
//        Arrays.sort(arr);
//        String str = arr[0].concat("&"+arr[1]).concat("&"+arr[2]).concat("&"+arr[3]);
        StringBuilder str = new StringBuilder();
        str.append("jsapi_ticket=").append(jsapi_ticket);
        str.append("&noncestr=").append(nonceStr);
        str.append("&timestamp=").append(timestamp);
        str.append("&url=").append(url);

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
        dto.setJsApiList(jsApiList);
        dto.setSignature(Sha1Utils.getSha1(str.toString()));
        dto.setNonceStr(nonceStr);
        dto.setTimestamp(timestamp);
        resultDO.setSuccess(true);
        resultDO.setData(dto);
        return resultDO;
    }


    /**
     * 发送微信模板消息
     * @param wxAccountType
     * @param dto
     * @return
     */
    public ResultDO<WxMessageDTO> sendWxTempleteMessage(String wxAccountType, WxTemplateMessageDTO dto){
        ResultDO<WxMessageDTO> resultDO = new ResultDO<WxMessageDTO>();
        WxMessageDTO wxMessageDTO = new WxMessageDTO();
        String templeteId = dto.getTemplate_id();
        String wxOpenId = dto.getTouser();
        String callBackUrl = dto.getUrl();
        WxTemplateMessageDataDTO data = dto.getData();
        if (ValidateHelper.isEmpty(wxAccountType) || dto == null){
            resultDO.setErrCode(1);
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        JSONObject jsonObject = wxManager.sendWxTempleteMessage(templeteId, wxOpenId, callBackUrl,data);
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
        resultDO.setData(wxMessageDTO);
        return resultDO;
    }

    public ResultDO sendWxRedPapper(String wxAccountType, WxSendRedPapperReqDTO wxSendRedPapperReqDTO){
        ResultDO<WxSendRedPapperRespDTO> resultDO = new ResultDO<WxSendRedPapperRespDTO>();
        WxSendRedPapperRespDTO wxSendRedPapperRespDTO = new WxSendRedPapperRespDTO();
        String orderNo = wxSendRedPapperReqDTO.getOrderNo();
        String wxOpenId = wxSendRedPapperReqDTO.getWxOpenId();
        Long sendAmount = wxSendRedPapperReqDTO.getSendAmount();
        if (ValidateHelper.isEmpty(wxAccountType) || ValidateHelper.isEmpty(wxOpenId) || ValidateHelper.isEmpty(sendAmount)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("请求参数异常");
            return resultDO;
        }
        Map<String, Object> sendResult = wxManager.sendWxRedPapper(orderNo, wxOpenId, sendAmount);
        if (sendResult == null){
            resultDO.setSuccess(false);
            resultDO.setErrMsg("请求无响应，发送失败");
            resultDO.setErrCode(1);
            return resultDO;
        }
        String returnCode = sendResult.get("return_code").toString();
        if ("FAIL".equals(returnCode)){
            String returnMsg = sendResult.get("return_msg").toString();
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(returnMsg);
            return resultDO;
        }
        String resultCode = sendResult.get("result_code").toString();
        if ("FAIL".equals(resultCode)){
            String errCodeDes = sendResult.get("err_code_des").toString();
            resultDO.setSuccess(false);
            resultDO.setErrCode(2);
            resultDO.setErrMsg(errCodeDes);
            return resultDO;
        }
        wxSendRedPapperRespDTO.setOrderNo(sendResult.get("mch_billno").toString());
        wxSendRedPapperRespDTO.setWxOpenId(sendResult.get("re_openid").toString());
        wxSendRedPapperRespDTO.setSendAmount(Long.parseLong(sendResult.get("total_amount").toString()));
        wxSendRedPapperRespDTO.setWxPayOrderNo(sendResult.get("send_listid").toString());
        resultDO.setData(wxSendRedPapperRespDTO);
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg("发送成功");
        return resultDO;
    }
}
