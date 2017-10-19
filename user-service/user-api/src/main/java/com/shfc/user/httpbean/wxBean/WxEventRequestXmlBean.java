package com.shfc.user.httpbean.wxBean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/16 上午10:37.
 */
@XmlRootElement
public class WxEventRequestXmlBean implements Serializable{

    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private String Event;
    private String EventKey;
    private String Ticket;

    @XmlAttribute(name = "ToUserName")
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    @XmlAttribute(name = "FromUserName")
    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    @XmlAttribute(name = "CreateTime")
    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    @XmlAttribute(name = "MsgType")
    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    @XmlAttribute(name = "Event")
    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    @XmlAttribute(name = "EventKey")
    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    @XmlAttribute(name = "Ticket")
    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
