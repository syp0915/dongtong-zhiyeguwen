package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.SendSignNoteDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/20 17:50
 * version V1.0.0
 */
public class SendSignNoteDTO implements Serializable {
    private Long protocolId;//协议id
    private String phone;//手机号
    private String url;//请求地址

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
