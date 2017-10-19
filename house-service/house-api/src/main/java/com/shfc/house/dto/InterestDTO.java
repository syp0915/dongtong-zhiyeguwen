package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.InterestDTO
 * @Description: 经纪人查看用户和房源权益DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/12 10:44
 * version V1.0.0
 */
public class InterestDTO implements Serializable {
    private Long comboId;//套餐ID
    private String comboName;//套餐名称
    private Integer houseNum;//可看房源数
    private Integer phoneNum;//可拨打电话数
    private Integer noMemberHouseNum;//非会员可看房源数
    private Integer  noMemberPhoneNum;//非会员可拨打电话数

    public Long getComboId() {
        return comboId;
    }

    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getNoMemberHouseNum() {
        return noMemberHouseNum;
    }

    public void setNoMemberHouseNum(Integer noMemberHouseNum) {
        this.noMemberHouseNum = noMemberHouseNum;
    }

    public Integer getNoMemberPhoneNum() {
        return noMemberPhoneNum;
    }

    public void setNoMemberPhoneNum(Integer noMemberPhoneNum) {
        this.noMemberPhoneNum = noMemberPhoneNum;
    }
}
