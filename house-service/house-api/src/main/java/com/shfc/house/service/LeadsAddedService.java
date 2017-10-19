package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.LeadsCustomerDTO;
import com.shfc.house.dto.ServiceDTO;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 增值服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 09:27
 **/
public interface LeadsAddedService {

    /**
     * 增值服务-服务详情
     * @param serviceId
     * @return
     */
    ResultDO<ServiceDTO> serviceDetail(Long serviceId);


    /**
     * 增值服务-报备客户
     * @param dto
     * @return
     */
    ResultDO<String> addCustomer(LeadsCustomerDTO dto);
}
