package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.NnsEntrustProtocolWorkflow.java
 * @Description: 委托协议状态流转表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
public class NnsEntrustProtocolWorkflow extends BaseBean {
    /**
     * 协议id
     */
    private Long protocolId;

    /**
     * 协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     */
    private Integer protocolStatus;

    /**
     * 记录文案
     */
    private String causeText;

    /**
     * 用户类型（0经纪人1用户）
     */
    private Integer createrType;

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
     * 获取协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     *
     * @return protocol_status
     */
    public Integer getProtocolStatus() {
        return protocolStatus;
    }

    /**
     * 设置协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     *
     * @param protocolStatus
     */
    public void setProtocolStatus(Integer protocolStatus) {
        this.protocolStatus = protocolStatus;
    }

    /**
     * 获取记录文案
     *
     * @return cause_text
     */
    public String getCauseText() {
        return causeText;
    }

    /**
     * 设置记录文案
     *
     * @param causeText
     */
    public void setCauseText(String causeText) {
        this.causeText = causeText == null ? null : causeText.trim();
    }

    public Integer getCreaterType() {
        return createrType;
    }

    public void setCreaterType(Integer createrType) {
        this.createrType = createrType;
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
        sb.append(", protocolStatus=").append(protocolStatus);
        sb.append("]");
        return sb.toString();
    }
}