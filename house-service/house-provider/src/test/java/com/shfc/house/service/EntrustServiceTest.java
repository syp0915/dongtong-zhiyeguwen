package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.httpbean.req.*;
import com.shfc.house.httpbean.resp.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.house.service.EntrustServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/19 下午1:24
 * version V1.0.0
 */
public class EntrustServiceTest extends JunitBaseTest {
    @Autowired
    private EntrustService entrustService;

    @Test
    public void testGetEntrustListByUserId(){
//        ReqBean60101 reqBean60101 = new ReqBean60101();
//        ResultDO<RespBean60101> resultDO = entrustService.getEntrustListByUserId(reqBean60101);
//        Assert.assertNotNull(resultDO);

//        ReqBean60101 reqBean60101_2 = new ReqBean60101();
//        reqBean60101_2.setUserId("1");
//        reqBean60101_2.setPageNumber(null);
//        reqBean60101_2.setPageSize(null);
//        ResultDO<RespBean60101> resultDO_2 = entrustService.getEntrustListByUserId(reqBean60101_2);
//        Assert.assertNotNull(resultDO_2);

        ReqBean60101 reqBean60101_3 = new ReqBean60101();
        reqBean60101_3.setUserId("1");
        reqBean60101_3.setPageNumber(1);
        reqBean60101_3.setPageSize(20);
        ResultDO<RespBean60101> resultDO_3 = entrustService.getEntrustListByUserId(reqBean60101_3);
        Assert.assertNotNull(resultDO_3);
    }

    @Test
    public void testGetEntrustInfoById(){
//        ReqBean60102 reqBean60102_1 = new ReqBean60102();
//        ResultDO<RespBean60102> resultDO_1 = entrustService.getEntrustInfoById(reqBean60102_1);
//        Assert.assertNotNull(resultDO_1);

        ReqBean60102 reqBean60102_2 = new ReqBean60102();
        reqBean60102_2.setAgreementId("1");
        ResultDO<RespBean60102> resultDO_2 = entrustService.getEntrustInfoById(reqBean60102_2);
        Assert.assertNotNull(resultDO_2);
    }

    @Test
    public void testRevokeEntrustById(){
//        ReqBean60103 reqBean60103_1 = new ReqBean60103();
//        ResultDO<RespBean60103> resultDO_1 = entrustService.revokeEntrustById(reqBean60103_1);
//        Assert.assertNotNull(resultDO_1);

//        ReqBean60103 reqBean60103_2 = new ReqBean60103();
//        reqBean60103_2.setAgreementId("1");
//        reqBean60103_2.setRevokeReason("撤销原因");
//        ResultDO<RespBean60103> resultDO_2 = entrustService.revokeEntrustById(reqBean60103_2);
//        Assert.assertNotNull(resultDO_2);

        ReqBean60103 reqBean60103_3 = new ReqBean60103();
        reqBean60103_3.setAgreementId("3");
        reqBean60103_3.setRevokeReason("撤销原因");
        ResultDO<RespBean60103> resultDO_3 = entrustService.revokeEntrustById(reqBean60103_3);
        Assert.assertNotNull(resultDO_3);
    }

    @Test
    public void testGetEntrustStatusListById(){
        ReqBean60102 reqBean60104_1 = new ReqBean60102();
        ResultDO<RespBean60104> resultDO_1 = entrustService.getEntrustStatusListById(reqBean60104_1);
        Assert.assertNotNull(resultDO_1);

        ReqBean60102 reqBean60104_2 = new ReqBean60102();
        reqBean60104_2.setAgreementId("1");
        ResultDO<RespBean60104> resultDO_2 = entrustService.getEntrustStatusListById(reqBean60104_2);
        Assert.assertNotNull(resultDO_2);
    }

    @Test
    public void testSubmitEntrust(){
//        ReqBean60106 reqBean60106_1 = new ReqBean60106();
//        ResultDO<RespBean60106> resultDO_1 = entrustService.submitEntrust(reqBean60106_1);
//        Assert.assertNotNull(resultDO_1);

//        ReqBean60106 reqBean60106_2 = new ReqBean60106();
//        reqBean60106_2.setAgreementId("1");//	协议id
//        reqBean60106_2.setName("谢海滨");//	姓名
//        reqBean60106_2.setIdentityId("621234198901212212");//	身份证号
//        reqBean60106_2.setPhone("13482493139");//	手机号
//        reqBean60106_2.setPicUrl("1");//	用户签章图片url
//        reqBean60106_2.setEntrustPeriod(1);//	委托期限
//        reqBean60106_2.setVerifyCodeId("1");//验证码id
//        reqBean60106_2.setVerifyCode("1");//验证码
//        ResultDO<RespBean60106> resultDO_2 = entrustService.submitEntrust(reqBean60106_2);
//        Assert.assertNotNull(resultDO_2);

        ReqBean60106 reqBean60106_3 = new ReqBean60106();
        reqBean60106_3.setAgreementId("1");//	协议id
        reqBean60106_3.setName("阳阳");//	姓名
        reqBean60106_3.setIdentityId("350582199207225518");//	身份证号350582199207225518
        reqBean60106_3.setPhone("15980002220");//	手机号
        reqBean60106_3.setPicUrl("1");//	用户签章图片url
        reqBean60106_3.setEntrustPeriod(1);//	委托期限
        reqBean60106_3.setVerifyCodeId("1");//验证码id
        reqBean60106_3.setVerifyCode("1");//验证码
        reqBean60106_3.setOperateType("0");
        ResultDO<RespBean60106> resultDO_3 = entrustService.submitEntrust(reqBean60106_3);
        Assert.assertNotNull(resultDO_3);
    }
}
