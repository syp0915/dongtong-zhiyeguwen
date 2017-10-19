package com.shfc.adviser.ao;

import com.shfc.building.dto.HouseTypeListRespDTO;
import com.shfc.building.dto.SameAreaBuildingListRespDTO;
import com.shfc.building.service.BuildingDetailService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyaping
 * @Package com.shfc.adviser.ao
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-14 15:33
 * version V1.0.0
 **/
@Service
public class BuildingDetailAO {

    @Autowired
    private BuildingDetailService buildingDetailService;

    /**
     * 根据楼盘Id查询对应户型列表
     * @param buildingId
     * @return
     */
    public ResultDO<HouseTypeListRespDTO> getHouseTypeList(Long buildingId){
        ResultDO<HouseTypeListRespDTO> resultDO=new ResultDO<>();
        if (ValidateHelper.isEmpty(buildingId)){
            resultDO.setErrMsg("楼盘Id不能为空");
            return resultDO;
        }
        return  buildingDetailService.getHouseTypeList(buildingId);
    }


    /**
     * 根据楼盘Id查询同区域楼盘列表
     * @param buildingId
     * @return
     */
    public ResultDO<SameAreaBuildingListRespDTO> getSameAreaBuildingList(Long buildingId){
        ResultDO<SameAreaBuildingListRespDTO> resultDO=new ResultDO<>();
        if (ValidateHelper.isEmpty(buildingId)){
            resultDO.setErrMsg("楼盘Id不能为空");
            return resultDO;
        }
        return  buildingDetailService.getSameAreaBuildingList(buildingId);
    }

}
