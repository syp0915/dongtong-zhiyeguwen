package com.shfc.building.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.building.dto
 * @Description :户型列表DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-13 15:37
 * version V1.0.0
 **/
public class HouseTypeListRespDTO implements Serializable {

    /**
     * 户型列表
     */
    private List<HouseTypeDTO> houseTypeList;

    /**
     * 户型总数
     */
    private Integer houseTypeCount;

    public List<HouseTypeDTO> getHouseTypeList() {
        return houseTypeList;
    }

    public void setHouseTypeList(List<HouseTypeDTO> houseTypeList) {
        this.houseTypeList = houseTypeList;
    }

    public Integer getHouseTypeCount() {
        return houseTypeCount;
    }

    public void setHouseTypeCount(Integer houseTypeCount) {
        this.houseTypeCount = houseTypeCount;
    }
}
