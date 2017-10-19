package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.query.CommissionQuery;

/**
 * @author sunyaping
 * @Package com.shfc.house.service
 * @Description：个人中心服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 17:18
 * version V1.0.0
 **/
public interface PersonalCenterService {

    /**
     * 我的佣金-佣金计算 (根据经纪人Id)
     * @param commissionrQuery
     * @return
     */
    ResultDO<CommissionRespDTO> commissionStatistics(CommissionQuery commissionrQuery);

    /**
     * 我的佣金-结算明细列表 (根据经纪人Id分页查询)
     * @param commissionrQuery
     * @return
     */
    ResultDO<SettlementDetailRespDTO> getSettlementDetailList(CommissionQuery commissionrQuery);

    /**
     * 我的佣金-申请结算 (根据订单编号)
     * @param orderNumber
     * @return
     */
    ResultDO<ApplySettlementDTO> applyForSettlement(String orderNumber,Long realtorId);

    /**
     * 我的报备-报备列表 (根据经纪人Id分页查询)
     * @param commissionrQuery
     * @return
     */
    ResultDO<ReportListRespDTO> getReportList(CommissionQuery commissionrQuery);

    /**
     * 我的报备-客户详情 (根据报备Id)
     * @param reportId
     * @return
     */
    ResultDO<CustomerDetailDTO> getCustomerDetail(Long reportId);

}
