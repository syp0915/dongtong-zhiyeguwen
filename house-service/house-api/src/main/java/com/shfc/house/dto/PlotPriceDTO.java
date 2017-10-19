package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package com.shfc.house.dto.PlotPriceDTO
 * @Description: 价格趋势
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:39
 * version V1.0.0
 */
public class PlotPriceDTO implements Serializable {
    private static final long serialVersionUID = -143341078279216832L;

    private Long bizId;//业务类型-小区id/板块id/区域id

    private Integer type;//成交行情 0-小区行情 1-板块行情 2-区域id

    private Integer year;//年份

    private Integer month;//月份

    private BigDecimal price;//二手房成交均价

    private BigDecimal dealAvgPrice1st;//一手房成交均价

    private BigDecimal dealAvgPrice2nd;//二手房成交均价

    private Integer dealCount1st;//一手房成交数量

    private Integer dealCount2nd;//二手房成交数量

    /**
     * @return the bizId
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * @param bizId the bizId to set
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDealAvgPrice1st() {
        return dealAvgPrice1st;
    }

    public void setDealAvgPrice1st(BigDecimal dealAvgPrice1st) {
        this.dealAvgPrice1st = dealAvgPrice1st;
    }

    public BigDecimal getDealAvgPrice2nd() {
        return dealAvgPrice2nd;
    }

    public void setDealAvgPrice2nd(BigDecimal dealAvgPrice2nd) {
        this.dealAvgPrice2nd = dealAvgPrice2nd;
    }

    public Integer getDealCount1st() {
        return dealCount1st;
    }

    public void setDealCount1st(Integer dealCount1st) {
        this.dealCount1st = dealCount1st;
    }

    public Integer getDealCount2nd() {
        return dealCount2nd;
    }

    public void setDealCount2nd(Integer dealCount2nd) {
        this.dealCount2nd = dealCount2nd;
    }
}
