package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.*;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.LeadsHouseQuery;
import com.shfc.mybatis.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/11 上午9:17
 * version V1.0.0
 */
public class LeadsHouseServiceTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseService leadsHouseService;

    @Test
    public void testRecommendLeadsHouse(){

        ResultDO<List<LeadsHouseDTO>> resultDO = leadsHouseService.recommendLeadsHouse(10, 1L, "121.636621", "31.20497");
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testQueryLeadsHouse(){
        LeadsHouseQuery query = new LeadsHouseQuery();
        query.setPageSize(10);
        query.setPageNumber(1);
        ResultDO<Page<LeadsHouseDTO>> resultDO = leadsHouseService.queryLeadsHouse(query);
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testCorrectLeadsHouse(){
//        LeadsHouseCorrectDTO dto = new LeadsHouseCorrectDTO();
//        dto.setLeadsHouseId(123L);
//        ResultDO<Boolean> resultDO = leadsHouseService.correctLeadsHouse(dto,3L);
//        Assert.assertNotNull(resultDO);
//
//        LeadsHouseCorrectDTO dto_1 = new LeadsHouseCorrectDTO();
//        dto_1.setLeadsHouseId(1L);
//        ResultDO<Boolean> resultDO_1 = leadsHouseService.correctLeadsHouse(dto_1,1L);
//        Assert.assertNotNull(resultDO_1);

        LeadsHouseCorrectDTO dto_2 = new LeadsHouseCorrectDTO();
        dto_2.setLeadsHouseId(123L);
        ResultDO<Boolean> resultDO_2 = leadsHouseService.correctLeadsHouse(dto_2,1L);
        Assert.assertNotNull(resultDO_2);
    }

    @Test
    public void testDetailLeadsHouse(){
//        ResultDO<LeadsHouseDetailDTO> resultDO = leadsHouseService.detailLeadsHouse(1L,1L);
//        Assert.assertNotNull(resultDO);

        ResultDO<LeadsHouseDetailDTO> resultDO_1 = leadsHouseService.detailLeadsHouse(1L,45L);
        Assert.assertNotNull(resultDO_1);
    }

    @Test
    public void testQueryByKeyword(){
//        ResultDO<List<LeadsPlotDTO>> resultDO = leadsHouseService.queryByKeyword("");
//        Assert.assertNotNull(resultDO);

        ResultDO<List<LeadsPlotDTO>> resultDO_1 = leadsHouseService.queryByKeyword("杨浦");
        Assert.assertNotNull(resultDO_1);
    }

    @Test
    public void testScanLeadsHouse(){
        BaseQuery query = new BaseQuery(1,5);
        ResultDO<Page<LeadsHouseDateDTO>> resultDO = leadsHouseService.scanLeadsHouse(query,1L);
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testCallLeadsHouse(){
        BaseQuery query = new BaseQuery(1,5);
        ResultDO<Page<LeadsHouseDateDTO>> resultDO = leadsHouseService.callLeadsHouse(query,1L);
        Assert.assertNotNull(resultDO);
    }

}
