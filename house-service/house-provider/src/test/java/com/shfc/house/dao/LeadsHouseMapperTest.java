package com.shfc.house.dao;

import com.shfc.common.math.RandomUtils;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:51
 * version V1.0.0
 */
public class LeadsHouseMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseMapper leadsHouseMapper;

    @Test
    public void insertTest(){
        LeadsHouse leadsHouse = new LeadsHouse();
        leadsHouse.setHouseCode(RandomUtils.generateNumberString(10));
        leadsHouse.setSource(1);
        leadsHouseMapper.insert(leadsHouse);
    }
}
