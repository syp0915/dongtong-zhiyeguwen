package com.shfc.house.manager;

import com.shfc.house.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.manager.NnsEntrustProtocolManagerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/13 15:18
 * version V1.0.0
 */
public class NnsEntrustProtocolManagerTest extends JunitBaseTest {

    @Autowired
    private NnsEntrustProtocolManager nnsEntrustProtocolManager;

    @Test
    public void testSaveProtocol(){
        nnsEntrustProtocolManager.saveProtocol(null, 3l);
    }
}
