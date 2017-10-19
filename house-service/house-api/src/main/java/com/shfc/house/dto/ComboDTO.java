package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Package com.shfc.house.dto.ComboDTO
 * @Description: 套餐DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 15:54
 * version V1.0.0
 */
public class ComboDTO implements Serializable {
    private Long comboId;//套餐ID
    private String comboName = "";//套餐名称
    private String comboPrice = "";//套餐价格
    private Integer houseNum;//可看房源数
    private Integer phoneNum;//可拨打电话数

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

    public String getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(String comboPrice) {
        comboPrice = new DecimalFormat("0.##").format(Double.parseDouble(comboPrice));
        this.comboPrice = comboPrice;
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
}
