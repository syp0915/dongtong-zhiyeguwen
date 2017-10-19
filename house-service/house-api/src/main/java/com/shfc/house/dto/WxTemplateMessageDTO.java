package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/15 下午3:13.
 */
public class WxTemplateMessageDTO implements Serializable {
    private static final long serialVersionUID = -4161283465867117612L;
    private String touser;
    private String template_id;
    private String url;
    private WxTemplateMessageDataDTO data;

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

    public WxTemplateMessageDataDTO getData() {
        return data;
    }

    public void setData(WxTemplateMessageDataDTO data) {
        this.data = data;
    }
}
