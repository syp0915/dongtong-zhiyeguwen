package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.LeadsCustomerDTO;
import com.shfc.house.dto.ServiceDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 09:45
 **/

public class LeadsAddServiceTest extends JunitBaseTest {
    @Autowired
    private LeadsAddedService leadsAddedService;

    @Test
    public void testServiceDetail(){
        ResultDO<ServiceDTO> resultDO=leadsAddedService.serviceDetail(1L);
        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testAddCustomer(){
        LeadsCustomerDTO dto=new LeadsCustomerDTO();
        dto.setServiceId(1L);
        dto.setServiceName("增值服务1");
        dto.setCustomerName("小白");
        dto.setCustomerPhone("18260121981");
        dto.setGender(1);
        dto.setReferrerId(10L);
        dto.setReferrerName("中介");
        dto.setReferrerPhone("111111111");
        //dto.setComId(1L);
        ResultDO<String> resultDO=leadsAddedService.addCustomer(dto);
        System.out.println(JSON.toJSONString(resultDO));
    }
}
