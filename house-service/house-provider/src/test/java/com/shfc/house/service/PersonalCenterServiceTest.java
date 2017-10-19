package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.*;
import com.shfc.house.query.CommissionQuery;
import kafka.utils.Json;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunyaping
 * @Package com.shfc.house.service
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 16:48
 * version V3.1
 **/
public class PersonalCenterServiceTest extends JunitBaseTest {

    @Autowired
    private PersonalCenterService personalCenterService;

    @Test
    public void commissionStatistics(){
        CommissionQuery commissionQuery=new CommissionQuery();
        commissionQuery.setReferrerId(11L);
        ResultDO<CommissionRespDTO> resultDO=personalCenterService.commissionStatistics(commissionQuery);
        System.out.println("result--------------------------->"+ JSON.toJSON(resultDO.getData()));
    }

    @Test
    public void getSettlementDetailList(){
        CommissionQuery commissionQuery=new CommissionQuery();
        commissionQuery.setReferrerId(11L);
        commissionQuery.setPageNumber(1);
        commissionQuery.setPageSize(10);
        ResultDO<SettlementDetailRespDTO> resultDO=personalCenterService.getSettlementDetailList(commissionQuery);
        System.out.println("result--------------------------->"+ JSON.toJSON(resultDO.getData()));
    }

    @Test
    public void applyForSettlement(){
        ResultDO<ApplySettlementDTO> resultDO= personalCenterService.applyForSettlement("20170714994694",10L);
        System.out.println("result--------------------------->"+ JSON.toJSON(resultDO.getData()));
    }

    @Test
    public void getReportList(){
        CommissionQuery commissionQuery=new CommissionQuery();
        commissionQuery.setReferrerId(11L);
        commissionQuery.setPageNumber(1);
        commissionQuery.setPageSize(10);
        ResultDO<ReportListRespDTO> resultDO= personalCenterService.getReportList(commissionQuery);
        System.out.println("result--------------------------->"+ JSON.toJSON(resultDO.getData()));
    }

    @Test
    public void getCustomerDetail(){
        ResultDO<CustomerDetailDTO> resultDO= personalCenterService.getCustomerDetail(1L);
        System.out.println("result--------------------------->"+ JSON.toJSON(resultDO.getData()));
    }




}
