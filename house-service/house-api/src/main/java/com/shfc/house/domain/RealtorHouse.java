package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.RealtorHouse.java
 * @Description: 经纪人自有二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:50
 * version v1.0.0
 */
public class RealtorHouse extends BaseBean {
    /**
     * 房源编号
     */
    private String houseCode;

    /**
     * 所属城市
     */
    private Long cityId;

    /**
     * 区域Id
     */
    private Long districtId;

    /**
     * 板块Id
     */
    private Long blockId;

    /**
     * 小区Id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 导入小区名称
     */
    private String importPlotName;

    /**
     * 地址
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
     * 楼栋编号
     */
    private String unitNo;

    /**
     * 室号
     */
    private String houseNo;

    /**
     * 室
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
     * 朝向 1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北
     */
    private Integer orientation;

    /**
     * 面积
     */
    private Float area;

    /**
     * 所在楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 总价：万元
     */
    private BigDecimal totalPrice;

    /**
     * 房源发布人id
     */
    private Long realtorId;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private Long auditor;

    /**
     * 审核状态(1-待审核 2-审核通过  3-审核不通过)
     */
    private Integer auditStatus;

    /**
     * 审核日志
     */
    private String auditLog;

    /**
     * 状态(1-待上架 2-上架 3-下架 )
     */
    private Integer status;

    /**
     * 是否删除（1-否 2-是）
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
     * 获取区域Id
     *
     * @return district_id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * 设置区域Id
     *
     * @param districtId
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取板块Id
     *
     * @return block_id
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置板块Id
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
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
     * 获取室号
     *
     * @return house_no
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 设置室号
     *
     * @param houseNo
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    /**
     * 获取室
     *
     * @return room
     */
    public Integer getRoom() {
        return room;
    }

    /**
     * 设置室
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
     * 获取朝向 1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北
     *
     * @return orientation
     */
    public Integer getOrientation() {
        return orientation;
    }

    /**
     * 设置朝向 1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北
     *
     * @param orientation
     */
    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    /**
     * 获取面积
     *
     * @return area
     */
    public Float getArea() {
        return area;
    }

    /**
     * 设置面积
     *
     * @param area
     */
    public void setArea(Float area) {
        this.area = area;
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
     * 获取总价：万元
     *
     * @return total_price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价：万元
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取房源发布人id
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置房源发布人id
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
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
     * 获取审核状态(1-待审核 2-审核通过  3-审核不通过)
     *
     * @return audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态(1-待审核 2-审核通过  3-审核不通过)
     *
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核日志
     *
     * @return audit_log
     */
    public String getAuditLog() {
        return auditLog;
    }

    /**
     * 设置审核日志
     *
     * @param auditLog
     */
    public void setAuditLog(String auditLog) {
        this.auditLog = auditLog == null ? null : auditLog.trim();
    }

    /**
     * 获取状态(1-待上架 2-上架 3-下架 )
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(1-待上架 2-上架 3-下架 )
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否删除（1-否 2-是）
     *
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除（1-否 2-是）
     *
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}