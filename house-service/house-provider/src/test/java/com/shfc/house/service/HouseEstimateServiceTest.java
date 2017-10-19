package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.HouseEstimateDTO;
import com.shfc.house.query.HouseEstimateQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.service.HouseEstimateServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/11 下午3:48
 * version V1.0.0
 */
public class HouseEstimateServiceTest extends JunitBaseTest {
    @Autowired
    private HouseEstimateService houseEstimateService;

    @Test
    public void testEstimate(){
        HouseEstimateQuery query = new HouseEstimateQuery();
        query.setPlotId(102096L);//小区Id
        query.setServeType(3);//物业类型  Y -1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅 8：叠加别墅 14：新里洋房
        query.setUnitNo("33");//楼号
        query.setRoomNo("303");//门牌号
        query.setArea(82.3F);//建筑面积
        query.setRoom(2);//房
        query.setHall(1);//厅
        query.setBathroom(1);//卫
        query.setKitchen(1);//厨房
        query.setFloor(3);//所在楼层
        query.setTotalFloor(10);//所在楼层

        ResultDO<HouseEstimateDTO> resultDO = houseEstimateService.estimate(query);

        Assert.assertNotNull(resultDO);
    }

}