package com.shfc.user.httpbean.resp;

import com.shfc.user.base.BaseRespBean;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:33.
 */
public class RespBean60108 extends BaseRespBean {

    private String wxOpenId;//微信openid
    private String userId;//上海房产用户id

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
