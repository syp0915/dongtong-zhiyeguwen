package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.building.domain.Building.java
 * @Description: 新房表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 20:24
 * version v1.0.0
 */
public class Building extends BaseBean {
    /**
     * 楼盘名称
     */
    private String buildingName;

    /**
     * 楼盘别名
     */
    private String buildingAliases;

    /**
     * 所属城市
     */
    private Long cityId;

    /**
     * 区域ID
     */
    private Long districtId;

    /**
     * 板块ID
     */
    private Long blockId;

    /**
     * 楼盘地址
     */
    private String address;

    /**
     * 百度经度
     */
    private BigDecimal longitude;

    /**
     * 百度纬度
     */
    private BigDecimal latitude;

    /**
     * 售楼处地址
     */
    private String salesAddress;

    /**
     * 售楼处电话
     */
    private String salesPhone;

    /**
     * 物业类型(0-公寓 1-别墅 2-洋房 3-酒店式公寓）
     */
    private Integer propertyType;

    /**
     * 物业公司
     */
    private String propertyCompany;

    /**
     * 物业费
     */
    private Float propertyCost;

    /**
     * 产权类型(0-住宅 1-商住 2-写字楼)
     */
    private Integer ownerType;

    /**
     * 产权年限
     */
    private Integer ownerYears;

    /**
     * 规划户数
     */
    private Integer houseCount;

    /**
     * 地面车位数
     */
    private Integer groundParkingCount;

    /**
     * 车位数
     */
    private Long undergroundParkingCount;

    /**
     * 车位价格
     */
    private Integer parkingPrice;

    /**
     * 容积率
     */
    private Float volumeRatio;

    /**
     * 绿化率
     */
    private Float greeningRatio;

    /**
     * 状态(0-正常 1-售罄 2-异常)
     */
    private Integer status;

    /**
     * 是否删除（0-否 1-是）
     */
    private Integer isDelete;

    /**
     * 折扣信息
     */
    private String discountInfo;

    /**
     * 交房类型0-期房 1-现房
     */
    private Integer deliveryType;

    /**
     * 均价
     */
    private BigDecimal unitAveragePrice;

    private BigDecimal houseAveragePrice;

    /**
     * 开盘时间
     */
    private Date openDate;

    /**
     * 交房日期
     */
    private Date deliveryDate;

    /**
     * 售楼处百度经度
     */
    private BigDecimal saleLongitude;

    /**
     * 售楼处百度纬度
     */
    private BigDecimal saleLatitude;

    /**
     * 佣金
     */
    private String commission;

    /**
     * 佣金描述
     */
    private String commissionDesc;

    /**
     * 创建人ID
     */
    private Long creator;

    /**
     * 封面图url
     */
    private String coverPhotoUrl;

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
     * 获取楼盘别名
     *
     * @return building_aliases
     */
    public String getBuildingAliases() {
        return buildingAliases;
    }

    /**
     * 设置楼盘别名
     *
     * @param buildingAliases
     */
    public void setBuildingAliases(String buildingAliases) {
        this.buildingAliases = buildingAliases == null ? null : buildingAliases.trim();
    }

    /**
     * 获取所属城市
     *
     * @return city_id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置所属城市
     *
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取区域ID
     *
     * @return district_id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置区域ID
     *
     * @param districtId
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取板块ID
     *
     * @return block_id
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置板块ID
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取楼盘地址
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置楼盘地址
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取百度经度
     *
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置百度经度
     *
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取百度纬度
     *
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置百度纬度
     *
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取售楼处地址
     *
     * @return sales_address
     */
    public String getSalesAddress() {
        return salesAddress;
    }

    /**
     * 设置售楼处地址
     *
     * @param salesAddress
     */
    public void setSalesAddress(String salesAddress) {
        this.salesAddress = salesAddress == null ? null : salesAddress.trim();
    }

    /**
     * 获取售楼处电话
     *
     * @return sales_phone
     */
    public String getSalesPhone() {
        return salesPhone;
    }

    /**
     * 设置售楼处电话
     *
     * @param salesPhone
     */
    public void setSalesPhone(String salesPhone) {
        this.salesPhone = salesPhone == null ? null : salesPhone.trim();
    }

    /**
     * 获取物业类型(0-公寓 1-别墅 2-洋房 3-酒店式公寓）
     *
     * @return property_type
     */
    public Integer getPropertyType() {
        return propertyType;
    }

    /**
     * 设置物业类型(0-公寓 1-别墅 2-洋房 3-酒店式公寓）
     *
     * @param propertyType
     */
    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * 获取物业公司
     *
     * @return property_company
     */
    public String getPropertyCompany() {
        return propertyCompany;
    }

    /**
     * 设置物业公司
     *
     * @param propertyCompany
     */
    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    /**
     * 获取物业费
     *
     * @return property_cost
     */
    public Float getPropertyCost() {
        return propertyCost;
    }

    /**
     * 设置物业费
     *
     * @param propertyCost
     */
    public void setPropertyCost(Float propertyCost) {
        this.propertyCost = propertyCost;
    }

    /**
     * 获取产权类型(0-住宅 1-商住 2-写字楼)
     *
     * @return owner_type
     */
    public Integer getOwnerType() {
        return ownerType;
    }

    /**
     * 设置产权类型(0-住宅 1-商住 2-写字楼)
     *
     * @param ownerType
     */
    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取产权年限
     *
     * @return owner_years
     */
    public Integer getOwnerYears() {
        return ownerYears;
    }

    /**
     * 设置产权年限
     *
     * @param ownerYears
     */
    public void setOwnerYears(Integer ownerYears) {
        this.ownerYears = ownerYears;
    }

    /**
     * 获取规划户数
     *
     * @return house_count
     */
    public Integer getHouseCount() {
        return houseCount;
    }

    /**
     * 设置规划户数
     *
     * @param houseCount
     */
    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    /**
     * 获取地面车位数
     *
     * @return ground_parking_count
     */
    public Integer getGroundParkingCount() {
        return groundParkingCount;
    }

    /**
     * 设置地面车位数
     *
     * @param groundParkingCount
     */
    public void setGroundParkingCount(Integer groundParkingCount) {
        this.groundParkingCount = groundParkingCount;
    }

    /**
     * 获取车位数
     *
     * @return underground_parking_count
     */
    public Long getUndergroundParkingCount() {
        return undergroundParkingCount;
    }

    /**
     * 设置车位数
     *
     * @param undergroundParkingCount
     */
    public void setUndergroundParkingCount(Long undergroundParkingCount) {
        this.undergroundParkingCount = undergroundParkingCount;
    }

    /**
     * 获取车位价格
     *
     * @return parking_price
     */
    public Integer getParkingPrice() {
        return parkingPrice;
    }

    /**
     * 设置车位价格
     *
     * @param parkingPrice
     */
    public void setParkingPrice(Integer parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    /**
     * 获取容积率
     *
     * @return volume_ratio
     */
    public Float getVolumeRatio() {
        return volumeRatio;
    }

    /**
     * 设置容积率
     *
     * @param volumeRatio
     */
    public void setVolumeRatio(Float volumeRatio) {
        this.volumeRatio = volumeRatio;
    }

    /**
     * 获取绿化率
     *
     * @return greening_ratio
     */
    public Float getGreeningRatio() {
        return greeningRatio;
    }

    /**
     * 设置绿化率
     *
     * @param greeningRatio
     */
    public void setGreeningRatio(Float greeningRatio) {
        this.greeningRatio = greeningRatio;
    }

    /**
     * 获取状态(0-正常 1-售罄 2-异常)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0-正常 1-售罄 2-异常)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否删除（0-否 1-是）
     *
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除（0-否 1-是）
     *
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取折扣信息
     *
     * @return discount_info
     */
    public String getDiscountInfo() {
        return discountInfo;
    }

    /**
     * 设置折扣信息
     *
     * @param discountInfo
     */
    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo == null ? null : discountInfo.trim();
    }

    /**
     * 获取交房类型0-期房 1-现房
     *
     * @return delivery_type
     */
    public Integer getDeliveryType() {
        return deliveryType;
    }

    /**
     * 设置交房类型0-期房 1-现房
     *
     * @param deliveryType
     */
    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 获取均价
     *
     * @return unit_average_price
     */
    public BigDecimal getUnitAveragePrice() {
        return unitAveragePrice;
    }

    /**
     * 设置均价
     *
     * @param unitAveragePrice
     */
    public void setUnitAveragePrice(BigDecimal unitAveragePrice) {
        this.unitAveragePrice = unitAveragePrice;
    }

    /**
     * @return house_average_price
     */
    public BigDecimal getHouseAveragePrice() {
        return houseAveragePrice;
    }

    /**
     * @param houseAveragePrice
     */
    public void setHouseAveragePrice(BigDecimal houseAveragePrice) {
        this.houseAveragePrice = houseAveragePrice;
    }

    /**
     * 获取交房日期
     *
     * @return delivery_date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * 设置交房日期
     *
     * @param deliveryDate
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * 获取售楼处百度经度
     *
     * @return sale_longitude
     */
    public BigDecimal getSaleLongitude() {
        return saleLongitude;
    }

    /**
     * 设置售楼处百度经度
     *
     * @param saleLongitude
     */
    public void setSaleLongitude(BigDecimal saleLongitude) {
        this.saleLongitude = saleLongitude;
    }

    /**
     * 获取售楼处百度纬度
     *
     * @return sale_latitude
     */
    public BigDecimal getSaleLatitude() {
        return saleLatitude;
    }

    /**
     * 设置售楼处百度纬度
     *
     * @param saleLatitude
     */
    public void setSaleLatitude(BigDecimal saleLatitude) {
        this.saleLatitude = saleLatitude;
    }

    /**
     * 获取佣金
     *
     * @return commission
     */
    public String getCommission() {
        return commission;
    }

    /**
     * 设置佣金
     *
     * @param commission
     */
    public void setCommission(String commission) {
        this.commission = commission;
    }

    /**
     * 获取佣金描述
     *
     * @return commission_desc
     */
    public String getCommissionDesc() {
        return commissionDesc;
    }

    /**
     * 设置佣金描述
     *
     * @param commissionDesc
     */
    public void setCommissionDesc(String commissionDesc) {
        this.commissionDesc = commissionDesc == null ? null : commissionDesc.trim();
    }

    /**
     * 获取创建人ID
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人ID
     *
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取封面图url
     *
     * @return cover_photo_url
     */
    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    /**
     * 设置封面图url
     *
     * @param coverPhotoUrl
     */
    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl == null ? null : coverPhotoUrl.trim();
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * @Title toString
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buildingName=").append(buildingName);
        sb.append(", buildingAliases=").append(buildingAliases);
        sb.append(", cityId=").append(cityId);
        sb.append(", districtId=").append(districtId);
        sb.append(", blockId=").append(blockId);
        sb.append(", address=").append(address);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", salesAddress=").append(salesAddress);
        sb.append(", salesPhone=").append(salesPhone);
        sb.append(", propertyType=").append(propertyType);
        sb.append(", propertyCompany=").append(propertyCompany);
        sb.append(", propertyCost=").append(propertyCost);
        sb.append(", ownerType=").append(ownerType);
        sb.append(", ownerYears=").append(ownerYears);
        sb.append(", houseCount=").append(houseCount);
        sb.append(", groundParkingCount=").append(groundParkingCount);
        sb.append(", undergroundParkingCount=").append(undergroundParkingCount);
        sb.append(", parkingPrice=").append(parkingPrice);
        sb.append(", volumeRatio=").append(volumeRatio);
        sb.append(", greeningRatio=").append(greeningRatio);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", discountInfo=").append(discountInfo);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", unitAveragePrice=").append(unitAveragePrice);
        sb.append(", houseAveragePrice=").append(houseAveragePrice);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", saleLongitude=").append(saleLongitude);
        sb.append(", saleLatitude=").append(saleLatitude);
        sb.append(", commission=").append(commission);
        sb.append(", commissionDesc=").append(commissionDesc);
        sb.append(", creator=").append(creator);
        sb.append(", coverPhotoUrl=").append(coverPhotoUrl);
        sb.append("]");
        return sb.toString();
    }
}