package com.shfc.building.service;

import com.shfc.building.dto.HouseTypeListRespDTO;
import com.shfc.building.dto.SameAreaBuildingListRespDTO;
import com.shfc.common.result.ResultDO;

/**
 * @author sunyaping
 * @Package com.shfc.building.service
 * @Description：楼盘详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-13 15:35
 * version V1.0.0
 **/
public interface BuildingDetailService {

    /**
     * 根据楼盘Id查询对应户型列表
     * @param buildingId
     * @return
     */
    ResultDO<HouseTypeListRespDTO> getHouseTypeList(Long buildingId);


    /**
     * 根据楼盘Id查询同区域楼盘列表
     * @param buildingId
     * @return
     */
    ResultDO<SameAreaBuildingListRespDTO> getSameAreaBuildingList(Long buildingId);
}
