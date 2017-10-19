package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.building.domain.BuildingUnit.java
 * @Description: 新房楼栋表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingUnit extends BaseBean {
    /**
     * 楼盘id
     */
    private Long buildingId;

    /**
     * 楼栋编号
     */
    private Integer unitNo;

    /**
     * 图片地址
     */
    private String coverPicUrl;

    /**
     * 楼层数
     */
    private Integer floorCount;

    /**
     * 总户数
     */
    private Integer housetCountt;

    /**
     * 梯户比-户
     */
    private Integer stairHouseRatio;

    /**
     * 装修类型(0-毛坯 1-简装 2-精装)
     */
    private Integer decorateType;

    /**
     * 销售状态
     */
    private Integer salesStatus;

    /**
     * 梯户比-梯
     */
    private Integer stairs;

    /**
     * 创建人
     */
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
     * 获取楼栋编号
     *
     * @return unit_no
     */
    public Integer getUnitNo() {
        return unitNo;
    }

    /**
     * 设置楼栋编号
     *
     * @param unitNo
     */
    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * 获取图片地址
     *
     * @return cover_pic_url
     */
    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    /**
     * 设置图片地址
     *
     * @param coverPicUrl
     */
    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl == null ? null : coverPicUrl.trim();
    }

    /**
     * 获取楼层数
     *
     * @return floor_count
     */
    public Integer getFloorCount() {
        return floorCount;
    }

    /**
     * 设置楼层数
     *
     * @param floorCount
     */
    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    /**
     * 获取总户数
     *
     * @return houset_countt
     */
    public Integer getHousetCountt() {
        return housetCountt;
    }

    /**
     * 设置总户数
     *
     * @param housetCountt
     */
    public void setHousetCountt(Integer housetCountt) {
        this.housetCountt = housetCountt;
    }

    /**
     * 获取梯户比-户
     *
     * @return stair_house_ratio
     */
    public Integer getStairHouseRatio() {
        return stairHouseRatio;
    }

    /**
     * 设置梯户比-户
     *
     * @param stairHouseRatio
     */
    public void setStairHouseRatio(Integer stairHouseRatio) {
        this.stairHouseRatio = stairHouseRatio;
    }

    /**
     * 获取装修类型(0-毛坯 1-简装 2-精装)
     *
     * @return decorate_type
     */
    public Integer getDecorateType() {
        return decorateType;
    }

    /**
     * 设置装修类型(0-毛坯 1-简装 2-精装)
     *
     * @param decorateType
     */
    public void setDecorateType(Integer decorateType) {
        this.decorateType = decorateType;
    }

    /**
     * 获取销售状态
     *
     * @return sales_status
     */
    public Integer getSalesStatus() {
        return salesStatus;
    }

    /**
     * 设置销售状态
     *
     * @param salesStatus
     */
    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
    }

    /**
     * 获取梯户比-梯
     *
     * @return stairs
     */
    public Integer getStairs() {
        return stairs;
    }

    /**
     * 设置梯户比-梯
     *
     * @param stairs
     */
    public void setStairs(Integer stairs) {
        this.stairs = stairs;
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
        sb.append(", unitNo=").append(unitNo);
        sb.append(", coverPicUrl=").append(coverPicUrl);
        sb.append(", floorCount=").append(floorCount);
        sb.append(", housetCountt=").append(housetCountt);
        sb.append(", stairHouseRatio=").append(stairHouseRatio);
        sb.append(", decorateType=").append(decorateType);
        sb.append(", salesStatus=").append(salesStatus);
        sb.append(", stairs=").append(stairs);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}