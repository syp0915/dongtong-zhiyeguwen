package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.OrderInfoDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 19:48
 * version V1.0.0
 */
public class OrderInfoDTO implements Serializable {
    private Long orderId;//订单ID
    private String orderNum = "";//订单编号
    private String invitationCode = "";//订单邀请码
    private String oderCreateTime = "";//下单时间
    private Integer orderStatus;//订单状态
    private Long comboId;//套餐ID
    private String comboName = "";//套餐名称
    private String comboPrice = "";//套餐价格
    private Integer phoneNum;//可拨打电话数
    private Integer houseNum;//可查询房源数
    private Integer second;//支付剩余时间（单位/秒）

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOderCreateTime() {
        return oderCreateTime;
    }

    public void setOderCreateTime(String oderCreateTime) {
        this.oderCreateTime = oderCreateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

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
        this.comboPrice = comboPrice;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }
}
