package com.shfc.user.manager;

import com.fc.common.redis.RedisUtil;
import com.shfc.common.http.ApacheHttpCilent;
import com.shfc.user.base.BaseManager;
import com.shfc.user.dao.UserMapper;
import com.shfc.user.domain.User;
import com.shfc.user.file.WxEnvPropertiesFileValue;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageDataBean;
import com.shfc.user.utils.ApacheHttpUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/16 下午3:04.
 */
@Service
public class WxManager extends BaseManager {

    Logger logger = Logger.getLogger(WxManager.class);

    @Autowired(required = false)
    private WxEnvPropertiesFileValue wxEnvPropertiesFileValue;

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 获取网页授权微信用户openid
     * @param wxCode
     * @return
     */
    public String getWxOpenId(String wxCode) {
        StringBuilder url = new StringBuilder("");
        url.append(wxEnvPropertiesFileValue.getWxOfficialAccountWebBaseUrl()).append("/access_token?");
        url.append("appid=").append(wxEnvPropertiesFileValue.getWxOfficicalAccountAppId());
        url.append("&secret=").append(wxEnvPropertiesFileValue.getWxOfficialAccountAppSecret());
        url.append("&code=").append(wxCode);
        url.append("&grant_type=authorization_code");
        logger.info("wx get openid url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!isNullOrEmpty(result)){
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

    /**
     * 发送微信模板消息
     * @param templeteId
     * @param wxOpenId
     * @param callBackUrl
     * @param data
     * @return
     */
    public JSONObject sendWxTempleteMessage(String templeteId, String wxOpenId, String callBackUrl, WxTemplateMessageDataBean data){
        StringBuilder url = new StringBuilder("");
        url.append(wxEnvPropertiesFileValue.getWxOfficialAccountBaseUrl()).append("/message/template/send?");
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
            if (!isNullOrEmpty(result)){
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
     * 获取微信通用token
     * @return
     */
    public String getAccessToken(){
        Object tokenObject = RedisUtil.get("WX_AJSH_BASE_ACCESS_TOKEN");
        if ( tokenObject != null){
            logger.info("access_token------------------->" + tokenObject.toString());
            return tokenObject.toString();
        }
        StringBuilder url = new StringBuilder("");
        url.append(wxEnvPropertiesFileValue.getWxOfficialAccountBaseUrl()).append("/token?");
        url.append("grant_type=client_credential");
        url.append("&appid=").append(wxEnvPropertiesFileValue.getWxOfficicalAccountAppId());
        url.append("&secret=").append(wxEnvPropertiesFileValue.getWxOfficialAccountAppSecret());
        logger.info("wx get token url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!isNullOrEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    if (resultString.contains("access_token")){
                        String accessToken = jsonObject.getString("access_token");
                        int expireSecond = jsonObject.getInt("expires_in");
                        RedisUtil.set("WX_AJSH_BASE_ACCESS_TOKEN", accessToken, expireSecond);
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
     * 获取js票据
     * @return
     */
    public String getJsApiTicket(){
        Object tokenObject = RedisUtil.get("WX_AJSH_JS_API_TICKET");
        if ( tokenObject != null){
            return tokenObject.toString();
        }
        StringBuilder url = new StringBuilder("");
        url.append(wxEnvPropertiesFileValue.getWxOfficialAccountBaseUrl()).append("/ticket/getticket?");
        url.append("access_token=").append(getAccessToken());
        url.append("&type=jsapi");
        logger.info("wx get wx js api ticket url is ------->" + url.toString());
        try {
            String result = ApacheHttpCilent.doGet(url.toString());
            if (!isNullOrEmpty(result)){
                JSONObject jsonObject = JSONObject.fromObject(result);
                if (jsonObject != null){
                    String resultString = jsonObject.toString();
                    logger.info("wx response data is --------------->" + resultString);
                    int errcode = jsonObject.getInt("errcode");
                    if (0 == errcode){
                        String jsTicket = jsonObject.getString("ticket");
                        int expireSecond = jsonObject.getInt("expires_in");
                        RedisUtil.set("WX_AJSH_JS_API_TICKET", jsTicket, expireSecond);
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
     * 微信取消订阅，删除微信openid字段
     * @param wxOpenId
     * @return
     */
    public boolean unsubscribeWxByOpenId(String wxOpenId){
        try {
            List<User> userList = userMapper.findUserByWxOpenId(wxOpenId);
            if (userList != null && userList.size() > 0){
                User user = userList.get(0);
                user.setWxOpenId(null);
                user.setBindingTime(null);
                user.setModifyTime(new Date());
                userMapper.updateByPrimaryKeySelective(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
