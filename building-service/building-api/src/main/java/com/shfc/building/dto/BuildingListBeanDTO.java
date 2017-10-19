package com.shfc.building.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/12 下午8:15.
 */
public class BuildingListBeanDTO implements Serializable {
    private Long buildingId;//	新房id
    private String buildingName;//	新房名称
    private String picUrl;//	封面图url
    private Integer saleStatus;//	销售状态
    private Integer publishStatus;//发布状态0-已上架 10已下架
    private String districtName;//	区域名称
    private String blockName;//	板块名称
    private BigDecimal areaAveragePrice;//	面积单价
    private BigDecimal houseAveragePrice;// 整套均价
    private List<Integer> householdArray;//	户型列表
    private String commission;//	佣金比例

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public BigDecimal getAreaAveragePrice() {
        return areaAveragePrice;
    }

    public void setAreaAveragePrice(BigDecimal areaAveragePrice) {
        this.areaAveragePrice = areaAveragePrice;
    }

    public List<Integer> getHouseholdArray() {
        return householdArray;
    }

    public void setHouseholdArray(List<Integer> householdArray) {
        this.householdArray = householdArray;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public BigDecimal getHouseAveragePrice() {
        return houseAveragePrice;
    }

    public void setHouseAveragePrice(BigDecimal houseAveragePrice) {
        this.houseAveragePrice = houseAveragePrice;
    }
}
