package com.shfc.house.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.house.JunitBaseMockMvcTest;
import com.shfc.house.query.CommissionQuery;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author sunyaping
 * @Package com.shfc.house.resource
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-13 14:27
 * version V1.0.0
 **/
public class PersonalCenterTest extends JunitBaseMockMvcTest {

    @Test
    public void testCommissionStatistics() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personal/commissionStatistics/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString("")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testSettlementDetailList() throws Exception{
        CommissionQuery commissionQuery=new CommissionQuery();
        commissionQuery.setReferrerId(11L);
        commissionQuery.setPageSize(10);
        commissionQuery.setPageNumber(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personal/settlementDetailList/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString(commissionQuery)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testApplyForSettlement() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personal/applyForSettlement/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString("{orderNumber:11}")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testReportList() throws Exception{
        CommissionQuery commissionQuery=new CommissionQuery();
        commissionQuery.setReferrerId(11L);
        commissionQuery.setPageSize(10);
        commissionQuery.setPageNumber(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personal/reportList/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString(commissionQuery)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testCustomerDetail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personal/customerDetail/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString("{reportId:1}")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
