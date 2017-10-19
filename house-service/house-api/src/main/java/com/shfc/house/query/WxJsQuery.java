package com.shfc.house.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-17 18:53
 **/
public class WxJsQuery implements Serializable {
    private static final long serialVersionUID = 471228767421608046L;
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
