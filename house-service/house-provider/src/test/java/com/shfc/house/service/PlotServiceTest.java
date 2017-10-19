package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.dto.PlotRoomDTO;
import com.shfc.house.dto.PlotUnitDTO;
import com.shfc.house.query.NearbyPlotQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.PlotServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/11 下午4:23
 * version V1.0.0
 */
public class PlotServiceTest extends JunitBaseTest {
    @Autowired
    private PlotService plotService;

    @Test
    public void testQueryPlotByKeyword(){
        ResultDO<List<PlotAddressDTO>> resultDO = plotService.queryPlotByKeyword("赤峰路");

        Assert.assertNotNull(resultDO.getData());
    }

    @Test
    public void testQueryNearbyPlotGPS(){
        NearbyPlotQuery nearbyPlotQuery = new NearbyPlotQuery();
        nearbyPlotQuery.setLongitude("121");
        nearbyPlotQuery.setLatitude("31");

        ResultDO<List<PlotAddressDTO>> resultDO = plotService.queryNearbyPlotGPS(nearbyPlotQuery);

        Assert.assertNotNull(resultDO.getData());
    }

    @Test
    public void testFindPlotUnitByPlotId(){
        ResultDO<List<PlotUnitDTO>> resultDO = plotService.findPlotUnitByPlotId(101097L);

        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testFindRoomByPlotUnitId(){
        ResultDO<List<PlotRoomDTO>> resultDO = plotService.findRoomByPlotUnitId(3L);

        Assert.assertNotNull(resultDO);
    }
}
