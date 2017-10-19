package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseCall;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:34
 * version V1.0.0
 */
public class LeadsHouseCallMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseCallMapper leadsHouseCallMapper;

    @Test
    public void insertTest(){
        LeadsHouseCall leadsHouseCall = new LeadsHouseCall();
        leadsHouseCall.setLeadsHouseId(1L);
        leadsHouseCall.setLeadsOwnerId(1L);
        leadsHouseCall.setRealtorId(1L);
        leadsHouseCallMapper.insert(leadsHouseCall);
    }
}
