package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsHouse.java
 * @Description: 房源leads二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017
 * All right reserved.
 * Author lv bin
 * @date 2017/05/16 14:45
 * version v1.0.0
 */
public class LeadsHouse extends BaseBean {
    /**
     * 房源编号
     */
    private String houseCode;

    /**
     * 房屋来源  0-数据抓取 1-人际抓取 2-外部购买 3-其它渠道
     */
    private Integer source;

    /**
     * 导入人id-即后台导入管理员id
     */
    private Long adminId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 维度
     */
    private String latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 导入小区名称
     */
    private String importPlotName;

    /**
     * 小区Id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 楼栋编号
     */
    private String unitNo;

    /**
     * 门牌号
     */
    private String houseNo;

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
     * 建筑面积
     */
    private Float area;

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
     * 所在楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 建造年份
     */
    private String buildYear;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 产权年限
     */
    private Integer ownerYears;

    /**
     * 状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    private Integer status;

    /**
     * 是否删除（0-否 1-是）
     */
    private Integer isDelete;

    /**
     * 授权状态（0-等待授权 1-授权静默 2-已授权 3-默认授权 4-未授权）
     */
    private Integer grantStatus;

    /**
     * 同意授权时间
     */
    private Date grantTime;

    /**
     * 授权短信发送时间
     */
    private Date grantSmsTime;

    /**
     * 获取房源编号
     *
     * @return house_code
     */
    public String getHouseCode() {
        return houseCode;
    }

    /**
     * 设置房源编号
     *
     * @param houseCode
     */
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode == null ? null : houseCode.trim();
    }

    /**
     * 获取房屋来源  0-数据抓取 1-人际抓取 2-外部购买 3-其它渠道
     *
     * @return source
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置房屋来源  0-数据抓取 1-人际抓取 2-外部购买 3-其它渠道
     *
     * @param source
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取导入人id-即后台导入管理员id
     *
     * @return admin_id
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 设置导入人id-即后台导入管理员id
     *
     * @param adminId
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
     * 获取维度
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置维度
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取地址
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取导入小区名称
     *
     * @return import_plot_name
     */
    public String getImportPlotName() {
        return importPlotName;
    }

    /**
     * 设置导入小区名称
     *
     * @param importPlotName
     */
    public void setImportPlotName(String importPlotName) {
        this.importPlotName = importPlotName == null ? null : importPlotName.trim();
    }

    /**
     * 获取小区Id
     *
     * @return plot_id
     */
    public Long getPlotId() {
        return plotId;
    }

    /**
     * 设置小区Id
     *
     * @param plotId
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
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
     * 获取楼栋编号
     *
     * @return unit_no
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 设置楼栋编号
     *
     * @param unitNo
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    /**
     * 获取门牌号
     *
     * @return house_no
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 设置门牌号
     *
     * @param houseNo
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
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
     * 获取所在楼层
     *
     * @return floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 设置所在楼层
     *
     * @param floor
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * 获取总楼层
     *
     * @return total_floor
     */
    public Integer getTotalFloor() {
        return totalFloor;
    }

    /**
     * 设置总楼层
     *
     * @param totalFloor
     */
    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    /**
     * 获取建造年份
     *
     * @return build_year
     */
    public String getBuildYear() {
        return buildYear;
    }

    /**
     * 设置建造年份
     *
     * @param buildYear
     */
    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    /**
     * 获取单价
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取总价
     *
     * @return total_price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
     * 获取状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
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
     * 获取授权状态（0-等待授权 1-授权静默 2-已授权 3-默认授权 4-未授权）
     *
     * @return grant_status
     */
    public Integer getGrantStatus() {
        return grantStatus;
    }

    /**
     * 设置授权状态（0-等待授权 1-授权静默 2-已授权 3-默认授权 4-未授权）
     *
     * @param grantStatus
     */
    public void setGrantStatus(Integer grantStatus) {
        this.grantStatus = grantStatus;
    }

    /**
     * 获取同意授权时间
     *
     * @return grant_time
     */
    public Date getGrantTime() {
        return grantTime;
    }

    /**
     * 设置同意授权时间
     *
     * @param grantTime
     */
    public void setGrantTime(Date grantTime) {
        this.grantTime = grantTime;
    }

    /**
     * 获取授权短信发送时间
     *
     * @return grant_sms_time
     */
    public Date getGrantSmsTime() {
        return grantSmsTime;
    }

    /**
     * 设置授权短信发送时间
     *
     * @param grantSmsTime
     */
    public void setGrantSmsTime(Date grantSmsTime) {
        this.grantSmsTime = grantSmsTime;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/05/16 14:45
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", houseCode=").append(houseCode);
        sb.append(", source=").append(source);
        sb.append(", adminId=").append(adminId);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", address=").append(address);
        sb.append(", importPlotName=").append(importPlotName);
        sb.append(", plotId=").append(plotId);
        sb.append(", plotName=").append(plotName);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", cityId=").append(cityId);
        sb.append(", districtId=").append(districtId);
        sb.append(", blockId=").append(blockId);
        sb.append(", area=").append(area);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", bathroom=").append(bathroom);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", floor=").append(floor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", buildYear=").append(buildYear);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", ownerYears=").append(ownerYears);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", grantStatus=").append(grantStatus);
        sb.append(", grantTime=").append(grantTime);
        sb.append(", grantSmsTime=").append(grantSmsTime);
        sb.append("]");
        return sb.toString();
    }
}