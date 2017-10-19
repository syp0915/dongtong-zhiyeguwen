package com.shfc.base.service;

import com.alibaba.fastjson.JSON;
import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.base.dto.TemplateDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-01 17:29
 **/
public class TemplateServiceTest extends JunitBaseTest {

    @Autowired
    private TemplateService templateService;

    @Test
    public void testTemplateList(){
        ResultDO<List<TemplateDTO>> resultDO=templateService.templateList(1);
        System.out.println(JSON.toJSONString(resultDO));

    }
    @Test
    public void addHousePoster(){
        HousePosterDTO housePosterDTO=new HousePosterDTO();
        //housePosterDTO.setId(4L);
        housePosterDTO.setPlotName("场中路755弄");
//        housePosterDTO.setLatitude("121.821471");
//        housePosterDTO.setLongitude("30.968626");
        housePosterDTO.setHousePictureUrl("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804building-show/2017/08/04/IMG_1501812918240_17274.png");
        housePosterDTO.setHall(1);
        housePosterDTO.setRoom(3);
        housePosterDTO.setBathroom(1);
        housePosterDTO.setFloor(1);
        housePosterDTO.setTotalFloor(12);
        housePosterDTO.setTags("满二,唯一");
        housePosterDTO.setPosterTopic("12333");
        housePosterDTO.setPrice(new BigDecimal("120000"));
        housePosterDTO.setArea(120.87F);
        housePosterDTO.setHouseDetail("111");
        housePosterDTO.setOrientation(1);
        ResultDO<Long> resultDO=templateService.addHousePoster(housePosterDTO);
        System.out.println(JSON.toJSONString(resultDO));
    }

//    @Test
//    public void testDescribeHousePoster(){
//        ResultDO<TempLateDetailDTO> resultDO=templateService.describeHousePoster(2L, 5L);
//        System.out.println(JSON.toJSONString(resultDO));
//    }

    @Test
    public void testAddBuildingPoster(){
        BuildingPosterDTO buildingPosterDTO=new BuildingPosterDTO();
        buildingPosterDTO.setBuildingPictureUrl("1111");
        buildingPosterDTO.setBuildingName("汤臣一品");
        buildingPosterDTO.setLongitude("121.821471");
        buildingPosterDTO.setLatitude("30.968626");
        buildingPosterDTO.setArea("上海-浦东");
        buildingPosterDTO.setPosterTopic("主题");
        buildingPosterDTO.setOpenTime("2017年1月20日");
        buildingPosterDTO.setSaleArea("50mm，70mm，90mm，110mm");
        buildingPosterDTO.setBuildingAddress("武东路198");
        buildingPosterDTO.setSalePrice("120000元/平");
        buildingPosterDTO.setSaleModel("1室-3室");
        buildingPosterDTO.setSellingPoints("便宜😆");
        ResultDO<Long> resultDO=templateService.addBuildingPoster(buildingPosterDTO);
        System.out.println(JSON.toJSONString(resultDO));
    }

//    @Test
//    public void testDescribeBuildingPoster(){
//        ResultDO<TempLateDetailDTO> resultDO=templateService.describeBuildingPoster(1L, 1L);
//        System.out.println(JSON.toJSONString(resultDO));
//    }

    @Test
    public void testQueryTemplate(){
        TemplateDTO templateDTO=templateService.queryTemplate(1L, 1L);
        System.out.println(JSON.toJSONString(templateDTO));
    }
}
