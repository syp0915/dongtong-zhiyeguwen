package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description :二手房详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-22 13:51
 * version V1.0.0
 **/
public class RealtorHouseDetailDTO extends RealtorHouseInfoDTO implements Serializable {


    private static final long serialVersionUID = -4081796336193599130L;


    /**
     * 房源编号
     */
    private String houseCode;

    /**
     * 总价  保留两位小数 单位：万元
     */
    private BigDecimal totalPrice;

    /**
     * 小区地址
     */
    private String plotAddress;

    /**
     * 楼栋号
     */
    private String unitNo;

    /**
     * 室号
     */
    private String 	houseNo;

    /**
     * 朝向 1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北'
     */
    private Integer orientation;

    /**
     * 所在楼层
     */
    private Integer floor;

    /**
     * 面积   保留两位小数
     */
    private BigDecimal totalArea;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 标签集合
     */
    private List<BaseTagDTO> tags;

    /**
     * 委托协议链接集合
     */
    private List<String> entrustUrls;

    /**
     * 发布时间  细化到秒
     */
    private	String publishTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
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

    public BigDecimal getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public List<BaseTagDTO> getTags() {
        return tags;
    }

    public void setTags(List<BaseTagDTO> tags) {
        this.tags = tags;
    }

    public List<String> getEntrustUrls() {
        return entrustUrls;
    }

    public void setEntrustUrls(List<String> entrustUrls) {
        this.entrustUrls = entrustUrls;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
