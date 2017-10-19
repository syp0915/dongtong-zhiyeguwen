package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.HbPrizeRecordDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.HbPrizeRecordServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/15 下午1:26
 * version V1.0.0
 */
public class HbPrizeRecordServiceTest extends JunitBaseTest {
    @Autowired
    private HbPrizeRecordService prizeRecordService;

    @Test
    public void testPrizeRecordQuery(){
        ResultDO<List<HbPrizeRecordDTO>> resultDO = prizeRecordService.prizeRecordQuery();
        Assert.assertNotNull(resultDO);
    }

}
