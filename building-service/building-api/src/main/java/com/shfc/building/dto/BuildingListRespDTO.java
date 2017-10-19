package com.shfc.building.dto;

import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/12 下午8:14.
 */
public class BuildingListRespDTO extends BasePageDTO {

    private List<BuildingListBeanDTO> buildingList;

    public List<BuildingListBeanDTO> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingListBeanDTO> buildingList) {
        this.buildingList = buildingList;
    }
}
