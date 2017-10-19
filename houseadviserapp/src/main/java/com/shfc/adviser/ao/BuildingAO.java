package com.shfc.adviser.ao;

import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingListRespDTO;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.building.query.OperateAttentionBuildingListQuery;
import com.shfc.building.query.RealtorAttentionBuildingListQuery;
import com.shfc.building.service.BuildingService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.service.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/14 上午11:04.
 */
@Service
public class BuildingAO {

    @Autowired(required = false)
    private BuildingService buildingService;

    @Autowired(required = false)
    private RealtorService realtorService;

    public ResultDO<BuildingListRespDTO> getBuildingList(BuildingListQuery query){
        ResultDO<BuildingListRespDTO> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(query.getPageNumber()) || ValidateHelper.isEmpty(query.getPageSize())){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        return buildingService.getBuildingList(query.getKeyword(), query.getDistrictId(), query.getBlockId(), query.getMaxPrice(), query.getMinPrice(), query.getRoomCount(), query.getOwnerType(), query.getPageSize(), query.getPageNumber());
    }

    public ResultDO<BuildingListRespDTO> getRealtorAttendBuildingList(RealtorAttentionBuildingListQuery query){
        ResultDO<BuildingListRespDTO> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(query.getPageNumber()) || ValidateHelper.isEmpty(query.getPageSize())){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if (ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        return buildingService.getBuildingAttentionList(realtorId, query.getPageSize(), query.getPageNumber());
    }

    public ResultDO<BuildingListRespDTO> recommendBuilding(String longitude,String latitude){
        return buildingService.recommendBuilding(3,longitude,latitude);
    }

    public ResultDO<BuildingBasicDetailDTO> buildingBasicDetail(Long buildingId){
        ResultDO<BuildingBasicDetailDTO> resultDO=new ResultDO<>();

        if(buildingId==null){
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }

        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }

        return buildingService.buildingBasicDetail(realtorId,buildingId);
    }


    public ResultDO operateBuildingAttention(OperateAttentionBuildingListQuery query) {
        ResultDO resultDO = new ResultDO();
        Long buildingId = query.getBuildingId();
        Integer oprType = query.getOprType();
        if (ValidateHelper.isEmpty(buildingId) || ValidateHelper.isEmpty(oprType)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if (ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if (oprType != 0 && oprType != 1){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.ERROR_OPR_TYPE.getCode());
            resultDO.setErrMsg(ErrorConstant.ERROR_OPR_TYPE.getMsg());
            return resultDO;
        }
        ResultDO<RealtorUnitiveAccount> realtorInfoResultDO = realtorService.getRealtorInfoById(realtorId);
        if (!realtorInfoResultDO.isSuccess()){
            resultDO.setSuccess(false);
            resultDO.setErrCode(realtorInfoResultDO.getErrCode());
            resultDO.setErrMsg(realtorInfoResultDO.getErrMsg());
            return resultDO;
        }
        return buildingService.operateBuildingAttention(realtorId, buildingId, oprType);
    }
}
