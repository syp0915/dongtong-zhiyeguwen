package com.shfc.house.dto;

import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package com.shfc.house.dto.NnsProtocolListDTO
 * @Description: 委托宝-房源委托列表
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:59
 * version V1.0.0
 */
public class NnsHouseEntrustListDTO implements Serializable{
    private Long protocolId ;//协议id
    private String houseName;//房屋名称 = 小区名称+楼栋号+门牌号
    private String plotName;//小区名称
    private String unitNo;//楼栋号
    private String houseNo;//室号
    private Integer status;//协议状态
    private Integer type;//协议类型(0-在线签订，1-拍照上传)
    private String statusText;//协议文案
    private String createTime;//创建时间
    private Date successTime;//签约成功时间
    private Date overdueTime;//协议有效截止日期

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
