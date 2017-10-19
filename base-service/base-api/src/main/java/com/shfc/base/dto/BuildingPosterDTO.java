package com.shfc.base.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *自有楼盘海报内容
 * @author wky
 * @version V1.0
 * @create 2017-08-02 14:34
 **/
public class BuildingPosterDTO implements Serializable {

    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getBuildingPictureUrl() {
        return buildingPictureUrl;
    }

    public void setBuildingPictureUrl(String buildingPictureUrl) {
        this.buildingPictureUrl = buildingPictureUrl;
    }

    public String getPosterTopic() {
        return posterTopic;
    }

    public void setPosterTopic(String posterTopic) {
        this.posterTopic = posterTopic;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSaleModel() {
        return saleModel;
    }

    public void setSaleModel(String saleModel) {
        this.saleModel = saleModel;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints;
    }
}
