package com.shfc.house.service;

import com.shfc.house.constant.ConstantService;
import com.shfc.kafka.comsumer.KafkaConsumerClient;
import com.shfc.kafka.comsumer.dto.KafkaConsumerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.service.OrderConsume
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/16 13:07
 * version V1.0.0
 */
@Service
public class OrderConsume {
    @Autowired
    private KafkaConsumerClient consumerClient;

    private static final String MERCHANT_NO_PAY_NOTIFY_TOPIC = ConstantService.MERCHANT_NO+"PayNotifyMessage";
    @Autowired
    private OrderConsumeServiceImpl orderConsumeService;
    /**
     * 定义kafka启动
     */
    @PostConstruct
    public void startKafkaConsumer(){
        KafkaConsumerDto kafkaConsumerDto = consumerClient.getKafKaConsumerDto(MERCHANT_NO_PAY_NOTIFY_TOPIC, 3,orderConsumeService);
        List<KafkaConsumerDto> list = new ArrayList<KafkaConsumerDto>();
        list.add(kafkaConsumerDto);
        consumerClient.kafkaConsumer(list);
    }
}
