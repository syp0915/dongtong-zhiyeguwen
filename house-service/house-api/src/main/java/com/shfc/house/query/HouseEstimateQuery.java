package com.shfc.house.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.HouseEstimateQuery
 * @Description: 房源估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:24
 * version V1.0.0
 */
public class HouseEstimateQuery implements Serializable{
    private static final long serialVersionUID = -4268706502118309831L;

    private Long plotId;//小区Id

    private Integer serveType;//物业类型  Y -1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅 8：叠加别墅 14：新里洋房

    private String unitNo;//楼号

    private String roomNo;//门牌号

    private Float area;//建筑面积

    private Integer room;//房

    private Integer hall;//厅

    private Integer bathroom;//卫

    private Integer kitchen;//厨房

    private Integer floor;//所在楼层

    private Integer totalFloor;//总楼层

    /**
     * 登录人id
     */
    private Long realtorId; // 经纪人id--登录则有

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public Integer getServeType() {
        return serveType;
    }

    public void setServeType(Integer serveType) {
        this.serveType = serveType;
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

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }
}
