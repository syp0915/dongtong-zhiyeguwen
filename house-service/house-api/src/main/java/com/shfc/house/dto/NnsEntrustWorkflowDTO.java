package com.shfc.house.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package com.shfc.house.dto.NnsEntrustWorkflowDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 13:31
 * version V1.0.0
 */
public class NnsEntrustWorkflowDTO implements Serializable {
    private Long id ;//主键id
    private Long protocolId;//协议id
    private Integer protocolStatus;//协议状态
    private String statusText;//协议文案
    private String createTime;//创建时间

    private Date successTime;//签约成功时间
    private Date overdueTime;//协议有效截止日期

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getProtocolStatus() {
        return protocolStatus;
    }

    public void setProtocolStatus(Integer protocolStatus) {
        this.protocolStatus = protocolStatus;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }
}
