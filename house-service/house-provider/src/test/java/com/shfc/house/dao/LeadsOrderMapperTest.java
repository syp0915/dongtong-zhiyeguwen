package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午5:18
 * version V1.0.0
 */
public class LeadsOrderMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsOrderMapper leadsOrderMapper;

    @Test
    public void insertTest(){
        LeadsOrder leadsOrder = new LeadsOrder();
        leadsOrder.setComboId(1L);
        leadsOrderMapper.insert(leadsOrder);
    }
}
