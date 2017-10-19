package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.building.domain.BuildingHousehold.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingHousehold extends BaseBean {
    /**
     * 户型名称
     */
    private String name;

    /**
     * 楼盘id
     */
    private Long buildingId;

    /**
     * 是否是主推房型0-是 1-不是
     */
    private Integer isMain;

    /**
     * 房
     */
    private Integer room;

    /**
     * 厅
     */
    private Integer hall;

    /**
     * 卫
     */
    private Integer bathroom;

    /**
     * 厨房
     */
    private Integer kitchen;

    /**
     * 朝向 0-东 1-南 2-西 3-北 4-东南 5-东北 6-西南 7-西北 8-东西通透 9-南北通透 
     */
    private String orientation;

    /**
     * 得房率
     */
    private Float houseRate;

    /**
     * 建筑面积
     */
    private Float area;

    /**
     * 附赠面积
     */
    private Float giftArea;

    /**
     * 最小价格
     */
    private BigDecimal minPrice;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 参数Id
     */
    private String paramId;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 图片地址
     */
    private String coverPicUrl;

    /**
     * 获取户型名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置户型名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

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
     * 获取是否是主推房型0-是 1-不是
     *
     * @return is_main
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * 设置是否是主推房型0-是 1-不是
     *
     * @param isMain
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    /**
     * 获取房
     *
     * @return room
     */
    public Integer getRoom() {
        return room;
    }

    /**
     * 设置房
     *
     * @param room
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     * 获取厅
     *
     * @return hall
     */
    public Integer getHall() {
        return hall;
    }

    /**
     * 设置厅
     *
     * @param hall
     */
    public void setHall(Integer hall) {
        this.hall = hall;
    }

    /**
     * 获取卫
     *
     * @return bathroom
     */
    public Integer getBathroom() {
        return bathroom;
    }

    /**
     * 设置卫
     *
     * @param bathroom
     */
    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    /**
     * 获取厨房
     *
     * @return kitchen
     */
    public Integer getKitchen() {
        return kitchen;
    }

    /**
     * 设置厨房
     *
     * @param kitchen
     */
    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    /**
     * 获取朝向 0-东 1-南 2-西 3-北 4-东南 5-东北 6-西南 7-西北 8-东西通透 9-南北通透 
     *
     * @return orientation
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * 设置朝向 0-东 1-南 2-西 3-北 4-东南 5-东北 6-西南 7-西北 8-东西通透 9-南北通透 
     *
     * @param orientation
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    /**
     * 获取得房率
     *
     * @return house_rate
     */
    public Float getHouseRate() {
        return houseRate;
    }

    /**
     * 设置得房率
     *
     * @param houseRate
     */
    public void setHouseRate(Float houseRate) {
        this.houseRate = houseRate;
    }

    /**
     * 获取建筑面积
     *
     * @return area
     */
    public Float getArea() {
        return area;
    }

    /**
     * 设置建筑面积
     *
     * @param area
     */
    public void setArea(Float area) {
        this.area = area;
    }

    /**
     * 获取附赠面积
     *
     * @return gift_area
     */
    public Float getGiftArea() {
        return giftArea;
    }

    /**
     * 设置附赠面积
     *
     * @param giftArea
     */
    public void setGiftArea(Float giftArea) {
        this.giftArea = giftArea;
    }

    /**
     * 获取最小价格
     *
     * @return min_price
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * 设置最小价格
     *
     * @param minPrice
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 获取最大价格
     *
     * @return max_price
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * 设置最大价格
     *
     * @param maxPrice
     */
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * 获取参数Id
     * @return
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * 设置参数Id
     * @param paramId
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
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
        sb.append(", name=").append(name);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", isMain=").append(isMain);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", bathroom=").append(bathroom);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", orientation=").append(orientation);
        sb.append(", houseRate=").append(houseRate);
        sb.append(", area=").append(area);
        sb.append(", giftArea=").append(giftArea);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", creator=").append(creator);
        sb.append(", coverPicUrl=").append(coverPicUrl);
        sb.append("]");
        return sb.toString();
    }
}