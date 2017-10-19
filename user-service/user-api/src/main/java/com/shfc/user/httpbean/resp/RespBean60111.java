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
public class RespBean60111 extends BaseRespBean {

    private String qrCodeUrl;//上海房产公众号二维码url

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}
