package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.house.domain.HbPrize.java
 * @Description: 奖品表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/14 18:25
 * version v1.0.0
 */
public class HbPrize extends BaseBean {
    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 奖品金额
     */
    private BigDecimal prizeMoney;

    /**
     * 奖品数量
     */
    private Integer prizeAmount;

    /**
     * 奖品权重
     */
    private Integer prizeWeight;

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
     * 获取奖品名称
     *
     * @return prize_name
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * 设置奖品名称
     *
     * @param prizeName
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    /**
     * 获取奖品金额
     *
     * @return prize_money
     */
    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 设置奖品金额
     *
     * @param prizeMoney
     */
    public void setPrizeMoney(BigDecimal prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    /**
     * 获取奖品数量
     *
     * @return prize_amount
     */
    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    /**
     * 设置奖品数量
     *
     * @param prizeAmount
     */
    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    /**
     * 获取奖品权重
     *
     * @return prize_weight
     */
    public Integer getPrizeWeight() {
        return prizeWeight;
    }

    /**
     * 设置奖品权重
     *
     * @param prizeWeight
     */
    public void setPrizeWeight(Integer prizeWeight) {
        this.prizeWeight = prizeWeight;
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
        sb.append(", prizeName=").append(prizeName);
        sb.append(", prizeMoney=").append(prizeMoney);
        sb.append(", prizeAmount=").append(prizeAmount);
        sb.append(", prizeWeight=").append(prizeWeight);
        sb.append("]");
        return sb.toString();
    }
}