package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseScan;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午3:03
 * version V1.0.0
 */
public class LeadsHouseScanMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseScanMapper leadsHouseScanMapper;

    @Test
    public void insertTest(){
        LeadsHouseScan leadsHouseScan = new LeadsHouseScan();
        leadsHouseScan.setLeadsHouseId(1L);
        leadsHouseScanMapper.insert(leadsHouseScan);
    }
}
