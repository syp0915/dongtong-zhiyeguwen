package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.Plot.java
 * @Description: 小区
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class Plot extends BaseBean {
    /**
     * 估价宝小区id
     */
    private Long residenceId;

    /**
     * 小区所在城市
     */
    private Long cityId;

    /**
     * 板块id
     */
    private Long blockId;

    /**
     * 区域id
     */
    private Long districtId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 小区别名
     */
    private String plotAlias;

    /**
     * 小区名称全拼
     */
    private String plotPinyin;

    /**
     * 小区名称拼音缩写
     */
    private String plotPinyinAbbr;

    /**
     * 小区地址
     */
    private String plotAddress;

    /**
     * 小区邮编
     */
    private String plotPostcode;

    /**
     * 小区X坐标
     */
    private String longtitude;

    /**
     * 小区Y坐标
     */
    private String latitude;

    /**
     * 小区类别（1老公房[一般住宅] 2公寓[别墅+住宅]3别墅[纯别墅]4酒店式公寓[商住混合]5花园洋房 6其它）
     */
    private Integer plotType;

    /**
     * 建筑类型
     */
    private Integer plotBuildType;

    /**
     * 建造年份
     */
    private Integer plotBuildYear;

    /**
     * 总占地面积
     */
    private BigDecimal plotLandArea;

    /**
     * 总建筑面积
     */
    private BigDecimal plotBuildArea;

    /**
     * 容积率
     */
    private BigDecimal plotVolumeRatio;

    /**
     * 绿化率
     */
    private BigDecimal plotGreenRatio;

    /**
     * 平均得房率
     */
    private BigDecimal plotConstructionRatio;

    /**
     * 楼栋数
     */
    private Short buildingCount;

    /**
     * 总户数
     */
    private Integer houseCount;

    /**
     * 车位总数
     */
    private Integer groundParkingCount;

    /**
     * 固定车位
     */
    private Integer undergroundParkingCount;

    /**
     * 物业费
     */
    private BigDecimal propertyFee;

    /**
     * 封面图编号
     */
    private String plotCoverPicUrl;

    /**
     * 小区状态 0-正常 9-禁用
     */
    private Integer plotStatus;

    /**
     * 小区均价
     */
    private Integer averagePrice;

    /**
     * 优惠信息
     */
    private String plotDiscountInfo;

    /**
     * 供暖方式
     */
    private String heatMethod;

    /**
     * 开发商id
     */
    private Long developerId;

    /**
     * 开发商名称
     */
    private String developerName;

    /**
     * 产权年限
     */
    private Integer propertyRight;

    /**
     * 环线位置
     */
    private String loopLocation;

    /**
     * 交工日期
     */
    private Date completeDate;

    /**
     * 数据创建人id
     */
    private Long creator;

    /**
     * 获取估价宝小区id
     *
     * @return residence_id
     */
    public Long getResidenceId() {
        return residenceId;
    }

    /**
     * 设置估价宝小区id
     *
     * @param residenceId
     */
    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    /**
     * 获取小区所在城市
     *
     * @return city_id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置小区所在城市
     *
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取板块id
     *
     * @return block_id
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置板块id
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取区域id
     *
     * @return district_id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置区域id
     *
     * @param districtId
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取小区名称
     *
     * @return plot_name
     */
    public String getPlotName() {
        return plotName;
    }

    /**
     * 设置小区名称
     *
     * @param plotName
     */
    public void setPlotName(String plotName) {
        this.plotName = plotName == null ? null : plotName.trim();
    }

    /**
     * 获取小区别名
     *
     * @return plot_alias
     */
    public String getPlotAlias() {
        return plotAlias;
    }

    /**
     * 设置小区别名
     *
     * @param plotAlias
     */
    public void setPlotAlias(String plotAlias) {
        this.plotAlias = plotAlias == null ? null : plotAlias.trim();
    }

    /**
     * 获取小区名称全拼
     *
     * @return plot_pinyin
     */
    public String getPlotPinyin() {
        return plotPinyin;
    }

    /**
     * 设置小区名称全拼
     *
     * @param plotPinyin
     */
    public void setPlotPinyin(String plotPinyin) {
        this.plotPinyin = plotPinyin == null ? null : plotPinyin.trim();
    }

    /**
     * 获取小区名称拼音缩写
     *
     * @return plot_pinyin_abbr
     */
    public String getPlotPinyinAbbr() {
        return plotPinyinAbbr;
    }

    /**
     * 设置小区名称拼音缩写
     *
     * @param plotPinyinAbbr
     */
    public void setPlotPinyinAbbr(String plotPinyinAbbr) {
        this.plotPinyinAbbr = plotPinyinAbbr == null ? null : plotPinyinAbbr.trim();
    }

    /**
     * 获取小区地址
     *
     * @return plot_address
     */
    public String getPlotAddress() {
        return plotAddress;
    }

    /**
     * 设置小区地址
     *
     * @param plotAddress
     */
    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress == null ? null : plotAddress.trim();
    }

    /**
     * 获取小区邮编
     *
     * @return plot_postcode
     */
    public String getPlotPostcode() {
        return plotPostcode;
    }

    /**
     * 设置小区邮编
     *
     * @param plotPostcode
     */
    public void setPlotPostcode(String plotPostcode) {
        this.plotPostcode = plotPostcode == null ? null : plotPostcode.trim();
    }

    /**
     * 获取小区X坐标
     *
     * @return longtitude
     */
    public String getLongtitude() {
        return longtitude;
    }

    /**
     * 设置小区X坐标
     *
     * @param longtitude
     */
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude == null ? null : longtitude.trim();
    }

    /**
     * 获取小区Y坐标
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置小区Y坐标
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取小区类别（1老公房[一般住宅] 2公寓[别墅+住宅]3别墅[纯别墅]4酒店式公寓[商住混合]5花园洋房 6其它）
     *
     * @return plot_type
     */
    public Integer getPlotType() {
        return plotType;
    }

    /**
     * 设置小区类别（1老公房[一般住宅] 2公寓[别墅+住宅]3别墅[纯别墅]4酒店式公寓[商住混合]5花园洋房 6其它）
     *
     * @param plotType
     */
    public void setPlotType(Integer plotType) {
        this.plotType = plotType;
    }

    /**
     * 获取建筑类型
     *
     * @return plot_build_type
     */
    public Integer getPlotBuildType() {
        return plotBuildType;
    }

    /**
     * 设置建筑类型
     *
     * @param plotBuildType
     */
    public void setPlotBuildType(Integer plotBuildType) {
        this.plotBuildType = plotBuildType;
    }

    /**
     * 获取建造年份
     *
     * @return plot_build_year
     */
    public Integer getPlotBuildYear() {
        return plotBuildYear;
    }

    /**
     * 设置建造年份
     *
     * @param plotBuildYear
     */
    public void setPlotBuildYear(Integer plotBuildYear) {
        this.plotBuildYear = plotBuildYear;
    }

    /**
     * 获取总占地面积
     *
     * @return plot_land_area
     */
    public BigDecimal getPlotLandArea() {
        return plotLandArea;
    }

    /**
     * 设置总占地面积
     *
     * @param plotLandArea
     */
    public void setPlotLandArea(BigDecimal plotLandArea) {
        this.plotLandArea = plotLandArea;
    }

    /**
     * 获取总建筑面积
     *
     * @return plot_build_area
     */
    public BigDecimal getPlotBuildArea() {
        return plotBuildArea;
    }

    /**
     * 设置总建筑面积
     *
     * @param plotBuildArea
     */
    public void setPlotBuildArea(BigDecimal plotBuildArea) {
        this.plotBuildArea = plotBuildArea;
    }

    /**
     * 获取容积率
     *
     * @return plot_volume_ratio
     */
    public BigDecimal getPlotVolumeRatio() {
        return plotVolumeRatio;
    }

    /**
     * 设置容积率
     *
     * @param plotVolumeRatio
     */
    public void setPlotVolumeRatio(BigDecimal plotVolumeRatio) {
        this.plotVolumeRatio = plotVolumeRatio;
    }

    /**
     * 获取绿化率
     *
     * @return plot_green_ratio
     */
    public BigDecimal getPlotGreenRatio() {
        return plotGreenRatio;
    }

    /**
     * 设置绿化率
     *
     * @param plotGreenRatio
     */
    public void setPlotGreenRatio(BigDecimal plotGreenRatio) {
        this.plotGreenRatio = plotGreenRatio;
    }

    /**
     * 获取平均得房率
     *
     * @return plot_construction_ratio
     */
    public BigDecimal getPlotConstructionRatio() {
        return plotConstructionRatio;
    }

    /**
     * 设置平均得房率
     *
     * @param plotConstructionRatio
     */
    public void setPlotConstructionRatio(BigDecimal plotConstructionRatio) {
        this.plotConstructionRatio = plotConstructionRatio;
    }

    /**
     * 获取楼栋数
     *
     * @return building_count
     */
    public Short getBuildingCount() {
        return buildingCount;
    }

    /**
     * 设置楼栋数
     *
     * @param buildingCount
     */
    public void setBuildingCount(Short buildingCount) {
        this.buildingCount = buildingCount;
    }

    /**
     * 获取总户数
     *
     * @return house_count
     */
    public Integer getHouseCount() {
        return houseCount;
    }

    /**
     * 设置总户数
     *
     * @param houseCount
     */
    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    /**
     * 获取车位总数
     *
     * @return ground_parking_count
     */
    public Integer getGroundParkingCount() {
        return groundParkingCount;
    }

    /**
     * 设置车位总数
     *
     * @param groundParkingCount
     */
    public void setGroundParkingCount(Integer groundParkingCount) {
        this.groundParkingCount = groundParkingCount;
    }

    /**
     * 获取固定车位
     *
     * @return underground_parking_count
     */
    public Integer getUndergroundParkingCount() {
        return undergroundParkingCount;
    }

    /**
     * 设置固定车位
     *
     * @param undergroundParkingCount
     */
    public void setUndergroundParkingCount(Integer undergroundParkingCount) {
        this.undergroundParkingCount = undergroundParkingCount;
    }

    /**
     * 获取物业费
     *
     * @return property_fee
     */
    public BigDecimal getPropertyFee() {
        return propertyFee;
    }

    /**
     * 设置物业费
     *
     * @param propertyFee
     */
    public void setPropertyFee(BigDecimal propertyFee) {
        this.propertyFee = propertyFee;
    }

    /**
     * 获取封面图编号
     *
     * @return plot_cover_pic_url
     */
    public String getPlotCoverPicUrl() {
        return plotCoverPicUrl;
    }

    /**
     * 设置封面图编号
     *
     * @param plotCoverPicUrl
     */
    public void setPlotCoverPicUrl(String plotCoverPicUrl) {
        this.plotCoverPicUrl = plotCoverPicUrl == null ? null : plotCoverPicUrl.trim();
    }

    /**
     * 获取小区状态 0-正常 9-禁用
     *
     * @return plot_status
     */
    public Integer getPlotStatus() {
        return plotStatus;
    }

    /**
     * 设置小区状态 0-正常 9-禁用
     *
     * @param plotStatus
     */
    public void setPlotStatus(Integer plotStatus) {
        this.plotStatus = plotStatus;
    }

    /**
     * 获取小区均价
     *
     * @return average_price
     */
    public Integer getAveragePrice() {
        return averagePrice;
    }

    /**
     * 设置小区均价
     *
     * @param averagePrice
     */
    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * 获取优惠信息
     *
     * @return plot_discount_info
     */
    public String getPlotDiscountInfo() {
        return plotDiscountInfo;
    }

    /**
     * 设置优惠信息
     *
     * @param plotDiscountInfo
     */
    public void setPlotDiscountInfo(String plotDiscountInfo) {
        this.plotDiscountInfo = plotDiscountInfo == null ? null : plotDiscountInfo.trim();
    }

    /**
     * 获取供暖方式
     *
     * @return heat_method
     */
    public String getHeatMethod() {
        return heatMethod;
    }

    /**
     * 设置供暖方式
     *
     * @param heatMethod
     */
    public void setHeatMethod(String heatMethod) {
        this.heatMethod = heatMethod == null ? null : heatMethod.trim();
    }

    /**
     * 获取开发商id
     *
     * @return developer_id
     */
    public Long getDeveloperId() {
        return developerId;
    }

    /**
     * 设置开发商id
     *
     * @param developerId
     */
    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    /**
     * 获取开发商名称
     *
     * @return developer_name
     */
    public String getDeveloperName() {
        return developerName;
    }

    /**
     * 设置开发商名称
     *
     * @param developerName
     */
    public void setDeveloperName(String developerName) {
        this.developerName = developerName == null ? null : developerName.trim();
    }

    /**
     * 获取产权年限
     *
     * @return property_right
     */
    public Integer getPropertyRight() {
        return propertyRight;
    }

    /**
     * 设置产权年限
     *
     * @param propertyRight
     */
    public void setPropertyRight(Integer propertyRight) {
        this.propertyRight = propertyRight;
    }

    /**
     * 获取环线位置
     *
     * @return loop_location
     */
    public String getLoopLocation() {
        return loopLocation;
    }

    /**
     * 设置环线位置
     *
     * @param loopLocation
     */
    public void setLoopLocation(String loopLocation) {
        this.loopLocation = loopLocation == null ? null : loopLocation.trim();
    }

    /**
     * 获取交工日期
     *
     * @return complete_date
     */
    public Date getCompleteDate() {
        return completeDate;
    }

    /**
     * 设置交工日期
     *
     * @param completeDate
     */
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    /**
     * 获取数据创建人id
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置数据创建人id
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
        sb.append(", residenceId=").append(residenceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", blockId=").append(blockId);
        sb.append(", districtId=").append(districtId);
        sb.append(", plotName=").append(plotName);
        sb.append(", plotAlias=").append(plotAlias);
        sb.append(", plotPinyin=").append(plotPinyin);
        sb.append(", plotPinyinAbbr=").append(plotPinyinAbbr);
        sb.append(", plotAddress=").append(plotAddress);
        sb.append(", plotPostcode=").append(plotPostcode);
        sb.append(", longtitude=").append(longtitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", plotType=").append(plotType);
        sb.append(", plotBuildType=").append(plotBuildType);
        sb.append(", plotBuildYear=").append(plotBuildYear);
        sb.append(", plotLandArea=").append(plotLandArea);
        sb.append(", plotBuildArea=").append(plotBuildArea);
        sb.append(", plotVolumeRatio=").append(plotVolumeRatio);
        sb.append(", plotGreenRatio=").append(plotGreenRatio);
        sb.append(", plotConstructionRatio=").append(plotConstructionRatio);
        sb.append(", buildingCount=").append(buildingCount);
        sb.append(", houseCount=").append(houseCount);
        sb.append(", groundParkingCount=").append(groundParkingCount);
        sb.append(", undergroundParkingCount=").append(undergroundParkingCount);
        sb.append(", propertyFee=").append(propertyFee);
        sb.append(", plotCoverPicUrl=").append(plotCoverPicUrl);
        sb.append(", plotStatus=").append(plotStatus);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", plotDiscountInfo=").append(plotDiscountInfo);
        sb.append(", heatMethod=").append(heatMethod);
        sb.append(", developerId=").append(developerId);
        sb.append(", developerName=").append(developerName);
        sb.append(", propertyRight=").append(propertyRight);
        sb.append(", loopLocation=").append(loopLocation);
        sb.append(", completeDate=").append(completeDate);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}