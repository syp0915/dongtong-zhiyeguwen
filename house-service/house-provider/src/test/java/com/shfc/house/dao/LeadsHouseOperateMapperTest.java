package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsHouseOperate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午2:57
 * version V1.0.0
 */
public class LeadsHouseOperateMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsHouseOperateMapper leadsHouseOperateMapper;

    @Test
    public void insertTest(){
        LeadsHouseOperate leadsHouseOperate = new LeadsHouseOperate();
        leadsHouseOperate.setLeadsHouseId(1L);
        leadsHouseOperateMapper.insert(leadsHouseOperate);
    }
}
