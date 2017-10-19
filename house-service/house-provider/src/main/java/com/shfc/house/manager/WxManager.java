package com.shfc.house.manager;

import com.alibaba.fastjson.JSON;
import com.fc.common.redis.RedisUtil;
import com.shfc.attachment.domain.AttachmentInfo;
import com.shfc.attachment.service.AttachmentService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.encrypt.MD5Utils;
import com.shfc.common.exception.AppException;
import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.RealtorUnitiveAccountMapper;
import com.shfc.house.dao.RealtorUploadPicRecordMapper;
import com.shfc.house.dao.WxAccountRelationMapper;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.domain.RealtorUploadPicRecord;
import com.shfc.house.domain.WxAccountRelation;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.dto.WxOpenBindingRecordDTO;
import com.shfc.house.dto.WxTemplateMessageDataDTO;
import com.shfc.house.enums.YesNo;
import com.shfc.house.utils.ApacheHttpUtils;
import com.shfc.house.utils.StringUtils;
import com.shfc.house.utils.WxUtils;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 10:08
 **/
@Service
public class WxManager {
    Logger logger = Logger.getLogger(WxManager.class);

    @Autowired(required=false)
    private WxAccountRelationMapper wxAccountRelationMapper;

    @Autowired(required = false)
    private RealtorUnitiveAccountMapper realtorUnitiveAccountMapper;

    @Value("${wx_official_account_web_base_url}")
    private String wxOfficialAccountWebBaseUrl;

    @Value("${wx_official_account_app_id}")
    private String wxOfficicalAccountAppId;

    @Value("${wx_official_account_app_secret}")
    private String wxOfficialAccountAppSecret;

    @Value("${wx_official_account_token}")
    private String wxOfficialAccountToken;

    @Value("${wx_official_account_base_url}")
    private String wxOfficialAccountBaseUrl;

    @Value("${wx_official_account_send_red_papper_url}")
    private String wxOfficialAccountSendRedPapperUrl;

    @Value("${wx_official_account_pay_mch_id}")
    private String wxOfficialAccountPayMchId;

    @Value("${wx_official_account_pay_key}")
    private String wxOfficialAccountPayKey;

    @Autowired(required = false)
    private AttachmentService attachmentService;

    @Autowired
    private RealtorInfoManager realtorInfoManager;

    @Autowired
    private RealtorUploadPicRecordMapper realtorUploadPicRecordMapper;
    /**
     * 获取网页授权微信用户openid
     * @param wxCode
     * @return
     */
    public String getWxOpenId(String wxCode) {
        StringBuilder url = new StringBuilder("");
        url.append(wxOfficialAccountWebBaseUrl).append("/access_token?");
        url.append("appid=").append(wxOfficicalAccountAppId);
        url.append("&secret=").append(wxOfficialAccountAppSecret);
        url.append("&code=").append(wxCode);
        url.append("&grant_type=authorization_code");
        logger.info("wx get openid url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!ValidateHelper.isEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    if (resultString.contains("access_token") && resultString.contains("openid")){
                        return jsonObject.getString("openid");
                    }
                    if (resultString.contains("errcode")){
                        logger.error("error to get wx url access token, the error message is: " + jsonObject.getString("errmsg"));
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<WxAccountRelation> queryByOpenId(String wxopenId){
        return wxAccountRelationMapper.queryByOpenId(wxopenId);
    }

    public List<RealtorUnitiveAccount> findByPhone(String phone){
        return realtorUnitiveAccountMapper.findByPhone(phone);
    }

    public List<WxAccountRelation> queryBindRecordByRealtorId(String realtorId){
        return wxAccountRelationMapper.queryByOpenId(realtorId);
    }
    /**
     * 由accountId查询绑定记录
     * @param accountId
     * @return
     */
    public List<WxAccountRelation> queryBingRecordByaccountId(Long accountId){
        return wxAccountRelationMapper.queryBingRecordByaccountId(accountId);

    }

    /**
     * 插入绑定记录
     * @param record
     * @return
     */
    @Transactional
    public void addBingRecord(WxAccountRelation record){
        if(record!=null){
            wxAccountRelationMapper.insert(record);
        }

    }

    /**
     * 更新绑定记录
     * @param record
     * @return
     */
    public void updateBingRecord(WxAccountRelation record){
        wxAccountRelationMapper.updateBindRecordByaccountId(record);

    }

    /**
     * 查询经纪人微信信息
     * @param realtorId
     * @return
     */
    public WxOpenBindingRecordDTO queryWxInfo(Long realtorId){
        return wxAccountRelationMapper.queryWxInfo(realtorId);
    }

    /**
     * 获取js票据
     * @return
     */
    public String getJsApiTicket(){
        Object tokenObject = RedisUtil.get("WECHAT_AJSH_JS_API_TICKET");
        if ( tokenObject != null){
            return tokenObject.toString();
        }
        StringBuilder url = new StringBuilder("");
        url.append(wxOfficialAccountBaseUrl).append("/ticket/getticket?");
        url.append("access_token=").append(getAccessToken());
        url.append("&type=jsapi");
        logger.info("wx get wx js api ticket url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!ValidateHelper.isEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    int errcode = jsonObject.getInt("errcode");
                    if (0 == errcode){
                        String jsTicket = jsonObject.getString("ticket");
                        int expireSecond = jsonObject.getInt("expires_in");
                        RedisUtil.set("WECHAT_AJSH_JS_API_TICKET", jsTicket, expireSecond/2);
                        return jsTicket;
                    }else {
                        logger.error("error to get wx js api ticket, the error message is: " + jsonObject.getString("errmsg"));
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取微信通用token
     * @return
     */
    public String getAccessToken(){
        Object tokenObject = RedisUtil.get("WECHAT_AJSH_BASE_ACCESS_TOKEN");
        if (tokenObject != null){
            logger.info("access_token------------------->" + tokenObject.toString());
            return tokenObject.toString();
        }
        StringBuilder url = new StringBuilder("");
        url.append(wxOfficialAccountBaseUrl).append("/token?");
        url.append("grant_type=client_credential");
        url.append("&appid=").append(wxOfficicalAccountAppId);
        url.append("&secret=").append(wxOfficialAccountAppSecret);
        logger.info("wx get token url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!ValidateHelper.isEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    if (resultString.contains("access_token")){
                        String accessToken = jsonObject.getString("access_token");
                        int expireSecond = jsonObject.getInt("expires_in");
                        RedisUtil.set("WECHAT_AJSH_BASE_ACCESS_TOKEN", accessToken, expireSecond/2);
                        logger.info("access_token------------------->" + accessToken);
                        return accessToken;
                    }
                    if (resultString.contains("errcode")){
                        logger.error("error to get wx access token, the error message is: " + jsonObject.getString("errmsg"));
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getNewAccessToken(){
        StringBuilder url = new StringBuilder("");
        url.append(wxOfficialAccountBaseUrl).append("/token?");
        url.append("grant_type=client_credential");
        url.append("&appid=").append(wxOfficicalAccountAppId);
        url.append("&secret=").append(wxOfficialAccountAppSecret);
        logger.info("wx get token url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!ValidateHelper.isEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    if (resultString.contains("access_token")){
                        String accessToken = jsonObject.getString("access_token");
                        int expireSecond = jsonObject.getInt("expires_in");
                        RedisUtil.set("WECHAT_AJSH_BASE_ACCESS_TOKEN", accessToken, expireSecond/2);
                        logger.info("access_token------------------->" + accessToken);
                        return accessToken;
                    }
                    if (resultString.contains("errcode")){
                        logger.error("error to get wx access token, the error message is: " + jsonObject.getString("errmsg"));
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 发送微信模板消息
     * @param templeteId
     * @param wxOpenId
     * @param callBackUrl
     * @param data
     * @return
     */
    public JSONObject sendWxTempleteMessage(String templeteId, String wxOpenId, String callBackUrl, WxTemplateMessageDataDTO data){
        StringBuilder url = new StringBuilder("");
        url.append(wxOfficialAccountBaseUrl).append("/message/template/send?");
        url.append("access_token=").append(getAccessToken());
        logger.info("wx send templete message url is ------->" + url.toString());
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("touser", wxOpenId);
        param.put("template_id", templeteId);
        param.put("url", callBackUrl);
        param.put("data", data);
        logger.info("wx send templete message content is ------->" + JSONObject.fromObject(param).toString());
        try {
            String result = ApacheHttpUtils.doPost(url.toString(), JSONObject.fromObject(param));
            if (!ValidateHelper.isEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    return jsonObject;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据微信mediaId多媒体素材
     * @param realtorInfoDTO,mediaId
     * @return
     */
    public ResultDO<Boolean> getMedia(RealtorInfoDTO realtorInfoDTO,String mediaId){
        ResultDO<Boolean> resultDO=new ResultDO<Boolean>();
        AttachmentInfo attachmentInfo=new AttachmentInfo();
        InputStream input=null;
        InputStream inputStream=null;
        InputStream inputStream2=null;
        int len=0;
        String accessToken=getAccessToken();
        boolean flag=true;
        try {
            while(flag){
                StringBuilder url = new StringBuilder("");
                url.append(wxOfficialAccountBaseUrl).append("/media/get?");
                url.append("access_token=").append(accessToken);
                url.append("&media_id=").append(mediaId);
                logger.info("wx getMedia message url is ------->" + url.toString());

                logger.info("Download pic beigin is ------->" + DateUtils.getCurrentTime());

                input = ApacheHttpUtils.doGet(url.toString());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];

                while ((len = input.read(buffer)) > -1) {
                    baos.write(buffer, 0, len);
                }
                baos.flush();
                logger.info("Download pic end is ------->" + DateUtils.getCurrentTime());
                inputStream2 = new ByteArrayInputStream(baos.toByteArray());

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream2, "utf-8"));
                StringBuffer content = new StringBuffer();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                String result = content.toString();
                try {
                    JSONObject jsonObject = JSONObject.fromObject(result);
                    if (jsonObject != null) {
                        String resultString = jsonObject.toString();
                        logger.info("wx getMedia response data is --------------->" + resultString);
                        String errcode = jsonObject.getString("errcode");
                        //access_token is invalid
                        if (errcode.equals("40001")) {
                            accessToken=getNewAccessToken();
                            continue;
                        }
                        //不合法的媒体文件id
                        if (errcode.equals("40007")) {
                            resultDO.setErrMsg(jsonObject.getString("errmsg"));
                            return resultDO;
                        }
                    }
                } catch ( JSONException e ) {
                    inputStream = new ByteArrayInputStream(baos.toByteArray());
                    logger.info("OSS upload pic beigin is ------->" + DateUtils.getCurrentTime());
                    ResultDO<AttachmentInfo> resultDO1 = attachmentService.upload2OSS("wx/card", ".jpg", inputStream);
                    logger.info("OSS upload pic end is ------->" + DateUtils.getCurrentTime());
                    if (!resultDO1.isSuccess()) {//上传失败记录
                        addUploadPicExceptionRecord(realtorInfoDTO, mediaId, YesNo.NO.getValue(), String.valueOf(resultDO1.getData()));
                        resultDO.setErrMsg(resultDO1.getErrMsg());
                        return resultDO;
                    }
                    //图片上传成功后后传入URL
                    realtorInfoDTO.setCardImg(resultDO1.getData().getUrl());
                    //保存信息
                    addRealtorInfo(realtorInfoDTO);
                    flag=false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream2!=null){
                try {
                    inputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultDO;
    }

    public Map<String, Object> sendWxRedPapper(String mchBillNo, String wxOpenId, Long sendAmount){
        logger.info("wx send red papper url is ------->" + wxOfficialAccountSendRedPapperUrl);
        Map<String, Object> param = new HashMap<String, Object>();
        String nonce_str = StringUtils.getRandomString(32);
        param.put("nonce_str", nonce_str);
        param.put("mch_billno", mchBillNo);
        param.put("mch_id", wxOfficialAccountPayMchId);
        param.put("wxappid", wxOfficicalAccountAppId);
        param.put("send_name", "上房经纪人");
        param.put("re_openid", wxOpenId);
        param.put("total_amount", sendAmount);
        param.put("total_num", 1);
        param.put("wishing", "祝你金三银四业绩长虹");
        param.put("client_ip", "121.43.164.229");
        param.put("act_name", "祝你金三银四业绩长虹");
        param.put("remark", "祝你金三银四业绩长虹");
        Collection<String> keyset = param.keySet();
        List<String> list = new ArrayList<String>(keyset);
        Collections.sort(list);
        StringBuilder signString = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            signString.append(list.get(i) + "=" + param.get(list.get(i)));
            if (i != list.size() - 1){
                signString.append("&");
            }
        }
        signString.append("&key=" + wxOfficialAccountPayKey);
        logger.info("wx pay wait signature string is ----->" + signString.toString());
        String sign = MD5Utils.encrypt(signString.toString(), "MD5").toUpperCase();
        param.put("sign", sign);
        logger.info("wx send red papper content is ------->" + JSONObject.fromObject(param).toString());
        try {
            //String cerPath = WxManager.class.getClassLoader().getResource(".").getPath() + "/cert/apiclient_cert.p12";
            String cerPath = "/srv/cert/apiclient_cert.p12";
            String result = ApacheHttpUtils.doPostForCertificate(wxOfficialAccountSendRedPapperUrl, StringUtils.map2XmlString(param), cerPath);
            if (!ValidateHelper.isEmpty(result)){
                Map<String, Object> map = WxUtils.parseXml(result);
                if (map != null){
                    String resultString = JSON.toJSONString(map);
                    logger.info("wx response data is --------------->" + resultString);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 经纪人上传图片异常记录
     * @param realtorInfoDTO
     *@param mediaId
     * @param type
     */
    @Transactional(rollbackFor = AppException.class)
    public void addUploadPicExceptionRecord(RealtorInfoDTO realtorInfoDTO,String mediaId,Integer type,String reason) throws AppException{
        RealtorUploadPicRecord record=new RealtorUploadPicRecord();
        record.setRealtorId(realtorInfoDTO.getRealtorId());
        record.setMediaId(mediaId);
        record.setType(type);
        record.setReason(reason);
        realtorUploadPicRecordMapper.insert(record);
    }

    /**
     * 经纪人信息保存
     * @param realtorInfoDTO
     */
    public String addRealtorInfo(RealtorInfoDTO realtorInfoDTO) {
        try {
            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorInfoDTO.getRealtorId());
            if (account == null) {
                return "查询账户信息错误";
            }

            realtorInfoDTO.setTelphone(account.getPhone());
            realtorInfoManager.basicInfo(realtorInfoDTO);
            //修改审核状态
            int count = realtorInfoManager.updateRealtorStatus(realtorInfoDTO);
            if (count == 0 || count > 1) {
                return "审核状态修改失败";
            }
        } catch ( AppException e1 ) {
            return "基础信息认证异常！";
        }
        return null;
    }


}
