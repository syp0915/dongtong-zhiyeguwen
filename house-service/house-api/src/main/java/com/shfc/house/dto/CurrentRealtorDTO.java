package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.CurrentUserDTO
 * @Description: 经纪人登录统一返回类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/9 17:55
 * version V1.0.0
 */
public class CurrentRealtorDTO implements Serializable {
    private Long realtorId;//经纪人id
    private String phone;//经纪人手机号
    private Integer status;//经纪人状态 (0待审核;1审核通过;2不通过(冻结);3已解约;4审核中)
    private String tokenKey;//令牌
    private String headPortrait;//用户头像
    private String comName;//公司名称
    private String storeName;//门店名称
    private String realName;//用户真实姓名

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
