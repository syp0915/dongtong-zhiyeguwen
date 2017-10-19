package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.NnsHouse;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.query.NnsHousePublishQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Package com.shfc.house.service.NnsHouseServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/10 18:06
 * version V1.0.0
 */
public class NnsHouseServiceTest extends JunitBaseTest {
    @Autowired
    private NnsHouseService nnsHouseService;

    @Test
    public void testFindDetailHouseById(){
        ResultDO<NnsHouseDetailDTO> resultDO = nnsHouseService.findDetailHouseById(3L);

        Assert.assertNotNull(resultDO.getData());
    }

    @Test
    public void  testQueryNnsHousePublish(){
        NnsHousePublishQuery query = new NnsHousePublishQuery();
        query.setPlotId(123L);
        query.setUnitNo("33");
        query.setRoomNo("3303");

        ResultDO<Long> resultDO = nnsHouseService.queryNnsHousePublish(query);

        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testFindHouseById(){
        NnsHouse nnsHouse = nnsHouseService.findHouseById(3L);

        Assert.assertNotNull(nnsHouse);
    }

    @Test
    public void testSaveNnsHouseEntrust(){
        NnsHouseEntrustDTO dto = new NnsHouseEntrustDTO();
        dto.setDealUrl("上海市杨浦区"); // 委托协议照片地址
        dto.setPlotId(123L); //小区id
        dto.setUnitNo("33"); //楼栋号
        dto.setRoomNo("303"); //门牌号
        dto.setFloor(3); //所在楼层
        dto.setTotalFloor(10);//总楼层
        dto.setArea(82.3F);//建筑面积
        dto.setRoom(2);//房
        dto.setHall(1);//厅
        dto.setBathroom(1);//卫
        dto.setKitchen(1);//厨房
        dto.setHouseType(2);//房产证类型 (0-未满两年 1-满两年 2-满五年)
//      dto.setTagIds(null);//房源特色	[1,2]
        dto.setPriceType(0);//房价类型	（0-实际到手 1-税费各付）
        dto.setTotalPrice(new BigDecimal("3030000"));//房价

        ResultDO<Long> resultDO = nnsHouseService.saveNnsHouseEntrust(dto);

        Assert.assertNotNull(resultDO);
    }

}
