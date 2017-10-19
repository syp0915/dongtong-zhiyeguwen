package com.shfc.user.httpbean.resp;

import com.shfc.user.base.BaseRespBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:33.
 */
public class RespBean60102 extends BaseRespBean {

    private String agreementId;//	协议id
    private String agreementNo;//	协议编号
    private String agreementContent;//	协议正文
    private String realtorCmpName;//	经纪公司名字
    private String realtorCmpSimpleName;//经纪公司简称
    private String realtorShopName;//	经纪门店名字
    private String realtorName;//	经纪人名字
    private String picUrl;//	经纪人头像url
    private String province;//省份
    private String city;//城市
    private String district;//区
    private String block;//板块
    private String address;//详细地址
    private int agreementStatus;//	协议状态
    private String contractTime;//	协议签约时间
    private String expirationDate;//	协议到期日期
    private String realtorPhone;//	经纪人电话
    private String plotName;//	小区名称
    private String buildingUnitNo;//	楼栋号
    private String roomNo;//	室号
    private int roomCount;//	室数
    private int hallCount;//	厅数
    private int bathroomCount;//	卫生数
    private int kitchRoomCount;//	厨房数
    private BigDecimal structureArea;//	建筑面积
    private int totalFloor;//	总楼层
    private int currentFloor;//	当前所在楼层
    private String housePropertyNo;//	房产证号
    private List<TagBean> tagList;//	标签列表
    private BigDecimal agreementPrice;//	协议价格
    private int priceType;//	协议价格类型
    private String phone;//	用户手机号

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getAgreementContent() {
        return agreementContent;
    }

    public void setAgreementContent(String agreementContent) {
        this.agreementContent = agreementContent;
    }

    public String getRealtorCmpName() {
        return realtorCmpName;
    }

    public void setRealtorCmpName(String realtorCmpName) {
        this.realtorCmpName = realtorCmpName;
    }

    public String getRealtorCmpSimpleName() {
        return realtorCmpSimpleName;
    }

    public void setRealtorCmpSimpleName(String realtorCmpSimpleName) {
        this.realtorCmpSimpleName = realtorCmpSimpleName;
    }

    public String getRealtorShopName() {
        return realtorShopName;
    }

    public void setRealtorShopName(String realtorShopName) {
        this.realtorShopName = realtorShopName;
    }

    public String getRealtorName() {
        return realtorName;
    }

    public void setRealtorName(String realtorName) {
        this.realtorName = realtorName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(int agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getContractTime() {
        return contractTime;
    }

    public void setContractTime(String contractTime) {
        this.contractTime = contractTime;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRealtorPhone() {
        return realtorPhone;
    }

    public void setRealtorPhone(String realtorPhone) {
        this.realtorPhone = realtorPhone;
    }

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

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getHallCount() {
        return hallCount;
    }

    public void setHallCount(int hallCount) {
        this.hallCount = hallCount;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public int getKitchRoomCount() {
        return kitchRoomCount;
    }

    public void setKitchRoomCount(int kitchRoomCount) {
        this.kitchRoomCount = kitchRoomCount;
    }

    public BigDecimal getStructureArea() {
        return structureArea;
    }

    public void setStructureArea(BigDecimal structureArea) {
        this.structureArea = structureArea;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getHousePropertyNo() {
        return housePropertyNo;
    }

    public void setHousePropertyNo(String housePropertyNo) {
        this.housePropertyNo = housePropertyNo;
    }

    public List<TagBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagBean> tagList) {
        this.tagList = tagList;
    }

    public BigDecimal getAgreementPrice() {
        return agreementPrice;
    }

    public void setAgreementPrice(BigDecimal agreementPrice) {
        this.agreementPrice = agreementPrice;
    }

    public int getPriceType() {
        return priceType;
    }

    public void setPriceType(int priceType) {
        this.priceType = priceType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
