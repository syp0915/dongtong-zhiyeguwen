package com.shfc.house.query;

import java.math.BigDecimal;

/**
 * @Package com.shfc.house.query.LeadsHouseQuery
 * @Description: 房源筛选
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 9:09
 * version V1.0.0
 */
public class LeadsHouseQuery extends BaseQuery{
    /**
     * 小区id
     */
    private Long plotId;

    /**
     * 过滤掉房源id
     */
    private Long exclusionId;

    /**
     * 区域id
     */
    private Long districtId;
    /**
     * 板块id
     */
    private Long blockId;
    /**
     * 最低价格
     */
    private BigDecimal minPrice;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 最小面积
     */
    private Float minArea;

    /**
     * 最大面积
     */
    private Float maxArea;


    /**
     * 获取属性 小区id
     */
    public Long getPlotId() {
        return this.plotId;
    }

    /**
     * 设置属性 小区id
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public Long getExclusionId() {
        return exclusionId;
    }

    public void setExclusionId(Long exclusionId) {
        this.exclusionId = exclusionId;
    }

    /**
     * 获取属性 区域id
     */
    public Long getDistrictId() {
        return this.districtId;
    }

    /**
     * 设置属性 区域id
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取属性 板块id
     */
    public Long getBlockId() {
        return this.blockId;
    }

    /**
     * 设置属性 板块id
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取属性 最低价格
     */
    public BigDecimal getMinPrice() {
        return this.minPrice;
    }

    /**
     * 设置属性 最低价格
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 获取属性 最大价格
     */
    public BigDecimal getMaxPrice() {
        return this.maxPrice;
    }

    /**
     * 设置属性 最大价格
     */
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * 获取属性 最小面积
     */
    public Float getMinArea() {
        return this.minArea;
    }

    /**
     * 设置属性 最小面积
     */
    public void setMinArea(Float minArea) {
        this.minArea = minArea;
    }

    /**
     * 获取属性 最大面积
     */
    public Float getMaxArea() {
        return this.maxArea;
    }

    /**
     * 设置属性 最大面积
     */
    public void setMaxArea(Float maxArea) {
        this.maxArea = maxArea;
    }
}
