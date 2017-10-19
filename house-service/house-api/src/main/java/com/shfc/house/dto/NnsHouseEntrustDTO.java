package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Package com.shfc.house.dto.NnsHouseEntrustDTO
 * @Description: 添加协议
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/10 9:44
 * version V1.0.0
 */
public class NnsHouseEntrustDTO implements Serializable {
    private static final long serialVersionUID = 7062504541519039771L;

    private String dealUrl;// 委托协议照片地址
    private Long plotId;//小区id
    private String unitNo;//楼栋号
    private String roomNo;//门牌号
    private Integer floor;//所在楼层
    private Integer totalFloor;//总楼层
    private Float area;//建筑面积
    private Integer room;//房
    private Integer hall;//房
    private Integer bathroom;//卫
    private Integer kitchen;//厨房
    private Integer houseType;//房产证类型 (0-未满两年 1-满两年 2-满五年)
    private List<Long> tagIds;//房源特色	[1,2]
    private Integer priceType;//房价类型	（0-实际到手 1-税费各付）
    private BigDecimal totalPrice;//房价

    /**
     * 登录人id
     */
    private Long realtorId; // 经纪人id

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
    }

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
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

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }
}
