package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseCorrect;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:44
 * version V1.0.0
 */
public class LeadsHouseCorrectMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseCorrectMapper leadsHouseCorrectMapper;

    @Test
    public void insterTest(){
        LeadsHouseCorrect leadsHouseCorrect = new LeadsHouseCorrect();
        leadsHouseCorrect.setLeadsHouseId(1L);
        leadsHouseCorrectMapper.insert(leadsHouseCorrect);
    }
}
