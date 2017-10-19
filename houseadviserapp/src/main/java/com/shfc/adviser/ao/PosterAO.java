package com.shfc.adviser.ao;

import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.base.dto.TemplateDTO;
import com.shfc.base.service.TemplateService;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.service.BuildingService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 海报AO
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-03 09:23
 **/
@Service
public class PosterAO {
    @Autowired
    private TemplateService templateService;
//    @Autowired
//    private RealtorService realtorService;

    @Autowired
    private BuildingService buildingService;


    public ResultDO<List<TemplateDTO>> templateList(Integer type){
        ResultDO<List<TemplateDTO>> resultDO=new ResultDO<>();
        if(type==null){
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }


        return templateService.templateList(type);
    }

    public ResultDO<Long> addHousePoster(HousePosterDTO housePosterDTO){
        ResultDO<Long> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(housePosterDTO.getPlotName())){
            resultDO.setErrMsg("小区名称不能为空");
            return resultDO;
        }
//        if(ValidateHelper.isEmpty(housePosterDTO.getLongitude())){
//            resultDO.setErrMsg("经度不能为空");
//            return resultDO;
//        }
//        if(ValidateHelper.isEmpty(housePosterDTO.getLatitude())){
//            resultDO.setErrMsg("纬度不能为空");
//            return resultDO;
//        }

        return templateService.addHousePoster(housePosterDTO);
    }

//    public  ResultDO<TempLateDetailDTO> describeHousePoster(Long templateId, Long houseId){
//        ResultDO<TempLateDetailDTO> resultDO=new ResultDO<>();
//        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
//        if(realtorId==null){
//            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
//            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
//            return resultDO;
//        }
//        RealtorInfoDTO realtorInfoDTO=realtorService.showCompleteInfo(realtorId);
//
//        String phone=realtorInfoDTO.getTelphone();
//        String comName=realtorInfoDTO.getComName();
//        String storeName=realtorInfoDTO.getStoreName();
//        if(templateId==null){
//            resultDO.setErrMsg("模板不能为空");
//            return resultDO;
//        }
//        if(houseId==null){
//            resultDO.setErrMsg("房源不能为空");
//            return resultDO;
//        }
//        return templateService.describeHousePoster(templateId,houseId);
//    }

    public ResultDO<Long> addBuildingPoster(BuildingPosterDTO buildingPosterDTO){
        ResultDO<Long> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getBuildingName())){
            resultDO.setErrMsg("楼盘名称不能为空");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getBuildingAddress())||ValidateHelper.isEmpty(buildingPosterDTO.getLongitude())||
                ValidateHelper.isEmpty(buildingPosterDTO.getLatitude())){
            resultDO.setErrMsg("楼盘地址信息不能为空");
            return resultDO;
        }

        return templateService.addBuildingPoster(buildingPosterDTO);
    }


//    public ResultDO<TempLateDetailDTO> describeBuildingPoster(Long templateId, Long buildingId){
//        ResultDO<TempLateDetailDTO> resultDO=new ResultDO<>();
//        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
//        if(realtorId==null){
//            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
//            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
//            return resultDO;
//        }
//        if(templateId==null){
//            resultDO.setErrMsg("模板不存在");
//            return resultDO;
//        }
//        if(buildingId==null){
//            resultDO.setErrMsg("楼盘不存在");
//            return resultDO;
//        }
//
//        return templateService.describeBuildingPoster(templateId,buildingId);
//    }

    public ResultDO<BuildingDTO> queryBuildingPoster(Long buildingId) {
        ResultDO<BuildingDTO>  resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        return buildingService.queryBuildingPoster(buildingId);
    }

}
