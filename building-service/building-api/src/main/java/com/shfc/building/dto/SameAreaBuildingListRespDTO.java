package com.shfc.building.dto;


import java.io.Serializable;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.building.dto
 * @Description :同区域楼盘列表
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-13 17:08
 * version V1.0.0
 **/
public class SameAreaBuildingListRespDTO implements Serializable{

    /**
     * 同区域楼盘列表
     */
    private List<BuildingListBeanDTO> buildingList;

    public List<BuildingListBeanDTO> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingListBeanDTO> buildingList) {
        this.buildingList = buildingList;
    }
}
