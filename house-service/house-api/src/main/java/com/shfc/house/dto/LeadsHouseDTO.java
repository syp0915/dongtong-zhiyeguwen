package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package com.shfc.house.dto.LeadsHouseDTO
 * @Description: LeadsHouseDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 10:23
 * version V1.0.0
 */
public class LeadsHouseDTO implements Serializable {
    private static final long serialVersionUID = 6441786074952424031L;
    /**
     * 房源id
     */
    private Long id;

    /**
     * 房源编号
     */
    private String houseCode;

    /**
     * 是否是当日新增
     */
    private Boolean	isNew;

    /**
     * 小区id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private	String plotName;

    /**
     * 区域id
     */
    private Long districtId;

    /**
     * 区域名称
     */
    private	String districtName;

    /**
     * 板块id
     */
    private Long blockId;

    /**
     * 板块名称
     */
    private	String blockName;

    /**
     * 单价
     */
    private BigDecimal	 price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 房
     */
    private Integer	 room;

    /**
     * 厅
     */
    private Integer hall;

    /**
     * 卫
     */
    private Integer  bathroom;

    /**
     * 面积
     */
    private Float area;

    /**
     * 距离
     */
    private Float distance;

    /**
     * 获取属性 房源id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置属性 房源id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取属性 房源编号
     */
    public String getHouseCode() {
        return this.houseCode;
    }

    /**
     * 设置属性 房源编号
     */
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * 获取属性 是否是当日新增
     */
    public Boolean getIsNew() {
        return this.isNew;
    }

    /**
     * 设置属性 是否是当日新增
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

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

    /**
     * 获取属性 小区名称
     */
    public String getPlotName() {
        return this.plotName;
    }

    /**
     * 设置属性 小区名称
     */
    public void setPlotName(String plotName) {
        this.plotName = plotName;
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
     * 获取属性 区域名称
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     * 设置属性 区域名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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
     * 获取属性 板块名称
     */
    public String getBlockName() {
        return this.blockName;
    }

    /**
     * 设置属性 板块名称
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    /**
     * 获取属性 单价
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 设置属性 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取属性 总价
     */
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * 设置属性 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取属性 房
     */
    public Integer getRoom() {
        return this.room;
    }

    /**
     * 设置属性 房
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     * 获取属性 厅
     */
    public Integer getHall() {
        return this.hall;
    }

    /**
     * 设置属性 厅
     */
    public void setHall(Integer hall) {
        this.hall = hall;
    }

    /**
     * 获取属性 卫
     */
    public Integer getBathroom() {
        return this.bathroom;
    }

    /**
     * 设置属性 卫
     */
    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    /**
     * 获取属性 面积
     */
    public Float getArea() {
        return this.area;
    }

    /**
     * 设置属性 面积
     */
    public void setArea(Float area) {
        this.area = area;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
        if(distance != null){
            // 保留两位小数
            this.distance = (float)(Math.round(distance*100))/100;
        }
    }
}
