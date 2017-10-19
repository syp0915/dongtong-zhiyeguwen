package com.shfc.adviser.ao;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.query.CommissionQuery;
import com.shfc.house.service.PersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyaping
 * @Package com.shfc.adviser.ao
 * @Description :个人中心
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 17:39
 * version V1.0.0
 **/
@Service
public class PersonalCenterAO {

    @Autowired
    private PersonalCenterService personalCenterService;

    /**
     * 佣金计算
     * @return
     */
    public ResultDO<CommissionRespDTO> commissionStatistics(){
        ResultDO<CommissionRespDTO> resultDO=new ResultDO<>();
        CommissionQuery commissionQuery=new CommissionQuery();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        commissionQuery.setReferrerId(realtorId);
        return personalCenterService.commissionStatistics(commissionQuery);
    }

    /**
     * 查询结算明细列表
     * @param commissionQuery
     * @return
     */
    public ResultDO<SettlementDetailRespDTO> getSettlementDetailList(CommissionQuery commissionQuery){
        ResultDO<SettlementDetailRespDTO> resultDO=new ResultDO<>();
        if(commissionQuery==null){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(commissionQuery.getPageNumber()) ||
                ValidateHelper.isEmpty(commissionQuery.getPageSize())){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        Logger.info(PersonalCenterAO.class, JSON.toJSONString(commissionQuery));
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        commissionQuery.setReferrerId(realtorId);
        return personalCenterService.getSettlementDetailList(commissionQuery);
    }

    /**
     * 申请结算
     * @param orderNumber
     * @return
     */
    public ResultDO<ApplySettlementDTO> applyForSettlement(String orderNumber){
        ResultDO<ApplySettlementDTO> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(ValidateHelper.isEmptyString(orderNumber)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
       return personalCenterService.applyForSettlement(orderNumber,realtorId);
    }

    /**
     * 我的报备列表
     * @param commissionQuery
     * @return
     */
    public ResultDO<ReportListRespDTO> getReportList(CommissionQuery commissionQuery){
        ResultDO<ReportListRespDTO> resultDO=new ResultDO<>();
        if(commissionQuery==null){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(commissionQuery.getPageNumber()) ||
                ValidateHelper.isEmpty(commissionQuery.getPageSize())){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        Logger.info(PersonalCenterAO.class, JSON.toJSONString(commissionQuery));
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        commissionQuery.setReferrerId(realtorId);
        return personalCenterService.getReportList(commissionQuery);
    }

    /**
     * 根据报备Id查询客户详情
     * @param reportId
     * @return
     */
    public ResultDO<CustomerDetailDTO> getCustomerDetail(Long reportId){
        ResultDO<CustomerDetailDTO> resultDO=new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(reportId)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        return personalCenterService.getCustomerDetail(reportId);
    }

}
