package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateFormatUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.constant.ErrorConstant;
import com.shfc.house.domain.LeadsCommission;
import com.shfc.house.domain.LeadsCustomerFlow;
import com.shfc.house.dto.*;
import com.shfc.house.enums.LeadCustomerStatus;
import com.shfc.house.enums.LeadsCommissionStatus;
import com.shfc.house.manager.LeadsCommissionManager;
import com.shfc.house.manager.LeadsCustomerFlowManager;
import com.shfc.house.manager.LeadsCustomerManager;
import com.shfc.house.query.CommissionQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.service
 * @Description:个人中心（我的佣金/我的报备）
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 11:17
 * version V1.0.0
 **/
@Service
public class PersonalCenterServiceImpl implements PersonalCenterService{

    @Autowired
    private LeadsCommissionManager leadsCommissionManager;

    @Autowired
    private LeadsCustomerManager leadsCustomerManager;

    @Autowired
    private LeadsCustomerFlowManager leadsCustomerFlowManager;


    @Override
    public ResultDO<CommissionRespDTO> commissionStatistics(CommissionQuery commissionrQuery) {
        ResultDO<CommissionRespDTO> resultDO = new ResultDO<>();
        if(ValidateHelper.isEmpty(commissionrQuery)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        List<CommissionDTO> commissionDTOList = leadsCommissionManager.queryCommissionGroupByStatus(commissionrQuery.getReferrerId());
        CommissionRespDTO commissionRespDTO = new CommissionRespDTO();
        BigDecimal totalCommission=new BigDecimal("0.00");         //总佣金
        BigDecimal settlementCommission=new BigDecimal("0.00");    //待结算佣金
        BigDecimal commissionInSettlement=new BigDecimal("0.00");  //结算中佣金
        BigDecimal settledCommission=new BigDecimal("0.00");       //已结算佣金
        if (!commissionDTOList.isEmpty()){
            for(int i=0;i<commissionDTOList.size();i++){
                CommissionDTO commissionDTO=commissionDTOList.get(i);
                if(commissionDTO.getCommission()!=null){
                    totalCommission=totalCommission.add(commissionDTO.getCommission());
                }
                if(commissionDTO.getStatus()!=null){
                    //待结算-未申请
                    if(commissionDTO.getStatus()== LeadsCommissionStatus.SETTLEMENT_COMMISSION.getValue()){
                        settlementCommission=settlementCommission.add(commissionDTO.getCommission());
                    }
                    //待结算-已申请即结算中
                    if(commissionDTO.getStatus()== LeadsCommissionStatus.COMMISSION_IN_SETTLEMENT.getValue()){
                        commissionInSettlement=commissionInSettlement.add(commissionDTO.getCommission());
                    }
                    //已结算
                    if(commissionDTO.getStatus()== LeadsCommissionStatus.SETTLED_COMMISSION.getValue()){
                        settledCommission=settledCommission.add(commissionDTO.getCommission());
                    }
                }
            }
            commissionRespDTO.setTotalCommission(totalCommission);
            commissionRespDTO.setSettlementCommission(settlementCommission);
            commissionRespDTO.setCommissionInSettlement(commissionInSettlement);
            commissionRespDTO.setSettledCommission(settledCommission);
        }
        resultDO.setSuccess(true);
        resultDO.setData(commissionRespDTO);
        return resultDO;
    }

    @Override
    public ResultDO<SettlementDetailRespDTO> getSettlementDetailList(CommissionQuery commissionrQuery) {
        ResultDO<SettlementDetailRespDTO> resultDO=new ResultDO<>();
        if(ValidateHelper.isEmpty(commissionrQuery)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        SettlementDetailRespDTO settlementDetailRespDTO=new SettlementDetailRespDTO();
        Page<SettlementDetailDTO> page = new Page<>(commissionrQuery.getPageNumber(), commissionrQuery.getPageSize());
        page.setQuery(commissionrQuery);
        Page<SettlementDetailDTO> settlementDetailDTOPage=leadsCommissionManager.querySettlementDetail(page);
        if(settlementDetailDTOPage.getTotalSize()>0){
            settlementDetailRespDTO.setSettlementDetailList(settlementDetailDTOPage.getData());
            settlementDetailRespDTO.setTotalCount(settlementDetailDTOPage.getTotalSize());
            settlementDetailRespDTO.setPageNumber(settlementDetailDTOPage.getPageNumber());
            settlementDetailRespDTO.setPageSize(settlementDetailDTOPage.getPageSize());
        }
        resultDO.setSuccess(true);
        resultDO.setData(settlementDetailRespDTO);
        return resultDO;
    }

    @Override
    public ResultDO<ApplySettlementDTO> applyForSettlement(String orderNumber,Long realtorId) {
        ResultDO<ApplySettlementDTO> resultDO=new ResultDO<>();
        if(ValidateHelper.isEmptyString(orderNumber)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        ApplySettlementDTO applySettlementDTO=new ApplySettlementDTO();
        LeadsCommission leadsCommission=new LeadsCommission();
        leadsCommission.setNumber(orderNumber);
        leadsCommission.setStatus(LeadsCommissionStatus.COMMISSION_IN_SETTLEMENT.getValue());
        LeadsCommission leadsCom=leadsCommissionManager.queryInfoByOrder(orderNumber);
        if(leadsCom==null){
            resultDO.setErrMsg("订单编号不存在");
            return resultDO;
        }
        int result=leadsCommissionManager.updateStatusByOrderNumber(leadsCommission);
        if(result<1){
            applySettlementDTO.setResult(false);
            applySettlementDTO.setStatus(LeadsCommissionStatus.SETTLEMENT_COMMISSION.getValue());
            resultDO.setData(applySettlementDTO);
            return resultDO;
        }
        LeadsCustomerFlow leadsCustomerFlow=new LeadsCustomerFlow();
        leadsCustomerFlow.setLeadsCustomerId(leadsCom.getLeadsCustomerId());
        leadsCustomerFlow.setStatus(LeadCustomerStatus.CAN_SETTLEMENT.getValue());
        leadsCustomerFlow.setCreator(realtorId);
        leadsCustomerFlow.setCreateTime(new Date());
        leadsCustomerFlow.setModifyTime(new Date());
        int record=leadsCustomerFlowManager.addRecord(leadsCustomerFlow);
        Logger.info(PersonalCenterServiceImpl.class,"状态流添加结果："+record+",请求参数："
                + JSON.toJSON(leadsCustomerFlow));
        applySettlementDTO.setResult(true);
        applySettlementDTO.setStatus(LeadsCommissionStatus.COMMISSION_IN_SETTLEMENT.getValue());
        resultDO.setSuccess(true);
        resultDO.setData(applySettlementDTO);
        return resultDO;
    }

    @Override
    public ResultDO<ReportListRespDTO> getReportList(CommissionQuery commissionrQuery) {
        ResultDO<ReportListRespDTO> resultDO=new ResultDO<>();
        if(ValidateHelper.isEmpty(commissionrQuery)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        ReportListRespDTO reportListRespDTO=new ReportListRespDTO();
        Page<ReportDetailDTO> page = new Page<>(commissionrQuery.getPageNumber(), commissionrQuery.getPageSize());
        page.setQuery(commissionrQuery);
        Page<ReportDetailDTO> reportDetailDTOPage=leadsCustomerManager.queryRepostList(page);
        if(reportDetailDTOPage.getTotalSize()>0){
            reportListRespDTO.setReportDetailList(reportDetailDTOPage.getData());
            reportListRespDTO.setPageNumber(reportDetailDTOPage.getPageNumber());
            reportListRespDTO.setPageSize(reportDetailDTOPage.getPageSize());
            reportListRespDTO.setTotalCount(reportDetailDTOPage.getTotalSize());
        }
        resultDO.setSuccess(true);
        resultDO.setData(reportListRespDTO);
        return resultDO;
    }

    @Override
    public ResultDO<CustomerDetailDTO> getCustomerDetail(Long reportId) {
        ResultDO<CustomerDetailDTO> resultDO=new ResultDO<>();
        if(ValidateHelper.isEmpty(reportId)){
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            return resultDO;
        }
        int count=leadsCustomerManager.queryReportIsExist(reportId);
        if (count<1){
            resultDO.setErrMsg("报备客户Id不存在");
            return resultDO;
        }
        CustomerDetailDTO customerDetailDTO=leadsCustomerManager.queryCustomerDetail(reportId);
        List<CustomerFlowDTO> customerDetailDTOList=leadsCustomerFlowManager.queryStatusList(reportId);
        customerDetailDTO.setCustomerFlowList(customerDetailDTOList);
        resultDO.setSuccess(true);
        resultDO.setData(customerDetailDTO);
        return resultDO;
    }
}
