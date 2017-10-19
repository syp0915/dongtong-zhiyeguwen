package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.house.domain.PlotPrice.java
 * @Description: 小区/板块/区县/城市/交易趋势
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class PlotPrice extends BaseBean {
    /**
     * 业务类型-小区id/板块id/区县id/城市id
     */
    private Long bizId;

    /**
     * 成交行情 0-小区行情 1-板块行情 2-区县行情 3-城市行情
     */
    private Integer type;

    /**
     * 一手房成交均价
     */
    private BigDecimal dealAvgPrice1st;

    /**
     * 二手房成交均价
     */
    private BigDecimal dealAvgPrice2nd;

    /**
     * 一手房成交数量
     */
    private Integer dealCount1st;

    /**
     * 二手房成交数量
     */
    private Integer dealCount2nd;

    /**
     * 月份 eg:201512
     */
    private Integer month;

    /**
     * 数据创建人id
     */
    private Long creator;

    /**
     * 获取业务类型-小区id/板块id/区县id/城市id
     *
     * @return biz_id
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * 设置业务类型-小区id/板块id/区县id/城市id
     *
     * @param bizId
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取成交行情 0-小区行情 1-板块行情 2-区县行情 3-城市行情
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置成交行情 0-小区行情 1-板块行情 2-区县行情 3-城市行情
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取一手房成交均价
     *
     * @return deal_avg_price1st
     */
    public BigDecimal getDealAvgPrice1st() {
        return dealAvgPrice1st;
    }

    /**
     * 设置一手房成交均价
     *
     * @param dealAvgPrice1st
     */
    public void setDealAvgPrice1st(BigDecimal dealAvgPrice1st) {
        this.dealAvgPrice1st = dealAvgPrice1st;
    }

    /**
     * 获取二手房成交均价
     *
     * @return deal_avg_price2nd
     */
    public BigDecimal getDealAvgPrice2nd() {
        return dealAvgPrice2nd;
    }

    /**
     * 设置二手房成交均价
     *
     * @param dealAvgPrice2nd
     */
    public void setDealAvgPrice2nd(BigDecimal dealAvgPrice2nd) {
        this.dealAvgPrice2nd = dealAvgPrice2nd;
    }

    /**
     * 获取一手房成交数量
     *
     * @return deal_count1st
     */
    public Integer getDealCount1st() {
        return dealCount1st;
    }

    /**
     * 设置一手房成交数量
     *
     * @param dealCount1st
     */
    public void setDealCount1st(Integer dealCount1st) {
        this.dealCount1st = dealCount1st;
    }

    /**
     * 获取二手房成交数量
     *
     * @return deal_count2nd
     */
    public Integer getDealCount2nd() {
        return dealCount2nd;
    }

    /**
     * 设置二手房成交数量
     *
     * @param dealCount2nd
     */
    public void setDealCount2nd(Integer dealCount2nd) {
        this.dealCount2nd = dealCount2nd;
    }

    /**
     * 获取月份 eg:201512
     *
     * @return month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置月份 eg:201512
     *
     * @param month
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 获取数据创建人id
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置数据创建人id
     *
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bizId=").append(bizId);
        sb.append(", type=").append(type);
        sb.append(", dealAvgPrice1st=").append(dealAvgPrice1st);
        sb.append(", dealAvgPrice2nd=").append(dealAvgPrice2nd);
        sb.append(", dealCount1st=").append(dealCount1st);
        sb.append(", dealCount2nd=").append(dealCount2nd);
        sb.append(", month=").append(month);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}