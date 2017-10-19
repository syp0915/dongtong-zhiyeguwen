package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.HbPrizeDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/15 16:59
 * version V1.0.0
 */
public class HbPrizeDTO implements Serializable {

    private Long prizeId;//红包id
    private String prizeName;//红包名称
    private String prizeMoney;//红包金额
    private Integer prizeAmount;//奖品数量
    private Integer prizeWeight;//红包权重
    private String accountStatus;//经纪人账户状态
    private Long activityId;//活动id
    private String activityName;//活动名称

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public Integer getPrizeWeight() {
        return prizeWeight;
    }

    public void setPrizeWeight(Integer prizeWeight) {
        this.prizeWeight = prizeWeight;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
