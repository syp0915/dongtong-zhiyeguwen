package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/20 下午1:51
 * version V1.0.0
 */
public class WxOpenBindingRecordDTO implements Serializable {
    private Long accountId;//本地账号id

    private Integer type;//账号类型(0经纪人,1用户)

    private String wxOpenId;//微信公众号id

    private String createTime;//审核时间

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
