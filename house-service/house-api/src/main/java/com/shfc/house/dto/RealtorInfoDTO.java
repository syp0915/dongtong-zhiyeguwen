package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.RealtorInfoDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/11 9:49
 * version V1.0.0
 */
public class RealtorInfoDTO implements Serializable {
    private Long realtorId;//经纪人id
    private String realName;//真实姓名
    private String storeCode;//门店代码
    private String identityNo;//身份证
    private Integer position;//职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
    private String buildingNameList;//主营楼盘
    private Long districtId;//主营区域id
    private String districtName;//主营区域名称
    private Long blockId;//主营板块id
    private String blockName;//主营板块名称
    private Long comId;//公司ID
    private String comName;//公司名称
    private String telphone;//手机号
    private Long storeId;//门店id
    private String storeName;//门店名称
    private Integer gender;//性别(0男1女)
    private String cardImg;//经纪人名片正面
    private String headPortrait;//头像
    private String certificateNo;//资格证书编号
    private String realtorNumber;//经纪人编号
    private String userAutograph;//用户签名
    private String invitationCode;//邀请码
    private String status;//会员状态  0:正常,1:过期，2：未开通
    private String describe;//会员状态描述

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getBuildingNameList() {
        return buildingNameList;
    }

    public void setBuildingNameList(String buildingNameList) {
        this.buildingNameList = buildingNameList;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCardImg() {
        return cardImg;
    }

    public void setCardImg(String cardImg) {
        this.cardImg = cardImg;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getRealtorNumber() {
        return realtorNumber;
    }

    public void setRealtorNumber(String realtorNumber) {
        this.realtorNumber = realtorNumber;
    }

    public String getUserAutograph() {
        return userAutograph;
    }

    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
