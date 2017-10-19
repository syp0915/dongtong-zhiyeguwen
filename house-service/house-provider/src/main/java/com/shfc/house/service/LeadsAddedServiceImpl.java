package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.LeadsCustomerDTO;
import com.shfc.house.dto.ServiceDTO;
import com.shfc.house.manager.LeadsAddedManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 增值服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 09:29
 **/
@Service
public class LeadsAddedServiceImpl implements LeadsAddedService {

    @Autowired
    private LeadsAddedManager leadsAddedManager;


    @Override
    public ResultDO<ServiceDTO> serviceDetail(Long serviceId) {
        ResultDO<ServiceDTO> resultDO=new ResultDO<>();
        if (serviceId==null){
            resultDO.setErrMsg("服务Id不能为空");
            return resultDO;
        }

        ServiceDTO serviceDTO=leadsAddedManager.serviceDetail(serviceId);

        resultDO.setData(serviceDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<String> addCustomer(LeadsCustomerDTO dto) {
        ResultDO<String> resultDO=new ResultDO<>();

        //同一个经纪人下,同一个客户同一个服务只能报备一次
        Boolean result=leadsAddedManager.isReport(dto.getServiceId(),dto.getReferrerId(),dto.getCustomerPhone());
        if(result){
            resultDO.setErrMsg("同一个客户在一个经纪人下只能报备一次该服务");
            return resultDO;
        }



        leadsAddedManager.addCustomer(dto);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
