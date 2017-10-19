package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description ：二手房房源列表字段
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-22 10:58
 * version V1.0.0
 **/
public class RealtorHouseInfoDTO implements Serializable{

    private static final long serialVersionUID = -5486980201211884487L;

    /**
     * 房源Id
     */
    private Long houseId;


    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 导入小区名称
     */
    private String importPlotName;


    /**
     * 所属区域
     */
    private String districtName;

    /**
     * 所属板块
     */
    private String blockName;

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
     * 面积
     */
    private Integer area;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 审核状态  1-待审核 2-审核通过  3-审核不通过
     */
    private Integer auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;

    /**
     * 在架状态 1-待上架 2-上架 3-下架
     */
    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getImportPlotName() {
        return importPlotName;
    }

    public void setImportPlotName(String importPlotName) {
        this.importPlotName = importPlotName;
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

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
