package com.shfc.building.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.building.JunitBaseTest;
import com.shfc.building.dto.HouseTypeListRespDTO;
import com.shfc.building.dto.SameAreaBuildingListRespDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunyaping
 * @Package com.shfc.building.service
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-14 13:59
 * version V1.0.0
 **/
public class BuildingDetailTest  extends JunitBaseTest {

    @Autowired
    private BuildingDetailService buildingDetailService;

    @Test
    public void testSameAreaBuildingList(){
        ResultDO<SameAreaBuildingListRespDTO> resultDO= buildingDetailService.getSameAreaBuildingList(4L);
        System.out.println("----------------------->"+ JSONObject.toJSON(resultDO.getData()));
    }

    @Test
    public void testHouseTypeList(){
        ResultDO<HouseTypeListRespDTO> resultDO= buildingDetailService.getHouseTypeList(1L);
        System.out.println("----------------------->"+ JSONObject.toJSON(resultDO.getData()));
    }
}
