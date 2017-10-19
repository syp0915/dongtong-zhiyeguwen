package com.shfc.house.httpbean.resp;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:35.
 */
public class RespBean60101Detail implements Serializable{

    private static final long serialVersionUID = -7318677748129331969L;
    private String plotName;//	小区名称
    private String buildingUnitNo;//	楼栋号
    private String floorCount;//	楼层
    private String roomNo;//	室号
    private String realtorCmpName;//	经纪公司简称
    private String shopName;//	门店名称
    private String realtorName;//	经纪人姓名
    private int agreementStatus;//	协议状态
    private String agreementId;//	协议id
    private String contractTime;//	协议签署时间
    private BigDecimal agreementPrice;//	协议价格

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getBuildingUnitNo() {
        return buildingUnitNo;
    }

    public void setBuildingUnitNo(String buildingUnitNo) {
        this.buildingUnitNo = buildingUnitNo;
    }

    public String getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(String floorCount) {
        this.floorCount = floorCount;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRealtorCmpName() {
        return realtorCmpName;
    }

    public void setRealtorCmpName(String realtorCmpName) {
        this.realtorCmpName = realtorCmpName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getRealtorName() {
        return realtorName;
    }

    public void setRealtorName(String realtorName) {
        this.realtorName = realtorName;
    }

    public int getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(int agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getContractTime() {
        return contractTime;
    }

    public void setContractTime(String contractTime) {
        this.contractTime = contractTime;
    }

    public BigDecimal getAgreementPrice() {
        return agreementPrice;
    }

    public void setAgreementPrice(BigDecimal agreementPrice) {
        this.agreementPrice = agreementPrice;
    }
}
