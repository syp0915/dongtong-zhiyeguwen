package com.shfc.building.manager;

import com.shfc.building.dao.BuildingHouseholdMapper;
import com.shfc.building.dao.BuildingMapper;
import com.shfc.building.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.building.manager
 * @Description :楼盘详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-14 10:03
 * version V1.0.0
 **/
@Service
public class BuildingDetailManage {

    @Autowired(required = false)
    private BuildingMapper buildingMapper;

    @Autowired(required = false)
    private BuildingHouseholdMapper buildingHouseholdMapper;
    /**
     * 根据楼盘Id查询户型列表
     * @param buildingId
     * @return
     */
    public HouseTypeListRespDTO getHouseTypeList(Long buildingId){
        HouseTypeListRespDTO houseTypeListRespDTO=new HouseTypeListRespDTO();
        List<HouseTypeDTO> houseTypeDTOS=buildingHouseholdMapper.queryHouseTypeList(buildingId);
        houseTypeListRespDTO.setHouseTypeList(houseTypeDTOS);
        houseTypeListRespDTO.setHouseTypeCount(houseTypeDTOS.size());
        return houseTypeListRespDTO;
    }

    /**
     * 根据楼盘Id查询同区域楼盘列表
     * @param buildingId
     * @return
     */
    public SameAreaBuildingListRespDTO getSameAreaBuildingList(Long buildingId){
        SameAreaBuildingListRespDTO sameAreaBuildingListRespDTO=new SameAreaBuildingListRespDTO();
        List<BuildingListBeanDTO> buildingListBeanDTOS= buildingMapper.querySameAreaBuildingByBuildingId(buildingId);
        sameAreaBuildingListRespDTO.setBuildingList(buildingListBeanDTOS);
        return sameAreaBuildingListRespDTO;
    }
}
