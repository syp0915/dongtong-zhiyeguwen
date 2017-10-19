package com.shfc.base.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 二手房海报内容DTO
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-02 09:33
 **/
public class HousePosterDTO implements Serializable {


    private Long Id;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 二手房图片
     */
    private String housePictureUrl;

    private String posterTopic;

    /**
     * 百度经度
     */
    private String longitude;

    /**
     * 百度纬度
     */
    private String latitude;

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
     * 所在楼层
     * ：1：低、2：中、3：高
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 面积
     */
    private Float area;

    /**
     * 单价，万元
     */
    private BigDecimal price;

    /**
     * 标签集合，用“，”隔开
     */
    private String tags;

    private String houseDetail;


    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getHousePictureUrl() {
        return housePictureUrl;
    }

    public void setHousePictureUrl(String housePictureUrl) {
        this.housePictureUrl = housePictureUrl;
    }

    public String getPosterTopic() {
        return posterTopic;
    }

    public void setPosterTopic(String posterTopic) {
        this.posterTopic = posterTopic;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}