package com.shfc.building.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.building.dto
 * @Description :户型DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-13 15:49
 * version V1.0.0
 **/
public class HouseTypeDTO implements Serializable {

    /**
     * 户型名称
     */
    private String houseTypeName;

    /**
     * 楼盘id
     */
    private Long buildingId;

    /**
     * 是否是主推房型0-是 1-不是
     */
    private Integer isMain;

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
     * 建筑面积
     */
    private Float area;

    /**
     * 图片地址
     */
    private String coverPiclUrl;

    /**
     * 参数Id
     */
    private String paramId;

    /**
     * 标签列表
     */
    private List<BaseParameterDTO> paramList;

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getCoverPiclUrl() {
        return coverPiclUrl;
    }

    public void setCoverPiclUrl(String coverPiclUrl) {
        this.coverPiclUrl = coverPiclUrl;
    }

    public List<BaseParameterDTO> getParamList() {
        return paramList;
    }

    public void setParamList(List<BaseParameterDTO> paramList) {
        this.paramList = paramList;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }
}
