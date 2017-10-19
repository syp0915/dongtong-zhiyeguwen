package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.WxOpenBindingRecord.java
 * @Description: 微信公众号绑定关系表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/14 18:25
 * version v1.0.0
 */
public class WxAccountRelation extends BaseBean {
    /**
     * 本地账号id
     */
    private Long accountId;

    /**
     * 账号类型(0经纪人,1用户)
     */
    private Integer type;

    /**
     * 微信openid
     */
    private String wxOpenId;

    /**
     * 微信公众号标识
     */
    private String wxOfficeAccountFlag;

    /**
     * 绑定时间
     */
    private Date bindingTime;

    /**
     * 绑定状态(0-已关注 1-已取消关注)
     */
    private Integer bindingStatus;

    /**
     * 获取本地账号id
     *
     * @return account_id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置本地账号id
     *
     * @param accountId
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取账号类型(0经纪人,1用户)
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置账号类型(0经纪人,1用户)
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取微信openid
     *
     * @return wx_open_id
     */
    public String getWxOpenId() {
        return wxOpenId;
    }

    /**
     * 设置微信openid
     *
     * @param wxOpenId
     */
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    /**
     * 获取微信公众号标识
     *
     * @return wx_office_account_flag
     */
    public String getWxOfficeAccountFlag() {
        return wxOfficeAccountFlag;
    }

    /**
     * 设置微信公众号标识
     *
     * @param wxOfficeAccountFlag
     */
    public void setWxOfficeAccountFlag(String wxOfficeAccountFlag) {
        this.wxOfficeAccountFlag = wxOfficeAccountFlag == null ? null : wxOfficeAccountFlag.trim();
    }

    /**
     * 获取绑定时间
     *
     * @return binding_time
     */
    public Date getBindingTime() {
        return bindingTime;
    }

    /**
     * 设置绑定时间
     *
     * @param bindingTime
     */
    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    /**
     * 获取绑定状态(0-已关注 1-已取消关注)
     *
     * @return binding_status
     */
    public Integer getBindingStatus() {
        return bindingStatus;
    }

    /**
     * 设置绑定状态(0-已关注 1-已取消关注)
     *
     * @param bindingStatus
     */
    public void setBindingStatus(Integer bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/02/21 17:55
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", type=").append(type);
        sb.append(", wxOpenId=").append(wxOpenId);
        sb.append(", wxOfficeAccountFlag=").append(wxOfficeAccountFlag);
        sb.append(", bindingTime=").append(bindingTime);
        sb.append(", bindingStatus=").append(bindingStatus);
        sb.append("]");
        return sb.toString();
    }
}