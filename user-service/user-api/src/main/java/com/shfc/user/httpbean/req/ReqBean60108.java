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
public class ReqBean60108 extends BaseReqBean {
    private String wxCode;//	微信openId

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }
}
