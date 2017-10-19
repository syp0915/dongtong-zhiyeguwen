package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package com.shfc.house.dto.LeadsHouseDetailDTO
 * @Description: LeadsHouseDetailDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 10:37
 * version V1.0.0
 */
public class LeadsHouseDetailDTO implements Serializable {

    private static final long serialVersionUID = 8611592902273602442L;
    /**
     * 房源id
     */
    private Long id;

    /**
     * 房源编号
     */
    private String houseCode;

    /**
     * 房源状态 状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    private Integer status;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 业主id
     */
    private Long ownerId;

    /**
     * 业主别名 eg:李先生，李女士
     */
    private String ownerAlias;

    /**
     * 业主电话
     */
    private String ownerMobile;

    /**
     * 是否是当日新增
     */
    private Boolean isNew;

    /**
     * 是否已查看 false未查看过 true-已查看过
     */
    private Boolean isScan;

    /**
     * 是否已拨打 false已拨打过 true已拨打过
     */
    private Boolean isCall;

    /**
     * 小区id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 区域id
     */
    private Long districtId;

    /**
     * 区域名称
     */
    private String districtName;

    /**
     * 板块id
     */
    private Long blockId;

    /**
     * 板块名称
     */
    private String blockName;

    /**
     * 房源地址
     */
    private String address;

    /**
     * 楼栋号
     */
    private String unitNo;

    /**
     * 门牌号
     */
    private String houseNo;

    /**
     * 面积
     */
    private Float area;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

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
     * 发布时间 MM-dd HH:mm
     */
    private String publishTime;

    /**
     * 已被查看次数
     */
    private Integer scanCount;

    /**
     * 获取属性 房源id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置属性 房源id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取属性 房源编号
     */
    public String getHouseCode() {
        return this.houseCode;
    }

    /**
     * 设置属性 房源编号
     */
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * 获取属性 房源状态 状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置属性 房源状态 状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取属性 状态名称
     */
    public String getStatusName() {
        return this.statusName;
    }

    /**
     * 设置属性 状态名称
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * 获取属性 业主id
     */
    public Long getOwnerId() {
        return this.ownerId;
    }

    /**
     * 设置属性 业主id
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取属性 业主别名 eg:李先生，李女士
     */
    public String getOwnerAlias() {
        return this.ownerAlias;
    }

    /**
     * 设置属性 业主别名 eg:李先生，李女士
     */
    public void setOwnerAlias(String ownerAlias) {
        this.ownerAlias = ownerAlias;
    }

    /**
     * 获取属性 业主电话
     */
    public String getOwnerMobile() {
        return this.ownerMobile;
    }

    /**
     * 设置属性 业主电话
     */
    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    /**
     * 获取属性 是否是当日新增
     */
    public Boolean getIsNew() {
        return this.isNew;
    }

    /**
     * 设置属性 是否是当日新增
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * 获取属性 是否已查看 false未查看过 true-已查看过
     */
    public Boolean getIsScan() {
        return this.isScan;
    }

    /**
     * 设置属性 是否已查看 false未查看过 true-已查看过
     */
    public void setIsScan(Boolean isScan) {
        this.isScan = isScan;
    }

    /**
     * 获取属性 是否已拨打 false已拨打过 true已拨打过
     */
    public Boolean getIsCall() {
        return this.isCall;
    }

    /**
     * 设置属性 是否已拨打 false已拨打过 true已拨打过
     */
    public void setIsCall(Boolean isCall) {
        this.isCall = isCall;
    }

    /**
     * 获取属性 小区id
     */
    public Long getPlotId() {
        return this.plotId;
    }

    /**
     * 设置属性 小区id
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    /**
     * 获取属性 小区名称
     */
    public String getPlotName() {
        return this.plotName;
    }

    /**
     * 设置属性 小区名称
     */
    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    /**
     * 获取属性 区域id
     */
    public Long getDistrictId() {
        return this.districtId;
    }

    /**
     * 设置属性 区域id
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取属性 区域名称
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     * 设置属性 区域名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * 获取属性 板块id
     */
    public Long getBlockId() {
        return this.blockId;
    }

    /**
     * 设置属性 板块id
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取属性 板块名称
     */
    public String getBlockName() {
        return this.blockName;
    }

    /**
     * 设置属性 板块名称
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    /**
     * 获取属性 房源地址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置属性 房源地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取属性 楼栋号
     */
    public String getUnitNo() {
        return this.unitNo;
    }

    /**
     * 设置属性 楼栋号
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * 获取属性 门牌号
     */
    public String getHouseNo() {
        return this.houseNo;
    }

    /**
     * 设置属性 门牌号
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * 获取属性 面积
     */
    public Float getArea() {
        return this.area;
    }

    /**
     * 设置属性 面积
     */
    public void setArea(Float area) {
        this.area = area;
    }

    /**
     * 获取属性 单价
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 设置属性 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取属性 总价
     */
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * 设置属性 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取属性 房
     */
    public Integer getRoom() {
        return this.room;
    }

    /**
     * 设置属性 房
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     * 获取属性 厅
     */
    public Integer getHall() {
        return this.hall;
    }

    /**
     * 设置属性 厅
     */
    public void setHall(Integer hall) {
        this.hall = hall;
    }

    /**
     * 获取属性 卫
     */
    public Integer getBathroom() {
        return this.bathroom;
    }

    /**
     * 设置属性 卫
     */
    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    /**
     * 获取属性 发布时间 MM-dd HH:mm
     */
    public String getPublishTime() {
        return this.publishTime;
    }

    /**
     * 设置属性 发布时间 MM-dd HH:mm
     */
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取属性 已被查看次数
     */
    public Integer getScanCount() {
        return this.scanCount;
    }

    /**
     * 设置属性 已被查看次数
     */
    public void setScanCount(Integer scanCount) {
        this.scanCount = scanCount;
    }
}
