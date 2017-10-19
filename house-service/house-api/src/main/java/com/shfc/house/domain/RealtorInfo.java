package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorInfo.java
 * @Description: 经纪人基本信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:25
 * version v1.0.0
 */
public class RealtorInfo extends BaseBean {
    /**
     * 经纪人账户ID
     */
    private Long realtorId;

    /**
     * 手机号
     */
    private String telphone;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 公司id
     */
    private Long comId;

    /**
     * 公司名称
     */
    private String comName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户签名
     */
    private String userAutograph;

    /**
     * 性别(0男1女)
     */
    private Integer gender;

    /**
     * 职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
     */
    private Integer position;

    /**
     * 门店代码
     */
    private String storeCode;

    /**
     * 身份证
     */
    private String identityNo;

    /**
     * 身份证扫描件
     */
    private String identityNoImg;

    /**
     * 资格证书编号
     */
    private String certificateNo;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 经纪人名片正面
     */
    private String cardImg;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 从业年限
     */
    private Integer workTimeLimit;

    /**
     * 主营区域id
     */
    private Long districtId;

    /**
     * 主营区域名称
     */
    private String districtName;

    /**
     * 主营板块id
     */
    private Long blockId;

    /**
     * 主营板块名称
     */
    private String blockName;

    /**
     * 主营楼盘
     */
    private String buildingNameList;

    /**
     * 是否实名认证 0否 1是
     */
    private Boolean isAuth;

    /**
     * 经纪人的评分
     */
    private Float level;

    /**
     * 经纪人编号
     */
    private String realtorNumber;
    /**
     * 邀请码
     */
    private String invitationCode;

    /**
     * 获取经纪人账户ID
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人账户ID
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取手机号
     *
     * @return telphone
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 设置手机号
     *
     * @param telphone
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * 获取门店ID
     *
     * @return store_id
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * 设置门店ID
     *
     * @param storeId
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取门店名称
     *
     * @return store_name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置门店名称
     *
     * @param storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取公司id
     *
     * @return com_id
     */
    public Long getComId() {
        return comId;
    }

    /**
     * 设置公司id
     *
     * @param comId
     */
    public void setComId(Long comId) {
        this.comId = comId;
    }

    /**
     * 获取公司名称
     *
     * @return com_name
     */
    public String getComName() {
        return comName;
    }

    /**
     * 设置公司名称
     *
     * @param comName
     */
    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取用户签名
     *
     * @return user_autograph
     */
    public String getUserAutograph() {
        return userAutograph;
    }

    /**
     * 设置用户签名
     *
     * @param userAutograph
     */
    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph == null ? null : userAutograph.trim();
    }

    /**
     * 获取性别(0男1女)
     *
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(0男1女)
     *
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
     *
     * @return position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
     *
     * @param position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取门店代码
     *
     * @return store_code
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * 设置门店代码
     *
     * @param storeCode
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    /**
     * 获取身份证
     *
     * @return identity_no
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * 设置身份证
     *
     * @param identityNo
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * 获取身份证扫描件
     *
     * @return identity_no_img
     */
    public String getIdentityNoImg() {
        return identityNoImg;
    }

    /**
     * 设置身份证扫描件
     *
     * @param identityNoImg
     */
    public void setIdentityNoImg(String identityNoImg) {
        this.identityNoImg = identityNoImg == null ? null : identityNoImg.trim();
    }

    /**
     * 获取资格证书编号
     *
     * @return certificate_no
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * 设置资格证书编号
     *
     * @param certificateNo
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    /**
     * 获取银行账户
     *
     * @return bank_account
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账户
     *
     * @param bankAccount
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取经纪人名片正面
     *
     * @return card_img
     */
    public String getCardImg() {
        return cardImg;
    }

    /**
     * 设置经纪人名片正面
     *
     * @param cardImg
     */
    public void setCardImg(String cardImg) {
        this.cardImg = cardImg == null ? null : cardImg.trim();
    }

    /**
     * 获取头像
     *
     * @return head_portrait
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 设置头像
     *
     * @param headPortrait
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    /**
     * 获取从业年限
     *
     * @return work_time_limit
     */
    public Integer getWorkTimeLimit() {
        return workTimeLimit;
    }

    /**
     * 设置从业年限
     *
     * @param workTimeLimit
     */
    public void setWorkTimeLimit(Integer workTimeLimit) {
        this.workTimeLimit = workTimeLimit;
    }

    /**
     * 获取主营区域id
     *
     * @return district_id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置主营区域id
     *
     * @param districtId
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取主营区域名称
     *
     * @return district_name
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * 设置主营区域名称
     *
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * 获取主营板块id
     *
     * @return block_id
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置主营板块id
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取主营板块名称
     *
     * @return block_name
     */
    public String getBlockName() {
        return blockName;
    }

    /**
     * 设置主营板块名称
     *
     * @param blockName
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName == null ? null : blockName.trim();
    }

    /**
     * 获取主营楼盘
     *
     * @return building_name_list
     */
    public String getBuildingNameList() {
        return buildingNameList;
    }

    /**
     * 设置主营楼盘
     *
     * @param buildingNameList
     */
    public void setBuildingNameList(String buildingNameList) {
        this.buildingNameList = buildingNameList == null ? null : buildingNameList.trim();
    }

    /**
     * 获取是否实名认证 0否 1是
     *
     * @return is_auth
     */
    public Boolean getIsAuth() {
        return isAuth;
    }

    /**
     * 设置是否实名认证 0否 1是
     *
     * @param isAuth
     */
    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    /**
     * 获取经纪人的评分
     *
     * @return level
     */
    public Float getLevel() {
        return level;
    }

    /**
     * 设置经纪人的评分
     *
     * @param level
     */
    public void setLevel(Float level) {
        this.level = level;
    }

    /**
     * 获取经纪人编号
     *
     * @return realtor_number
     */
    public String getRealtorNumber() {
        return realtorNumber;
    }

    /**
     * 设置经纪人编号
     *
     * @param realtorNumber
     */
    public void setRealtorNumber(String realtorNumber) {
        this.realtorNumber = realtorNumber == null ? null : realtorNumber.trim();
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Boolean getAuth() {
        return isAuth;
    }

    public void setAuth(Boolean auth) {
        isAuth = auth;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", realtorId=").append(realtorId);
        sb.append(", telphone=").append(telphone);
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName=").append(storeName);
        sb.append(", comId=").append(comId);
        sb.append(", comName=").append(comName);
        sb.append(", realName=").append(realName);
        sb.append(", userAutograph=").append(userAutograph);
        sb.append(", gender=").append(gender);
        sb.append(", position=").append(position);
        sb.append(", storeCode=").append(storeCode);
        sb.append(", identityNo=").append(identityNo);
        sb.append(", identityNoImg=").append(identityNoImg);
        sb.append(", certificateNo=").append(certificateNo);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", cardImg=").append(cardImg);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", workTimeLimit=").append(workTimeLimit);
        sb.append(", districtId=").append(districtId);
        sb.append(", districtName=").append(districtName);
        sb.append(", blockId=").append(blockId);
        sb.append(", blockName=").append(blockName);
        sb.append(", buildingNameList=").append(buildingNameList);
        sb.append(", isAuth=").append(isAuth);
        sb.append(", level=").append(level);
        sb.append(", realtorNumber=").append(realtorNumber);
        sb.append("]");
        return sb.toString();
    }
}