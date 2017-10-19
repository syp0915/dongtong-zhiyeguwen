package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.BuyMemberDTO
 * @Description: 购买会员的DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 20:08
 * version V1.0.0
 */
public class BuyMemberDTO implements Serializable {
    private Long orderId;//订单ID
    //private Long comboId;//套餐ID
    private String invitationCode;	//邀请码
    private Integer payType;//支付类型

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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
