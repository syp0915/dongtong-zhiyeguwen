package com.shfc.user.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/13 下午1:46.
 */
@Component
public class WxEnvPropertiesFileValue {

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

    public String getWxOfficialAccountWebBaseUrl() {
        return wxOfficialAccountWebBaseUrl;
    }

    public void setWxOfficialAccountWebBaseUrl(String wxOfficialAccountWebBaseUrl) {
        this.wxOfficialAccountWebBaseUrl = wxOfficialAccountWebBaseUrl;
    }

    public String getWxOfficicalAccountAppId() {
        return wxOfficicalAccountAppId;
    }

    public void setWxOfficicalAccountAppId(String wxOfficicalAccountAppId) {
        this.wxOfficicalAccountAppId = wxOfficicalAccountAppId;
    }

    public String getWxOfficialAccountAppSecret() {
        return wxOfficialAccountAppSecret;
    }

    public void setWxOfficialAccountAppSecret(String wxOfficialAccountAppSecret) {
        this.wxOfficialAccountAppSecret = wxOfficialAccountAppSecret;
    }

    public String getWxOfficialAccountToken() {
        return wxOfficialAccountToken;
    }

    public void setWxOfficialAccountToken(String wxOfficialAccountToken) {
        this.wxOfficialAccountToken = wxOfficialAccountToken;
    }

    public String getWxOfficialAccountBaseUrl() {
        return wxOfficialAccountBaseUrl;
    }

    public void setWxOfficialAccountBaseUrl(String wxOfficialAccountBaseUrl) {
        this.wxOfficialAccountBaseUrl = wxOfficialAccountBaseUrl;
    }
}
