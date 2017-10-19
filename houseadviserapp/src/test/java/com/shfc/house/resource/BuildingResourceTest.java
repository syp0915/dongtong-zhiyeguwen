package com.shfc.house.resource;

import com.alibaba.fastjson.JSON;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.house.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/14 下午2:17.
 */
public class BuildingResourceTest extends JunitBaseMockMvcTest{

    @Test
    public void testGetBuildingList(){
        BuildingListQuery query = new BuildingListQuery();
        query.setPageSize(10);
        query.setPageNumber(1);

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/houseadviserapp/api/building/list/" + VERSION)
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .param("reqStr", JSON.toJSONString(query)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRecommendBuilding() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/building/recommend/"+VERSION)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .param("reqStr",JSON.toJSONString("{}")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
