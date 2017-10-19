package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.PlotAddressDTO
 * @Description: 小区dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/3 17:15
 * version V1.0.0
 */
public class PlotAddressDTO implements Serializable{

    private static final long serialVersionUID = -2356719060128344113L;
    private Long id;// 小区id
    private String plotName;// 小区名称
    private String plotAddress;// 小区地址
    private String longtitude;// 百度经度
    private String latitude;// 百度纬度

    private Long districtId; // 区域id
    private Long blockId; // 板块

    private Integer plotType; // 小区类型

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Integer getPlotType() {
        return plotType;
    }

    public void setPlotType(Integer plotType) {
        this.plotType = plotType;
    }
}
