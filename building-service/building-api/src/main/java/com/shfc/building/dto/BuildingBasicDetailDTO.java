package com.shfc.building.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-06-14 10:04
 **/

public class BuildingBasicDetailDTO implements Serializable {
    private Long buildingId;//	新房id
    private String buildingName;//	新房名称
    private List<String> picList;//	图片url集合
    private Integer saleStatus;//	销售状态
    private String districtName;//	区域名称
    private String blockName;//	板块名称
    private String buildingAddress;//楼盘地址

    private String longitude;//楼盘位置经度
    private String latitude;//楼盘位置纬度
    private BigDecimal areaAveragePrice;//	面积单价
    private BigDecimal houseAveragePrice;//整套均价
    private String openDate;//开盘时间
    private String deliveryDate;//交房时间
    private List<BaseTagDTO> tagList;//标签列表

    private String agent;//代理商名称
    private String commission;//	佣金比例
    private String commissionExplain;//佣金说明
    private String agentPhone;//代理商电话
    private String developer;//开发商
    private String propertyCompany;//物业公司
    private Byte propertyType;//物业类型
    private Integer ownerYears;//产权年限
    private Float volumeRatio;//容积率
    private Float greeningRatio;//绿化率
    private Integer houseCount;//规划户数
    private Integer parkingCount;//车位数
    private String parkingRatio;//车位比
    private String  salePhone;//	咨询电话

    private Boolean attention;//是否已关注

    public List<BaseTagDTO> getTagList() {
        return tagList;
    }

    public void setTagList(List<BaseTagDTO> tagList) {
        this.tagList = tagList;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(Integer parkingCount) {
        this.parkingCount = parkingCount;
    }

    public String getParkingRatio() {
        return parkingRatio;
    }

    public void setParkingRatio(String parkingRatio) {
        this.parkingRatio = parkingRatio;
    }

    public String getSalePhone() {
        return salePhone;
    }

    public void setSalePhone(String salePhone) {
        this.salePhone = salePhone;
    }

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

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
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

    public BigDecimal getAreaAveragePrice() {
        return areaAveragePrice;
    }

    public void setAreaAveragePrice(BigDecimal areaAveragePrice) {
        this.areaAveragePrice = areaAveragePrice;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCommissionExplain() {
        return commissionExplain;
    }

    public void setCommissionExplain(String commissionExplain) {
        this.commissionExplain = commissionExplain;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public Byte getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Byte propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getOwnerYears() {
        return ownerYears;
    }

    public void setOwnerYears(Integer ownerYears) {
        this.ownerYears = ownerYears;
    }

    public Float getVolumeRatio() {
        return volumeRatio;
    }

    public void setVolumeRatio(Float volumeRatio) {
        this.volumeRatio = volumeRatio;
    }

    public Float getGreeningRatio() {
        return greeningRatio;
    }

    public void setGreeningRatio(Float greeningRatio) {
        this.greeningRatio = greeningRatio;
    }

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    public Boolean getAttention() {
        return attention;
    }

    public void setAttention(Boolean attention) {
        this.attention = attention;
    }

    public BigDecimal getHouseAveragePrice() {
        return houseAveragePrice;
    }

    public void setHouseAveragePrice(BigDecimal houseAveragePrice) {
        this.houseAveragePrice = houseAveragePrice;
    }
}
