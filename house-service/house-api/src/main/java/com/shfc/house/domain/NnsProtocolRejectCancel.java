package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.NnsProtocolRejectCancel.java
 * @Description: 委托协议拒签/撤销
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
public class NnsProtocolRejectCancel extends BaseBean {
    /**
     * 协议id
     */
    private Long protocolId;

    /**
     * 原因类型
     */
    private Integer cause;

    /**
     * 置业顾问二手房id
     */
    private String causeText;

    /**
     * 类型(0-拒签，1-撤销)
     */
    private Integer type;

    /**
     * 获取协议id
     *
     * @return protocol_id
     */
    public Long getProtocolId() {
        return protocolId;
    }

    /**
     * 设置协议id
     *
     * @param protocolId
     */
    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    /**
     * 获取原因类型
     *
     * @return cause
     */
    public Integer getCause() {
        return cause;
    }

    /**
     * 设置原因类型
     *
     * @param cause
     */
    public void setCause(Integer cause) {
        this.cause = cause;
    }

    /**
     * 获取置业顾问二手房id
     *
     * @return cause_text
     */
    public String getCauseText() {
        return causeText;
    }

    /**
     * 设置置业顾问二手房id
     *
     * @param causeText
     */
    public void setCauseText(String causeText) {
        this.causeText = causeText == null ? null : causeText.trim();
    }

    /**
     * 获取类型(0-拒签，1-撤销)
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型(0-拒签，1-撤销)
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", protocolId=").append(protocolId);
        sb.append(", cause=").append(cause);
        sb.append(", causeText=").append(causeText);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}