package com.shfc.house.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.adviser.ao.BuildingDetailAO;
import com.shfc.building.dto.HouseTypeListRespDTO;
import com.shfc.building.dto.SameAreaBuildingListRespDTO;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseMockMvcTest;
import com.shfc.house.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2017-06-14 16:43
 * version V1.0.0
 **/
public class BuildingDetailTest extends JunitBaseMockMvcTest {

    @Autowired
    private BuildingDetailAO buildingDetailAO;

    @Test
    public void testGetBuildingList(){
        Long buildingId=1L;
       /* try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/buildingDetail/householdList/" + VERSION)
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .param("reqStr", JSON.toJSONString(buildingId)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ResultDO<HouseTypeListRespDTO> bResultDO= buildingDetailAO.getHouseTypeList(buildingId);
        System.out.println("result------------>"+JSON.toJSONString(bResultDO));
    }

    @Test
    public void testGetSameAreaBuildinglist(){
        Long buildingId=1L;
        /*try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/buildingDetail/sameAreaBuildinglist/" + VERSION)
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(JSON.toJSONString(buildingId)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ResultDO<SameAreaBuildingListRespDTO> resultDO=buildingDetailAO.getSameAreaBuildingList(buildingId);
        System.out.println("result------------>"+JSON.toJSONString(resultDO));
    }
}
