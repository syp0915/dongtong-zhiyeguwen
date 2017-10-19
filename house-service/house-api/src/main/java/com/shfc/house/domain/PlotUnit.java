package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.PlotUnit.java
 * @Description: 小区楼栋表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class PlotUnit extends BaseBean {
    /**
     * 估价宝楼栋id
     */
    private Long buildingId;

    /**
     * 小区id
     */
    private Long plotId;

    /**
     * 楼栋号
     */
    private String unitNo;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 总户数
     */
    private Integer totalRoom;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 获取估价宝楼栋id
     *
     * @return building_id
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置估价宝楼栋id
     *
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取小区id
     *
     * @return plot_id
     */
    public Long getPlotId() {
        return plotId;
    }

    /**
     * 设置小区id
     *
     * @param plotId
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    /**
     * 获取楼栋号
     *
     * @return unit_no
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 设置楼栋号
     *
     * @param unitNo
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    /**
     * 获取总楼层
     *
     * @return total_floor
     */
    public Integer getTotalFloor() {
        return totalFloor;
    }

    /**
     * 设置总楼层
     *
     * @param totalFloor
     */
    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    /**
     * 获取总户数
     *
     * @return total_room
     */
    public Integer getTotalRoom() {
        return totalRoom;
    }

    /**
     * 设置总户数
     *
     * @param totalRoom
     */
    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }

    /**
     * 获取经度
     *
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取纬度
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取创建人
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人
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
        sb.append(", buildingId=").append(buildingId);
        sb.append(", plotId=").append(plotId);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", totalRoom=").append(totalRoom);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}