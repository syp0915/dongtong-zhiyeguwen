package com.shfc.base.service;/**
 * @File ${package_name}${file_name}
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @author ${user}
 * @date ${date} ${time}
 * @version V1.0
 */

import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.BlockInfoDTO;
import com.shfc.base.dto.RegionInfoDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 测试用例
 *
 * @author wky
 * @version V1.0
 * @create 2016-12-29 10:47
 **/
public class AreaExtServiceTest extends JunitBaseTest {
    @Autowired
    private AreaExtService areaExtService;

    @Test
    public void testAreaService() {

        ResultDO<List<RegionInfoDTO>> resultDO = areaExtService.getRegionBlockInfo("310000");
        Assert.assertNotNull(resultDO.getData());

        ResultDO<List<RegionInfoDTO>> resultDO_2 = areaExtService.getRegionBlockInfo("");
        Assert.assertNull(resultDO_2.getData());


        ResultDO<List<RegionInfoDTO>> resultDO_3 = areaExtService.getRegionBlockInfo("310001");
        Assert.assertNull(resultDO_3.getData());
    }

    @Test
    public void testQueryRegion(){
        ResultDO<List<RegionInfoDTO>> resultDO=areaExtService.queryRegion("310000");
        System.out.println(resultDO.toString());

    }

    @Test
    public void testQueryBlock(){
        ResultDO<List<BlockInfoDTO>> resultDO=areaExtService.queryBlock("310112");
        System.out.println(resultDO.toString());

    }




}
