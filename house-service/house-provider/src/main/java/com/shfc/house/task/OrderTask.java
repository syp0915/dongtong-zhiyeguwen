package com.shfc.house.task;


import com.fc.common.redis.RedisUtil;
import com.shfc.house.domain.LeadsOrder;
import com.shfc.house.dto.OrderInfoDTO;
import com.shfc.house.manager.OrderManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Package com.shfc.house.task.OrderTask
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 14:01
 * version V1.0.0
 */
@Component
public class OrderTask {
    private static final Logger logger = Logger.getLogger(OrderTask.class);
    @Autowired
    private OrderManager orderManager;
    /**
     * 每一分钟刷一次,获取待支付订单集合,并关闭过期订单
     */
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void noPayment(){
        //List<OrderInfoDTO> orderList = (List<OrderInfoDTO>) RedisUtil.get("LEADS_REDIS_KEY_ORDER");
       orderManager.closeNoPaymentList();
    }

}
