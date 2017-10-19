package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsComboDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午5:08
 * version V1.0.0
 */
public class LeadsComboDetailMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsComboDetailMapper leadsComboDetailMapper;

    @Test
    public void insertTest(){
        LeadsComboDetail leadsComboDetail = new LeadsComboDetail();
        leadsComboDetail.setComboId("1");
        leadsComboDetailMapper.insert(leadsComboDetail);
    }
}
