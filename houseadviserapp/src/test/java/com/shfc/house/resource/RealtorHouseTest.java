package com.shfc.house.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.house.JunitBaseMockMvcTest;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.query.RealtorHouseQuery;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.resource
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-23 15:52
 * version V1.0.0
 **/
public class RealtorHouseTest extends JunitBaseMockMvcTest {

    @Test
    public void testQueryPublishHouseList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/realtorHouse/queryPublishHouseList/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString("")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testQueryDetail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/realtorHouse/queryDetail/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString("447")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }


    @Test
    public void testUpDownDel() throws Exception{
        RealtorHouseQuery query=new RealtorHouseQuery();
        query.setHouseId(447L);
        query.setType(0);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/realtorHouse/upDownDel/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString(query)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testAddRealtorHouse() throws Exception{
        RealtorHouseDTO realtorHouseDTO=new RealtorHouseDTO();
        realtorHouseDTO.setPlotId(1L);
        realtorHouseDTO.setImportPlotName("祥安竹苑");
        realtorHouseDTO.setAddress("祥安路36弄");
        realtorHouseDTO.setDistrictId(310115L);
        realtorHouseDTO.setBlockId(28L);
        realtorHouseDTO.setLongitude("121.821471");
        realtorHouseDTO.setLatitude("30.968626");
        realtorHouseDTO.setUnitNo("12号");
        realtorHouseDTO.setHouseNo("501");
        realtorHouseDTO.setRoom(3);
        realtorHouseDTO.setHall(1);
        realtorHouseDTO.setBathroom(1);
        realtorHouseDTO.setOrientation(1);
        realtorHouseDTO.setFloor(12);
        realtorHouseDTO.setTotalFloor(30);
        realtorHouseDTO.setArea(81.87F);
        realtorHouseDTO.setTotalPrice(new BigDecimal("400.00"));
        List<Long> tagIds=new ArrayList<>();
        tagIds.add(14L);
        tagIds.add(15L);
        realtorHouseDTO.setTags(tagIds);
        List<String> entrustProtocol=new ArrayList<>();
        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804building-show/2017/08/04/IMG_1501812918240_17274.png");
        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804buiding-show/2017/08/04/IMG_1501813049173_58237.png");
        realtorHouseDTO.setEntrustUrl(entrustProtocol);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/realtorHouse/addRealtorHouse/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString(realtorHouseDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }


    @Test
    public void testModifyRealtorHouse() throws Exception{
        RealtorHouseDTO realtorHouseDTO=new RealtorHouseDTO();
        realtorHouseDTO.setHouseId(448L);
        realtorHouseDTO.setImportPlotName("祥安竹苑111");
        // realtorHouseDTO.setPlotId(1L);
//        realtorHouseDTO.setAddress("祥安路36弄");
//        realtorHouseDTO.setDistrictId(310115L);
//        realtorHouseDTO.setBlockId(28L);
        realtorHouseDTO.setLongitude("121.821471");
        realtorHouseDTO.setLatitude("30.968626");
        realtorHouseDTO.setUnitNo("10");
//        realtorHouseDTO.setHouseNo("501");
//        realtorHouseDTO.setRoom(3);
//        realtorHouseDTO.setHall(1);
//        realtorHouseDTO.setBathroom(2);
//        realtorHouseDTO.setOrientation(1);
//        realtorHouseDTO.setFloor(12);
//        realtorHouseDTO.setTotalFloor(30);
//        realtorHouseDTO.setArea(81.87F);
        // realtorHouseDTO.setTotalPrice(new BigDecimal("380.00"));
//        List<Long> tagIds=new ArrayList<>();
//        tagIds.add(14L);
//        tagIds.add(15L);
//        realtorHouseDTO.setTags(tagIds);
//        List<String> entrustProtocol=new ArrayList<>();
//        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804building-show/2017/08/04/IMG_1501812918240_17274.png");
//        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804buiding-show/2017/08/04/IMG_1501813049173_58237.png");
//        realtorHouseDTO.setEntrustUrl(entrustProtocol);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/realtorHouse/modifyRealtorHouse/"+VERSION)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("reqStr", JSON.toJSONString(realtorHouseDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }



}
