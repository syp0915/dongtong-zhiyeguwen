package com.shfc.house.manager;

import com.shfc.common.base.Logger;
import com.shfc.house.dao.LeadsAddedServicesMapper;
import com.shfc.house.dao.LeadsCustomerFlowMapper;
import com.shfc.house.dao.LeadsCustomerMapper;
import com.shfc.house.domain.LeadsCustomer;
import com.shfc.house.domain.LeadsCustomerFlow;
import com.shfc.house.dto.LeadsCustomerDTO;
import com.shfc.house.dto.ServiceDTO;
import com.shfc.house.enums.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 09:34
 **/
@Service
public class LeadsAddedManager {
    @Autowired
    private LeadsAddedServicesMapper leadsAddedServicesMapper;

    @Autowired
    private LeadsCustomerMapper leadsCustomerMapper;

    @Autowired
    private LeadsCustomerFlowMapper leadsCustomerFlowMapper;


    public ServiceDTO serviceDetail(Long serviceId){
        return leadsAddedServicesMapper.serviceDetail(serviceId);
    }

    public void addCustomer(LeadsCustomerDTO dto){
        LeadsCustomer leadsCustomer=new LeadsCustomer();
        leadsCustomer.setLeadsServicesId(dto.getServiceId());
        leadsCustomer.setPhone(dto.getCustomerPhone());
        leadsCustomer.setName(dto.getCustomerName());
        leadsCustomer.setGender(dto.getGender());
        leadsCustomer.setReferrerId(dto.getReferrerId());
        leadsCustomer.setReferrerName(dto.getReferrerName());
        leadsCustomer.setReferrerPhone(dto.getReferrerPhone());
        leadsCustomer.setStatus(CustomerStatus.SUCCESS.getValue());
        leadsCustomer.setMerchanismId(dto.getComId());
        leadsCustomer.setModifyTime(new Date());//php那边查询时需要
        try{
            leadsCustomerMapper.insert(leadsCustomer);

            //添加更进信息
            addFlow(leadsCustomer.getId());

        }catch ( Exception e ){
            Logger.info(LeadsAddedManager.class,e.toString());
        }
    }

    public void addFlow(Long customerId){
        LeadsCustomerFlow leadsCustomerFlow=new LeadsCustomerFlow();
        leadsCustomerFlow.setLeadsCustomerId(customerId);
        leadsCustomerFlow.setStatus(CustomerStatus.SUCCESS.getValue());
        try {
            leadsCustomerFlowMapper.insert(leadsCustomerFlow);
        }catch ( Exception e ){
            Logger.info(LeadsAddedManager.class,e.toString());
        }

    }

    public Boolean isReport(Long serviceId,Long referrerId,String customerPhone){
        int count=leadsCustomerMapper.isReport(referrerId,customerPhone,serviceId);
        if(count==0){
            return false;
        }
        return true;

    }
}
