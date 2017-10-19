package com.shfc.base.service;

import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.SmsDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 短信
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-11 16:36
 **/
public class SmsRemoteServiceTest extends JunitBaseTest {
    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;


    @Test
    public void testSend(){
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setPhone("13816513175");
        ResultDO<String> resultDO = smsRemoteService.sendCheckCode(smsDTO);
        System.out.println(resultDO);
    }
//    @Test
//    public void testSendVoiceCodeService() {
//        ResultDO<String> resultDO = smsRemoteService.sendVoiceCode("17602113283");
//        Assert.assertNotNull(resultDO.getData());
//
//    }
}
