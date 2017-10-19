package com.shfc.base.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.base.dto.SysMessageDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/14 16:46
 * version V1.0.0
 */
public class SysMessageDTO implements Serializable {
     // 消息来源 详见 SysMessageFrom.java
    private Integer mesFrom;
     // 消息类型 详见SysMessageType.java
    private Integer mesType;
     // 业务ID
    private Long bizId;
     // 用户ID(消息的接收人)
    private Long userId;
     // 1.经纪人，2.用户，3.销售人员
    private Integer userType;
     // 消息摘要
    private String mesDigest;
     // 消息内容
    private String mesContent;
    //协议时间
    private String createTime;
    //状态(0.未读、1.已读)
    private Integer status;

    public Integer getMesFrom() {
        return mesFrom;
    }

    public void setMesFrom(Integer mesFrom) {
        this.mesFrom = mesFrom;
    }

    public Integer getMesType() {
        return mesType;
    }

    public void setMesType(Integer mesType) {
        this.mesType = mesType;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMesDigest() {
        return mesDigest;
    }

    public void setMesDigest(String mesDigest) {
        this.mesDigest = mesDigest;
    }

    public String getMesContent() {
        return mesContent;
    }

    public void setMesContent(String mesContent) {
        this.mesContent = mesContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
