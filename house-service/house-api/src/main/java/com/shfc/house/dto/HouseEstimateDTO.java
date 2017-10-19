package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Package com.shfc.house.dto.HouseEstimateDTO
 * @Description: 估价DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:37
 * version V1.0.0
 */
public class HouseEstimateDTO implements Serializable {
    private static final long serialVersionUID = -7826168757112996907L;

    private Long plotId;//小区Id

    private String plotName;//小区名称

    private String unitNo;//楼号

    private String roomNo;//门牌号

    private Float area;//建筑面积

    private Integer room;//房

    private Integer hall;//厅

    private Integer bathroom;//卫

    private Integer kitchen;//厨房

    private Integer floor;//所在楼层

    private Integer totalFloor;//总楼层

    private BigDecimal price;//估算单价

    private BigDecimal totalPrice;//估算总价

    private List<PlotPriceDTO> priceList; // 小区价格列表

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PlotPriceDTO> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PlotPriceDTO> priceList) {
        this.priceList = priceList;
    }
}
