package com.shfc.building.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-03 13:38
 **/
public class BuildingDTO implements Serializable {

    private String buildingName;//	新房名称
    private String buildingAddress;//	楼盘地址
    private List buildingPicUrl;//楼盘图片
    private String posterTopic;//海报主题
    private String openTime;//开盘时间
    private String area;//所在区域
    private String salePrice;//销售价格
    private String saleModel;//销售户型
    private String saleArea;//销售面积
    private String sellingPoints;//楼盘卖点

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

    public List getBuildingPicUrl() {
        return buildingPicUrl;
    }

    public void setBuildingPicUrl(List buildingPicUrl) {
        this.buildingPicUrl = buildingPicUrl;
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
