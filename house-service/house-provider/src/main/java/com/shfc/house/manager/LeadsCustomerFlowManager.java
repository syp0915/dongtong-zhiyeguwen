package com.shfc.house.manager;

import com.shfc.house.dao.LeadsAddedServicesMapper;
import com.shfc.house.dao.LeadsCustomerFlowMapper;
import com.shfc.house.domain.LeadsCustomerFlow;
import com.shfc.house.dto.CustomerDetailDTO;
import com.shfc.house.dto.CustomerFlowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.manager
 * @Description :报备客户状态流管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 16:08
 * version V1.0.0
 **/
@Service
public class LeadsCustomerFlowManager {


    @Autowired
    private LeadsCustomerFlowMapper leadsCustomerFlowMapper;

    /**
     * 根据报备Id查询状态流信息
     * @param reportId
     * @return
     */
    public List<CustomerFlowDTO> queryStatusList(Long reportId){
        return leadsCustomerFlowMapper.queryStatusList(reportId);
    }

    /**
     * 添加纪录
     * @param leadsCustomerFlow
     * @return
     */
    public int addRecord(LeadsCustomerFlow leadsCustomerFlow){
        return leadsCustomerFlowMapper.insert(leadsCustomerFlow);
    }
}
