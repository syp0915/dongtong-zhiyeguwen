package com.shfc.house.manager;

import com.shfc.house.dao.LeadsAddedServicesMapper;
import com.shfc.house.dao.LeadsCustomerMapper;
import com.shfc.house.dto.CustomerDetailDTO;
import com.shfc.house.dto.ReportDetailDTO;
import com.shfc.house.dto.SettlementDetailDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyaping
 * @Package com.shfc.house.manager
 * @Description ：报备客户管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 16:02
 * version V1.0.0
 **/
@Service
public class LeadsCustomerManager {

    @Autowired
    private LeadsCustomerMapper leadsCustomerMapper;


    /**
     * 根据推荐人Id查询报备客户列表
     * @param settlementDetailDTOPage
     * @return
     */
    public Page<ReportDetailDTO> queryRepostList(Page<ReportDetailDTO> settlementDetailDTOPage){
        leadsCustomerMapper.queryRepostList(settlementDetailDTOPage);
        return  settlementDetailDTOPage;
    }

    /**
     * 根据报备Id查询客户信息
     * @param reportId
     * @return
     */
    public CustomerDetailDTO queryCustomerDetail(Long reportId){
        return leadsCustomerMapper.queryCustomerDetail(reportId);
    }

    /**
     * 判断报备客户Id是否存在
     * @param reportId
     * @return
     */
    public int queryReportIsExist(Long reportId){
        return leadsCustomerMapper.queryReportIsExist(reportId);
    }



}
