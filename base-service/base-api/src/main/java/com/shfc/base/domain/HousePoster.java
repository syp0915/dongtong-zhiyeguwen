package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.base.domain.HousePoster.java
 * @Description: 二手房海报内容
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/02 10:11
 * version v1.0.0
 */
public class HousePoster extends BaseBean {
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
：1：低、2：中、3：高
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
     * 获取二手房图片
     *
     * @return house_picture_url
     */
    public String getHousePictureUrl() {
        return housePictureUrl;
    }

    /**
     * 设置二手房图片
     *
     * @param housePictureUrl
     */
    public void setHousePictureUrl(String housePictureUrl) {
        this.housePictureUrl = housePictureUrl == null ? null : housePictureUrl.trim();
    }

    /**
     * @return poster_topic
     */
    public String getPosterTopic() {
        return posterTopic;
    }

    /**
     * @param posterTopic
     */
    public void setPosterTopic(String posterTopic) {
        this.posterTopic = posterTopic == null ? null : posterTopic.trim();
    }

    /**
     * 获取百度经度
     *
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置百度经度
     *
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取百度纬度
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置百度纬度
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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
     * 获取所在楼层
：1：低、2：中、3：高
     *
     * @return floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 设置所在楼层
：1：低、2：中、3：高
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
     * 获取单价，万元
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价，万元
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取标签集合，用“，”隔开
     *
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签集合，用“，”隔开
     *
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * @return house_detail
     */
    public String getHouseDetail() {
        return houseDetail;
    }

    /**
     * @param houseDetail
     */
    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail == null ? null : houseDetail.trim();
    }
}