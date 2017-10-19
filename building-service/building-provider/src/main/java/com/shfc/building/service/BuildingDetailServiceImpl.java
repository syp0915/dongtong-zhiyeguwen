package com.shfc.building.service;

import com.shfc.building.base.BaseServiceImpl;
import com.shfc.building.constants.ErrorConstant;
import com.shfc.building.dto.HouseTypeListRespDTO;
import com.shfc.building.dto.SameAreaBuildingListRespDTO;
import com.shfc.building.manager.BuildingDetailManage;
import com.shfc.building.manager.BuildingManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyaping
 * @Package com.shfc.building.service
 * @Description :楼盘详情实现类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-14 9:44
 * version V1.0.0
 **/
@Service
public class BuildingDetailServiceImpl extends BaseServiceImpl implements BuildingDetailService{

    @Autowired(required = false)
    private BuildingDetailManage buildingDetailManage;

    /**
     * 根据楼盘Id查询户型列表
     * @param buildingId
     * @return
     */
    @Override
    public ResultDO<HouseTypeListRespDTO> getHouseTypeList(Long buildingId) {
        ResultDO<HouseTypeListRespDTO> resultDO=new ResultDO<>();
        //必传参数校验
        if (ValidateHelper.isEmpty(buildingId)){
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        HouseTypeListRespDTO houseTypeListRespDTO= buildingDetailManage.getHouseTypeList(buildingId);
        resultDO.setData(houseTypeListRespDTO);
        resultDO.setSuccess(true);
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 根据楼盘Id查询同区域楼盘列表
     * @param buildingId
     * @return
     */
    @Override
    public ResultDO<SameAreaBuildingListRespDTO> getSameAreaBuildingList(Long buildingId) {
        ResultDO<SameAreaBuildingListRespDTO> resultDO=new ResultDO<>();
        //必传参数校验
        if (ValidateHelper.isEmpty(buildingId)){
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        SameAreaBuildingListRespDTO  sameAreaBuildingListRespDTO=buildingDetailManage.getSameAreaBuildingList(buildingId);
        resultDO.setData(sameAreaBuildingListRespDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
