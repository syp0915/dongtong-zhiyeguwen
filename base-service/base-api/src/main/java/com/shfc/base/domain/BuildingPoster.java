package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BuildingPoster.java
 * @Description: 楼盘海报内容
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/02 14:40
 * version v1.0.0
 */
public class BuildingPoster extends BaseBean {
    /**
     * 楼盘名称
     */
    private String buildingName;

    /**
     * 楼盘地址
     */
    private String buildingAddress;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 楼盘图片地址
     */
    private String buildingPictureUrl;

    /**
     * 海报主题
     */
    private String posterTopic;

    /**
     * 开盘时间
     */
    private String openTime;

    /**
     * 所在区域
     */
    private String area;

    /**
     * 销售价格
     */
    private String salePrice;

    /**
     * 销售户型
     */
    private String saleModel;

    /**
     * 销售区域
     */
    private String saleArea;

    /**
     * 楼盘卖点
     */
    private String sellingPoints;


    /**
     * 获取楼盘名称
     *
     * @return building_name
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置楼盘名称
     *
     * @param buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    /**
     * 获取楼盘地址
     *
     * @return building_address
     */
    public String getBuildingAddress() {
        return buildingAddress;
    }

    /**
     * 设置楼盘地址
     *
     * @param buildingAddress
     */
    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress == null ? null : buildingAddress.trim();
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
     * 获取楼盘图片地址
     *
     * @return building_picture_url
     */
    public String getBuildingPictureUrl() {
        return buildingPictureUrl;
    }

    /**
     * 设置楼盘图片地址
     *
     * @param buildingPictureUrl
     */
    public void setBuildingPictureUrl(String buildingPictureUrl) {
        this.buildingPictureUrl = buildingPictureUrl == null ? null : buildingPictureUrl.trim();
    }

    /**
     * 获取海报主题
     *
     * @return poster_topic
     */
    public String getPosterTopic() {
        return posterTopic;
    }

    /**
     * 设置海报主题
     *
     * @param posterTopic
     */
    public void setPosterTopic(String posterTopic) {
        this.posterTopic = posterTopic == null ? null : posterTopic.trim();
    }

    /**
     * 获取开盘时间
     *
     * @return open_time
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * 设置开盘时间
     *
     * @param openTime
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取所在区域
     *
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在区域
     *
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取销售价格
     *
     * @return sale_price
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * 设置销售价格
     *
     * @param salePrice
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice == null ? null : salePrice.trim();
    }

    /**
     * 获取销售户型
     *
     * @return sale_model
     */
    public String getSaleModel() {
        return saleModel;
    }

    /**
     * 设置销售户型
     *
     * @param saleModel
     */
    public void setSaleModel(String saleModel) {
        this.saleModel = saleModel == null ? null : saleModel.trim();
    }

    /**
     * 获取销售区域
     *
     * @return sale_area
     */
    public String getSaleArea() {
        return saleArea;
    }

    /**
     * 设置销售区域
     *
     * @param saleArea
     */
    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea == null ? null : saleArea.trim();
    }

    /**
     * 获取楼盘卖点
     *
     * @return selling_points
     */
    public String getSellingPoints() {
        return sellingPoints;
    }

    /**
     * 设置楼盘卖点
     *
     * @param sellingPoints
     */
    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints == null ? null : sellingPoints.trim();
    }
}