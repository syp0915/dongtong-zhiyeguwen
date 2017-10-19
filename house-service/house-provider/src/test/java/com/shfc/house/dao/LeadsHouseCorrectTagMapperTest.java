package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseCorrectTag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:48
 * version V1.0.0
 */
public class LeadsHouseCorrectTagMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseCorrectTagMapper leadsHouseCorrectTagMapper;

    @Test
    public void insertTest(){
        LeadsHouseCorrectTag leadsHouseCorrectTag = new LeadsHouseCorrectTag();
        leadsHouseCorrectTag.setLeadsCorrectId(1L);
        leadsHouseCorrectTag.setTagId(1L);
        leadsHouseCorrectTagMapper.insert(leadsHouseCorrectTag);
    }
}
