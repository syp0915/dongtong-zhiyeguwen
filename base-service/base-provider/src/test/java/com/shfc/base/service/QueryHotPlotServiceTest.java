package com.shfc.base.service;

import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.PlotDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 热门小区测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 09:54
 **/
public class QueryHotPlotServiceTest extends JunitBaseTest {
    @Autowired
    private QueryHotPlotService queryHotPlotService;

    @Test
    public void queryHotPlotTest(){

        ResultDO<List<PlotDTO>> resultDO=queryHotPlotService.queryPlot("167");
        Assert.assertNotNull(resultDO.getData());

        ResultDO<List<PlotDTO>> resultDO_1=queryHotPlotService.queryPlot("");
        Assert.assertNull(resultDO_1.getData());

    }
}
