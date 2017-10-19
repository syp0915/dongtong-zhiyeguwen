package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.HbPrizeRecord.java
 * @Description: 抽奖记录表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/14 18:25
 * version v1.0.0
 */
public class HbPrizeRecord extends BaseBean {
    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 奖品id
     */
    private Long prizeId;

    /**
     * 中奖账号id
     */
    private Long accountId;

    /**
     * 账号类型(0经纪人,1用户)
     */
    private Integer type;

    /**
     * 中奖手机号
     */
    private String phone;

    /**
     * 获取活动id
     *
     * @return activity_id
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置活动id
     *
     * @param activityId
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取活动名称
     *
     * @return activity_name
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    /**
     * 获取奖品id
     *
     * @return prize_id
     */
    public Long getPrizeId() {
        return prizeId;
    }

    /**
     * 设置奖品id
     *
     * @param prizeId
     */
    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    /**
     * 获取中奖账号id
     *
     * @return account_id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置中奖账号id
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
     * 获取中奖手机号
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置中奖手机号
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", activityName=").append(activityName);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", accountId=").append(accountId);
        sb.append(", type=").append(type);
        sb.append(", phone=").append(phone);
        sb.append("]");
        return sb.toString();
    }
}