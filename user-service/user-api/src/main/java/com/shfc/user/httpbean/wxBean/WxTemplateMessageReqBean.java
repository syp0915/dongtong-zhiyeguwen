package com.shfc.user.httpbean.wxBean;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/15 下午3:13.
 */
public class WxTemplateMessageReqBean implements Serializable {
    private String touser;
    private String template_id;
    private String url;
    private WxTemplateMessageDataBean data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WxTemplateMessageDataBean getData() {
        return data;
    }

    public void setData(WxTemplateMessageDataBean data) {
        this.data = data;
    }
}
