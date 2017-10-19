package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseOwner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:59
 * version V1.0.0
 */
public class LeadsHouseOwnerMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseOwnerMapper leadsHouseOwnerMapper;

    @Test
    public void insertTest(){
        LeadsHouseOwner leadsHouseOwner = new LeadsHouseOwner();
        leadsHouseOwner.setLeadsHouseId(1L);
        leadsHouseOwnerMapper.insert(leadsHouseOwner);
    }
}
