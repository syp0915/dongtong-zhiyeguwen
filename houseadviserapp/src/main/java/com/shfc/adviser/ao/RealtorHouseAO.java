package com.shfc.adviser.ao;

import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.RealtorHouseQuery;
import com.shfc.house.service.RealtorHouseService;
import com.shfc.house.service.RealtorService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyaping
 * @Package com.shfc.adviser.ao
 * @Description ：经纪人二手房
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-23 15:21
 * version V1.0.0
 **/
@Service
public class RealtorHouseAO {

    @Autowired(required=false)
    private RealtorHouseService realtorHouseService;

    @Autowired(required=false)
    private RealtorService realtorService;


    public ResultDO<Long> addRealtorHouse(RealtorHouseDTO dto){
        ResultDO<Long> resultDO=new ResultDO<>();
        Long realtorId= HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请登录");
            return resultDO;
        }
        RealtorInfoDTO realtorInfoDTO = realtorService.showCompleteInfo(realtorId);
        if(ValidateHelper.isEmpty(realtorInfoDTO.getComId())||ValidateHelper.isEmpty(realtorInfoDTO.getStoreId())){
            resultDO.setErrMsg("请先完善经纪公司门店信息");
            return resultDO;
        }
        return realtorHouseService.addRealtorHouse(dto,realtorId);
    }


    public ResultDO<String> modifyRealtorHouse(RealtorHouseDTO dto){
        ResultDO<String> resultDO=new ResultDO<>();
        Long realtorId= HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请登录");
            return resultDO;
        }
        RealtorInfoDTO realtorInfoDTO = realtorService.showCompleteInfo(realtorId);
        if(ValidateHelper.isEmpty(realtorInfoDTO.getComId())||ValidateHelper.isEmpty(realtorInfoDTO.getStoreId())){
            resultDO.setErrMsg("请先完善经纪公司门店信息");
            return resultDO;
        }
        return realtorHouseService.modifyRealtorHouse(dto,realtorId);
    }

    /**
     * 获取我发布的二手房列表
     * @param query
     * @return
     */
    public ResultDO<Page<RealtorHouseInfoDTO>> getRealtorHouseList(BaseQuery query){
        ResultDO<Page<RealtorHouseInfoDTO>> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if (ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if (ValidateHelper.isEmpty(query.getPageNumber()) || ValidateHelper.isEmpty(query.getPageSize())){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
       return realtorHouseService.getRealtorHouseList(query,realtorId);
    }

    /**
     * 二手房详情
     * @param houseId
     * @return
     */
    public ResultDO<RealtorHouseDetailDTO> getRealtorHouseDetail(Long houseId){
        ResultDO<RealtorHouseDetailDTO> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if (ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if (ValidateHelper.isEmpty(houseId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
       return realtorHouseService.getRealtorHouseDetail(houseId,realtorId);
    }

    /***
     * 二手房上下架及删除操作
     * @param realtorHouseQuery
     * @return
     */
    public ResultDO<Boolean> upDownOrDel(RealtorHouseQuery realtorHouseQuery){
        ResultDO<Boolean> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if (ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.EXCEPTION_LOGIN_INFO.getCode());
            resultDO.setErrMsg(ErrorConstant.EXCEPTION_LOGIN_INFO.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(realtorHouseQuery)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(realtorHouseQuery.getHouseId()) ||
                ValidateHelper.isEmpty(realtorHouseQuery.getType())){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        realtorHouseQuery.setRealtorId(realtorId);
        return realtorHouseService.upDownOrDel(realtorHouseQuery);
    }
}
