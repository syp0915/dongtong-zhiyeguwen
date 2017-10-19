package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.PlotUnitDTO
 * @Description: 楼栋列表
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 9:52
 * version V1.0.0
 */
public class PlotUnitDTO implements Serializable {
    private static final long serialVersionUID = -6783371214703495258L;

    private Long id;// 估价宝楼栋id - buildingId

    private Long plotId;// 小区id

    private String unitNo;// 楼栋号

    private Integer totalFloor;// 总楼层

    private Integer totalRoom;// 总户数

    private String longitude;// 经度

    private String latitude;// 纬度

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the plotId
     */
    public Long getPlotId() {
        return plotId;
    }

    /**
     * @param plotId the plotId to set
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    /**
     * @return the unitNo
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * @param unitNo the unitNo to set
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * @return the totalFloor
     */
    public Integer getTotalFloor() {
        return totalFloor;
    }

    /**
     * @param totalFloor the totalFloor to set
     */
    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    /**
     * @return the totalRoom
     */
    public Integer getTotalRoom() {
        return totalRoom;
    }

    /**
     * @param totalRoom the totalRoom to set
     */
    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
