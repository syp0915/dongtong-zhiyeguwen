package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.OrderAttestationDTO;
import com.shfc.house.dto.OrderInfoDTO;
import com.shfc.house.dto.OrderListDTO;
import com.shfc.house.dto.OrderParamDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunyaping
 * @Package com.shfc.house.service
 * @Description:订单服务测试
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-04-18 13:30
 * version V1.0.0
 **/
public class OrderServiceTest extends JunitBaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder(){
        OrderParamDTO orderParamDTO=new OrderParamDTO();
        orderParamDTO.setComboId(9L);
        orderParamDTO.setRealtorId(10L);
        ResultDO<OrderInfoDTO> resultDO = orderService.createOrder(orderParamDTO);
        Assert.assertNotNull(resultDO.getData());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println(resultDO.getData());

    }

    @Test
    public void testOrderList(){
        OrderParamDTO query=new OrderParamDTO();
        query.setComboId(1L);
        query.setRealtorId(1L);
        ResultDO<Page<OrderListDTO>> resultDO=orderService.orderList(query);
        Assert.assertNotNull(resultDO.getData());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println(resultDO.getData().getData());

    }

    @Test
    public void testOrderDetail(){
        OrderParamDTO query=new OrderParamDTO();
        query.setOrderId(225L);
        ResultDO<OrderInfoDTO> resultDO=orderService.orderDetail(query);
        Assert.assertNotNull(resultDO.getData());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        System.out.println(resultDO.getData().getOrderNum());

    }




}
