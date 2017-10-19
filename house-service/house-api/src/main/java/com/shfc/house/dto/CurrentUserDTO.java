package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.CurrentUserDTO
 * @Description: 当前登录的用户信息
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 15:19
 * version V1.0.0
 */
public class CurrentUserDTO implements Serializable {
    private Long userId;//用户id
    private String phone;//用户手机号
    private Integer status;//状态（0-正常 1-冻结 3-异常）
    private String tokenKey;//令牌

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
