package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.NnsHouse.java
 * @Description: 置业顾问二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class NnsHouse extends BaseBean {
    /**
     * 房源编号
     */
    private String houseCode;

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
     * 小区Id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 楼栋号
     */
    private String unitNo;

    /**
     * 房号
     */
    private String houseNo;

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
     * 房产证类型(0-未满两年 1-满两年 2-满五年)
     */
    private Integer houseType;

    /**
     * 房价类型（0-实际到手 1-税费各付）
     */
    private Integer priceType;

    /**
     * 房价
     */
    private BigDecimal totalPrice;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private Long auditor;

    /**
     * 审核状态(0-待审核 1-审核通过  2-审核不通过)
     */
    private Integer auditStatus;

    /**
     * 审核日志
     */
    private String audtiLog;

    /**
     * 状态(0-待上架 1-上架 2-下架 )
     */
    private Integer status;

    /**
     * 是否删除（0-否 1-是）
     */
    private Integer isDelete;

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
     * 获取楼栋号
     *
     * @return unit_no
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 设置楼栋号
     *
     * @param unitNo
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    /**
     * 获取房号
     *
     * @return house_no
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 设置房号
     *
     * @param houseNo
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
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
     * 获取房产证类型(0-未满两年 1-满两年 2-满五年)
     *
     * @return house_type
     */
    public Integer getHouseType() {
        return houseType;
    }

    /**
     * 设置房产证类型(0-未满两年 1-满两年 2-满五年)
     *
     * @param houseType
     */
    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    /**
     * 获取房价类型（0-实际到手 1-税费各付）
     *
     * @return price_type
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * 设置房价类型（0-实际到手 1-税费各付）
     *
     * @param priceType
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * 获取房价
     *
     * @return total_price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置房价
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取审核人
     *
     * @return auditor
     */
    public Long getAuditor() {
        return auditor;
    }

    /**
     * 设置审核人
     *
     * @param auditor
     */
    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }

    /**
     * 获取审核状态(0-待审核 1-审核通过  2-审核不通过)
     *
     * @return audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态(0-待审核 1-审核通过  2-审核不通过)
     *
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核日志
     *
     * @return audti_log
     */
    public String getAudtiLog() {
        return audtiLog;
    }

    /**
     * 设置审核日志
     *
     * @param audtiLog
     */
    public void setAudtiLog(String audtiLog) {
        this.audtiLog = audtiLog == null ? null : audtiLog.trim();
    }

    /**
     * 获取状态(0-待上架 1-上架 2-下架 )
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0-待上架 1-上架 2-下架 )
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
        sb.append(", houseCode=").append(houseCode);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", address=").append(address);
        sb.append(", plotId=").append(plotId);
        sb.append(", plotName=").append(plotName);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", districtId=").append(districtId);
        sb.append(", blockId=").append(blockId);
        sb.append(", area=").append(area);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", bathroom=").append(bathroom);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", floor=").append(floor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", houseType=").append(houseType);
        sb.append(", priceType=").append(priceType);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", auditor=").append(auditor);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", audtiLog=").append(audtiLog);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}