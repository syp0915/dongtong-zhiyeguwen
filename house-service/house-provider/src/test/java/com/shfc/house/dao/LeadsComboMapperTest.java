package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsCombo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午5:11
 * version V1.0.0
 */
public class LeadsComboMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsComboMapper leadsComboMapper;

    @Test
    public void insertTest(){
        LeadsCombo leadsMemberCombo = new LeadsCombo();
        leadsMemberCombo.setComboName("1111");
        leadsComboMapper.insert(leadsMemberCombo);
    }
}
