package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.CheckCodeResp
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/15 14:15
 * version V1.0.0
 */
public class CheckCodeResp implements Serializable {
    private String msgId;//消息id

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
