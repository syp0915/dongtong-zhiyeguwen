package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.*;
import com.shfc.house.query.WxJsQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-16 16:13
 **/
public class WxRealtorAccountServiceTest extends JunitBaseTest {
    @Autowired(required = false)
    private WxRealtorAccountService wxRealtorAccountService;

    /**
     * 根据微信code获取账户信息
     * @param
     * @return
     */
    @Test
    public void getAccountInfoByWxCode(){

        ResultDO<RealtorAccountInfoDTO> resultDO=wxRealtorAccountService.getAccountInfoByWxCode("00128D720erLwD1Y5H520fyV72028D7h");

        Assert.assertFalse(resultDO.isSuccess());

    }

    /**
     * 微信绑定经纪人账户
     * @param
     * @return
     */
    @Test
    public void bindRealtorAccount(){
        RealtorAccountBindDTO realtorAccountBindDTO=new RealtorAccountBindDTO();
        realtorAccountBindDTO.setWxOpenId("oA4jPwYvnOUmBQ2yQ6kWLgSPD_lU");
        realtorAccountBindDTO.setPhone("13816513175");
        realtorAccountBindDTO.setCheckCode("160929");
        realtorAccountBindDTO.setMsgId("20170216192207275891");
        realtorAccountBindDTO.setPicCheckCode("1111");
        ResultDO<RealtorAccoutStatusDTO> resultDO=wxRealtorAccountService.bindRealtorAccount(realtorAccountBindDTO);
        //Assert.assertFalse(resultDO.isSuccess());
        System.out.println(resultDO);
        realtorAccountBindDTO.setWxOpenId("oA4jPwYONagMUNoKKrUBfCv0uk7w");
        realtorAccountBindDTO.setPhone("13634463270");
        realtorAccountBindDTO.setCheckCode("160929");
        realtorAccountBindDTO.setMsgId("20170216192207275891");
        realtorAccountBindDTO.setPicCheckCode("1111");
        ResultDO<RealtorAccoutStatusDTO> result=wxRealtorAccountService.bindRealtorAccount(realtorAccountBindDTO);
        //Assert.assertFalse(result.isSuccess());
        System.out.println(result);


    }

    @Test
    public void testSmsPush(){
        ResultDO<String> resultDO_1 = wxRealtorAccountService.smsPush(3L,1,"审核通过");
        System.out.println(resultDO_1);
        Assert.assertNotNull(resultDO_1);

       /* ResultDO<String> resultDO_2 = wxRealtorAccountService.smsPush(3L,2,"审核未通过");
        Assert.assertNotNull(resultDO_2);*/
    }

    @Test
    public void testWxPush(){
        ResultDO<Object> resultDO_1 = wxRealtorAccountService.wxPush(22L,1,"审核通过","2016/08/08 08:08:08");
        Assert.assertNotNull(resultDO_1);

        /*ResultDO<Object> resultDO_2 = wxRealtorAccountService.wxPush(4L,2,"审核通过");
        Assert.assertNotNull(resultDO_2);*/
    }
    /**
     * 获取微信js参数信息
     * @param
     * @return
     */
    @Test
    public void textGetWxJsInfo(){
        WxJsQuery query=new WxJsQuery();
        query.setUrl("http://hb.10peak.com/dist/brokerValidation.html?wxOpenId=oA4jPwQeRA_eOkg0nUBD3TAxBJaU&realtorId=17");
        query.setWxAccountType("knhb");
        ResultDO<WxJsDTO> resultDO=wxRealtorAccountService.getWxJsInfo(query);
        Assert.assertTrue(resultDO.isSuccess());
    }
    /**
     * 发送微信模板消息
     * @param
     * @param
     * @return
     */
    @Test
    public void TestSendWxTempleteMessage(){
        WxTemplateMessageDTO dto=new WxTemplateMessageDTO();
        dto.setTouser("oA4jPweb9j_64smuz35KXKQkw1xM");
        dto.setUrl("http://hb.10peak.com");
        dto.setTemplate_id("-q-GRmlUUANAUTyxWl2SmLwVtAKkDs1wENuE3-AjjqI");
        WxTemplateMessageDataDTO data=new WxTemplateMessageDataDTO();
        WxMessageVCDTO vcdto=new WxMessageVCDTO();
        vcdto.setColor("#0A0A0A");
        vcdto.setValue("尊敬的用户,你好");
        data.setFirst(vcdto);
        WxMessageVCDTO vcdto1=new WxMessageVCDTO();
        vcdto1.setColor("#0A0A0A");
        vcdto1.setValue("快去抽奖吧");
        data.setRemark(vcdto1);
        WxMessageVCDTO vcdto2=new WxMessageVCDTO();
        vcdto2.setColor("#0A0A0A");
        vcdto2.setValue("经纪人身份认证");
        data.setKeyword1(vcdto2);
        WxMessageVCDTO vcdto3=new WxMessageVCDTO();

        vcdto3.setColor("#0A0A0A");
        vcdto3.setValue("认证成功");
        data.setKeyword2(vcdto3);
        WxMessageVCDTO vcdto4=new WxMessageVCDTO();
        vcdto4.setColor("#0A0A0A");
        vcdto4.setValue(DateUtils.getCurrentTime("yyyy-MM-dd hh:mm:ss"));
        data.setKeyword3(vcdto4);

        dto.setData(data);

        ResultDO<WxMessageDTO> resultDO=wxRealtorAccountService.sendWxTempleteMessage("SFJJR",dto);
        System.out.println(resultDO);
        //Assert.assertTrue(resultDO.isSuccess());
    }

    //@Test
    public void testSendWxRedPapper(){
        WxSendRedPapperReqDTO wxSendRedPapperReqDTO = new WxSendRedPapperReqDTO();
        wxSendRedPapperReqDTO.setOrderNo("201703161409401444");
        wxSendRedPapperReqDTO.setSendAmount(100L);
        wxSendRedPapperReqDTO.setWxOpenId("oA4jPweoe8B4GK9xF_zWbStCrRnE");
        //wxSendRedPapperReqDTO.setWxOpenId("oA4jPwSpmpc2-kK8OBbkYyw0aKIE");
        //wxSendRedPapperReqDTO.setWxOpenId("oA4jPwSkzmE5Qd03HvSPuXh1jAo0");
        ResultDO<WxSendRedPapperRespDTO> resultDO = wxRealtorAccountService.sendWxRedPapper("sfjjr", wxSendRedPapperReqDTO);
        System.out.println(JSON.toJSONString(resultDO));
    }
}
