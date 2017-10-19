package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.RealtorCompany.java
 * @Description: 经纪公司
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author liaozm
 * @date 2017/06/07 10:48
 * version v1.0.0
 */
public class RealtorCompany extends BaseBean {
    /**
     * 经纪公司E签宝账号ID
     */
    private String accountId;

    /**
     * 公司名字
     */
    private String comName;

    /**
     * 公司简写
     */
    private String comAbbr;

    /**
     * 公司成立时间
     */
    private Date comCreateAt;

    /**
     * 公司状态- 0- 正常 1停用 9-异常
     */
    private Integer comStatus;

    /**
     * 企业类型 0-普通企业 1-社会团体 2-事业单位 3-民办非企业单位 4-党政及国家机构
     */
    private Byte comType;

    /**
     * 公司电话
     */
    private String comTel;

    /**
     * 公司图片
     */
    private String comImg;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 门店数
     */
    private Integer storeNum;

    /**
     * 经纪人数
     */
    private Integer realtorNum;

    /**
     * 交易中心编号
     */
    private String tradingCenterNo;

    /**
     * 代码编号
     */
    private String codeNo;

    /**
     * 代码类型 0-组织机构代码,1-三证合一的社会信用代码
     */
    private Boolean codeType;

    /**
     * 签章负责人姓名
     */
    private String chargePerson;

    /**
     * 签章负责人类型 1-代理人 2-法人
     */
    private Byte chargePersonType;

    /**
     * 签章负责人身份证号码
     */
    private String chargePersonIdentity;

    /**
     * 经纪公司签章下弦文
     */
    private String qText;

    /**
     * 是否删除 0：否，1：是
     */
    private Integer isDel;

    /**
     * 经纪公司签章数据 base64数据
     */
    private String sealData;

    /**
     * 获取经纪公司E签宝账号ID
     *
     * @return account_id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置经纪公司E签宝账号ID
     *
     * @param accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 获取公司名字
     *
     * @return com_name
     */
    public String getComName() {
        return comName;
    }

    /**
     * 设置公司名字
     *
     * @param comName
     */
    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    /**
     * 获取公司简写
     *
     * @return com_abbr
     */
    public String getComAbbr() {
        return comAbbr;
    }

    /**
     * 设置公司简写
     *
     * @param comAbbr
     */
    public void setComAbbr(String comAbbr) {
        this.comAbbr = comAbbr == null ? null : comAbbr.trim();
    }

    /**
     * 获取公司成立时间
     *
     * @return com_create_at
     */
    public Date getComCreateAt() {
        return comCreateAt;
    }

    /**
     * 设置公司成立时间
     *
     * @param comCreateAt
     */
    public void setComCreateAt(Date comCreateAt) {
        this.comCreateAt = comCreateAt;
    }

    /**
     * 获取公司状态- 0- 正常 1停用 9-异常
     *
     * @return com_status
     */
    public Integer getComStatus() {
        return comStatus;
    }

    /**
     * 设置公司状态- 0- 正常 1停用 9-异常
     *
     * @param comStatus
     */
    public void setComStatus(Integer comStatus) {
        this.comStatus = comStatus;
    }

    /**
     * 获取企业类型 0-普通企业 1-社会团体 2-事业单位 3-民办非企业单位 4-党政及国家机构
     *
     * @return com_type
     */
    public Byte getComType() {
        return comType;
    }

    /**
     * 设置企业类型 0-普通企业 1-社会团体 2-事业单位 3-民办非企业单位 4-党政及国家机构
     *
     * @param comType
     */
    public void setComType(Byte comType) {
        this.comType = comType;
    }

    /**
     * 获取公司电话
     *
     * @return com_tel
     */
    public String getComTel() {
        return comTel;
    }

    /**
     * 设置公司电话
     *
     * @param comTel
     */
    public void setComTel(String comTel) {
        this.comTel = comTel == null ? null : comTel.trim();
    }

    /**
     * 获取公司图片
     *
     * @return com_img
     */
    public String getComImg() {
        return comImg;
    }

    /**
     * 设置公司图片
     *
     * @param comImg
     */
    public void setComImg(String comImg) {
        this.comImg = comImg == null ? null : comImg.trim();
    }

    /**
     * 获取联系人
     *
     * @return linkman
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * 获取合同编号
     *
     * @return contract_number
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * 设置合同编号
     *
     * @param contractNumber
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    /**
     * 获取门店数
     *
     * @return store_num
     */
    public Integer getStoreNum() {
        return storeNum;
    }

    /**
     * 设置门店数
     *
     * @param storeNum
     */
    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    /**
     * 获取经纪人数
     *
     * @return realtor_num
     */
    public Integer getRealtorNum() {
        return realtorNum;
    }

    /**
     * 设置经纪人数
     *
     * @param realtorNum
     */
    public void setRealtorNum(Integer realtorNum) {
        this.realtorNum = realtorNum;
    }

    /**
     * 获取交易中心编号
     *
     * @return trading_center_no
     */
    public String getTradingCenterNo() {
        return tradingCenterNo;
    }

    /**
     * 设置交易中心编号
     *
     * @param tradingCenterNo
     */
    public void setTradingCenterNo(String tradingCenterNo) {
        this.tradingCenterNo = tradingCenterNo == null ? null : tradingCenterNo.trim();
    }

    /**
     * 获取代码编号
     *
     * @return code_no
     */
    public String getCodeNo() {
        return codeNo;
    }

    /**
     * 设置代码编号
     *
     * @param codeNo
     */
    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo == null ? null : codeNo.trim();
    }

    /**
     * 获取代码类型 0-组织机构代码,1-三证合一的社会信用代码
     *
     * @return code_type
     */
    public Boolean getCodeType() {
        return codeType;
    }

    /**
     * 设置代码类型 0-组织机构代码,1-三证合一的社会信用代码
     *
     * @param codeType
     */
    public void setCodeType(Boolean codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取签章负责人姓名
     *
     * @return charge_person
     */
    public String getChargePerson() {
        return chargePerson;
    }

    /**
     * 设置签章负责人姓名
     *
     * @param chargePerson
     */
    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson == null ? null : chargePerson.trim();
    }

    /**
     * 获取签章负责人类型 1-代理人 2-法人
     *
     * @return charge_person_type
     */
    public Byte getChargePersonType() {
        return chargePersonType;
    }

    /**
     * 设置签章负责人类型 1-代理人 2-法人
     *
     * @param chargePersonType
     */
    public void setChargePersonType(Byte chargePersonType) {
        this.chargePersonType = chargePersonType;
    }

    /**
     * 获取签章负责人身份证号码
     *
     * @return charge_person_identity
     */
    public String getChargePersonIdentity() {
        return chargePersonIdentity;
    }

    /**
     * 设置签章负责人身份证号码
     *
     * @param chargePersonIdentity
     */
    public void setChargePersonIdentity(String chargePersonIdentity) {
        this.chargePersonIdentity = chargePersonIdentity == null ? null : chargePersonIdentity.trim();
    }

    /**
     * 获取经纪公司签章下弦文
     *
     * @return q_text
     */
    public String getqText() {
        return qText;
    }

    /**
     * 设置经纪公司签章下弦文
     *
     * @param qText
     */
    public void setqText(String qText) {
        this.qText = qText == null ? null : qText.trim();
    }

    /**
     * 获取是否删除 0：否，1：是
     *
     * @return is_del
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除 0：否，1：是
     *
     * @param isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取经纪公司签章数据 base64数据
     *
     * @return seal_data
     */
    public String getSealData() {
        return sealData;
    }

    /**
     * 设置经纪公司签章数据 base64数据
     *
     * @param sealData
     */
    public void setSealData(String sealData) {
        this.sealData = sealData == null ? null : sealData.trim();
    }
}