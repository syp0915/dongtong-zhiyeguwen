package com.shfc.user.httpbean.req;

import com.shfc.user.base.BaseReqBean;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:18.
 */
public class ReqBean60113 extends BaseReqBean {
    private String wxAccountType;//微信公众号类型
    private String url;//当前网页的url

    public String getWxAccountType() {
        return wxAccountType;
    }

    public void setWxAccountType(String wxAccountType) {
        this.wxAccountType = wxAccountType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
