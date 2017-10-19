package com.shfc.house.dto;

import com.shfc.house.domain.NnsHouse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.house.dto.NnsHouseEntrustDetailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 9:40
 * version V1.0.0
 */
public class NnsHouseEntrustDetailDTO implements Serializable {
    private Long protocolId ;//协议id
    private Integer status;//协议状态
    private Integer type;//协议类型(0-在线签订，1-拍照上传)
    private String statusText;//协议文案
    private String createTime;//创建时间
    private String ownerPhone;//业主手机号
    private List<BaseTagDTO> tagList; // 房源特色
    private Long nnsHouseId;//房源id
    private String plotName;
    private String address;
    private String totalPrice;
    private String area;
    private String unitNo;
    private String houseNo;
    private Integer room;
    private Integer hall;
    private Integer bathroom;
    private Integer kitchen;
    private String protocolContent;
    private String dealUrl;
    private Date successTime;//签约成功时间
    private Date overdueTime;//协议有效截止日期

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
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

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public List<BaseTagDTO> getTagList() {
        return tagList;
    }

    public void setTagList(List<BaseTagDTO> tagList) {
        this.tagList = tagList;
    }

    public Long getNnsHouseId() {
        return nnsHouseId;
    }

    public void setNnsHouseId(Long nnsHouseId) {
        this.nnsHouseId = nnsHouseId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public String getProtocolContent() {
        return protocolContent;
    }

    public void setProtocolContent(String protocolContent) {
        this.protocolContent = protocolContent;
    }

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
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
