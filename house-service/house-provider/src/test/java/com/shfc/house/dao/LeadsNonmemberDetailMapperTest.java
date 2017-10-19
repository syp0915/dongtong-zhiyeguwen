package com.shfc.house.dao;

import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.LeadsNonmemberDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.dao
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/6 下午5:15
 * version V1.0.0
 */
public class LeadsNonmemberDetailMapperTest extends JunitBaseTest {
    @Autowired
    private LeadsNonmemberDetailMapper leadsNonmemberDetailMapper;

    @Test
    public void insertTest(){
        LeadsNonmemberDetail leadsNonmemberDetail = new LeadsNonmemberDetail();
        leadsNonmemberDetail.setHouseNum(2);
        leadsNonmemberDetailMapper.insert(leadsNonmemberDetail);
    }
}
