package com.shfc.house.service;

import com.shfc.house.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.service
 * @Description: kafka的消费测试
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/4/18 下午2:21
 * version V1.0.0
 */
public class OrderConsumeTest extends JunitBaseTest {
    @Autowired
    private OrderConsume orderConsume;

    @Test
    public void testStartKafkaConsumer(){
        orderConsume.startKafkaConsumer();
    }
}
