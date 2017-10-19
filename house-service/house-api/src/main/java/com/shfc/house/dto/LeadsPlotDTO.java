package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.LeadsPlotDTO
 * @Description: LeadsPlotDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 11:00
 * version V1.0.0
 */
public class LeadsPlotDTO implements Serializable {
    private static final long serialVersionUID = 7332703761604496420L;

    /**
     * 小区id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 区域id
     */
    private Long districtId;

    /**
     * 区域名称
     */
    private String districtName;

    /**
     * 板块id
     */
    private Long blockId;

    /**
     * 板块名称
     */
    private String blockName;

    /**
     * 小区地址
     */
    private String plotAddress;

    /**
     * 房源套数
     */
    private Integer houseCount;


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
     * 获取属性 小区地址
     */
    public String getPlotAddress() {
        return this.plotAddress;
    }

    /**
     * 设置属性 小区地址
     */
    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    /**
     * 获取属性 房源套数
     */
    public Integer getHouseCount() {
        return this.houseCount;
    }

    /**
     * 设置属性 房源套数
     */
    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }
}
