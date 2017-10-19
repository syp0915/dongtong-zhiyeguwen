package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.building.domain.BuildingHouse.java
 * @Description: 新房房源表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingHouse extends BaseBean {
    /**
     * 楼盘id
     */
    private Long buildingId;

    /**
     * 楼栋id
     */
    private Long buildingUnitId;

    /**
     * 房号
     */
    private String houseNo;

    /**
     * 状态0-可售 1-已售
     */
    private Integer status;

    /**
     * 户型id
     */
    private Long houseHoldId;

    /**
     * 实际楼层
     */
    private Integer actualFloor;

    /**
     * 建筑面积
     */
    private BigDecimal structureArea;

    /**
     * 套内面积
     */
    private BigDecimal innerArea;

    /**
     * 地下面积
     */
    private BigDecimal undergroundArea;

    /**
     * 分摊面积
     */
    private BigDecimal shareArea;

    /**
     * 0-期房 1-现房 
     */
    private Integer completetype;

    private Long creator;

    /**
     * 获取楼盘id
     *
     * @return building_id
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置楼盘id
     *
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取楼栋id
     *
     * @return building_unit_id
     */
    public Long getBuildingUnitId() {
        return buildingUnitId;
    }

    /**
     * 设置楼栋id
     *
     * @param buildingUnitId
     */
    public void setBuildingUnitId(Long buildingUnitId) {
        this.buildingUnitId = buildingUnitId;
    }

    /**
     * 获取房号
     *
     * @return house_no
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 设置房号
     *
     * @param houseNo
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    /**
     * 获取状态0-可售 1-已售
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0-可售 1-已售
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取户型id
     *
     * @return house_hold_id
     */
    public Long getHouseHoldId() {
        return houseHoldId;
    }

    /**
     * 设置户型id
     *
     * @param houseHoldId
     */
    public void setHouseHoldId(Long houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    /**
     * 获取实际楼层
     *
     * @return actual_floor
     */
    public Integer getActualFloor() {
        return actualFloor;
    }

    /**
     * 设置实际楼层
     *
     * @param actualFloor
     */
    public void setActualFloor(Integer actualFloor) {
        this.actualFloor = actualFloor;
    }

    /**
     * 获取建筑面积
     *
     * @return structure_area
     */
    public BigDecimal getStructureArea() {
        return structureArea;
    }

    /**
     * 设置建筑面积
     *
     * @param structureArea
     */
    public void setStructureArea(BigDecimal structureArea) {
        this.structureArea = structureArea;
    }

    /**
     * 获取套内面积
     *
     * @return inner_area
     */
    public BigDecimal getInnerArea() {
        return innerArea;
    }

    /**
     * 设置套内面积
     *
     * @param innerArea
     */
    public void setInnerArea(BigDecimal innerArea) {
        this.innerArea = innerArea;
    }

    /**
     * 获取地下面积
     *
     * @return underground_area
     */
    public BigDecimal getUndergroundArea() {
        return undergroundArea;
    }

    /**
     * 设置地下面积
     *
     * @param undergroundArea
     */
    public void setUndergroundArea(BigDecimal undergroundArea) {
        this.undergroundArea = undergroundArea;
    }

    /**
     * 获取分摊面积
     *
     * @return share_area
     */
    public BigDecimal getShareArea() {
        return shareArea;
    }

    /**
     * 设置分摊面积
     *
     * @param shareArea
     */
    public void setShareArea(BigDecimal shareArea) {
        this.shareArea = shareArea;
    }

    /**
     * 获取0-期房 1-现房 
     *
     * @return completeType
     */
    public Integer getCompletetype() {
        return completetype;
    }

    /**
     * 设置0-期房 1-现房 
     *
     * @param completetype
     */
    public void setCompletetype(Integer completetype) {
        this.completetype = completetype;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @Title toString
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
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
        sb.append(", buildingUnitId=").append(buildingUnitId);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", status=").append(status);
        sb.append(", houseHoldId=").append(houseHoldId);
        sb.append(", actualFloor=").append(actualFloor);
        sb.append(", structureArea=").append(structureArea);
        sb.append(", innerArea=").append(innerArea);
        sb.append(", undergroundArea=").append(undergroundArea);
        sb.append(", shareArea=").append(shareArea);
        sb.append(", completetype=").append(completetype);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}