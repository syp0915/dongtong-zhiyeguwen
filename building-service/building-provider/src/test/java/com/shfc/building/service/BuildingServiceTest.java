package com.shfc.building.service;

import com.alibaba.fastjson.JSON;
import com.shfc.building.JunitBaseTest;
import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.dto.BuildingListRespDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *新房service测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 10:17
 **/
public class BuildingServiceTest extends JunitBaseTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    public void testRecommendBuilding(){
        ResultDO<BuildingListRespDTO> respDTOResultDO=buildingService.recommendBuilding(3,"","");
        System.out.println(JSON.toJSONString(respDTOResultDO));
    }

    @Test
    public void testBuildingBasicDetail(){
        ResultDO<BuildingBasicDetailDTO> respDTOResultDO=buildingService.buildingBasicDetail(2L,42L);
        System.out.println(JSON.toJSONString(respDTOResultDO));
    }

    @Test
    public void testGetBuildingList(){
        ResultDO<BuildingListRespDTO> resultDO = buildingService.getBuildingList(null, null, null, null, null, null, null, 10, 1);
        System.out.println("result----------------->" + JSON.toJSONString(resultDO));
    }

    @Test
    public void testGetAttentionBuildingList(){
        ResultDO<BuildingListRespDTO> resultDO = buildingService.getBuildingAttentionList(1L, 10, 1);
        System.out.println("result----------------->" + JSON.toJSONString(resultDO));
    }

  //  @Test
//    public void testBuildingPoster() {
//        BuildingDTO buildingDTO=new BuildingDTO();
////        buildingDTO.setBuildingName("12333");
////        buildingDTO.setBuildingAddress("0909000");
////        buildingDTO.setSaleModel("1室-5室");
//        ResultDO<PosterDTO> resultDO = buildingService.buildingPoster(1L, 1L,buildingDTO);
//        System.out.println(JSON.toJSONString(resultDO));
//    }

    @Test
    public void testQueryBuildingPoster() {
        ResultDO<BuildingDTO> resultDO = buildingService.queryBuildingPoster(39L);
        System.out.println(JSON.toJSONString(resultDO));
    }


}
