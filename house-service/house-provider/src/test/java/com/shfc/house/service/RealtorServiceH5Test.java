package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 14:06
 **/
public class RealtorServiceH5Test extends JunitBaseTest {
    @Autowired(required = false)
    private RealtorService realtorService;

//    @Test
//    public void testShowMyInfo(){
//        ResultDO<RealtorInfoDTO> resultDO=realtorService.showMyInfo(1L);
//        Assert.assertNotNull(resultDO.getData());
//    }


    @Test
    public void testCompleteBasicInfo(){
        RealtorInfoDTO realtorInfoDTO =new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(4L);
        realtorInfoDTO.setRealName("啊啊啊");
//        realtorInfoDTO.setComId(1L);
//        realtorInfoDTO.setStoreId(4L);
        realtorInfoDTO.setCardImg("http://shfc-img.img-cn-shanghai.aliyuncs.com/ext/20170217/2017/02/17/IMG_1487306173873_71755.jpg");

        ResultDO<String> resultDO=realtorService.completeBasicInfo(realtorInfoDTO);
        Assert.assertTrue(resultDO.isSuccess());
    }

    @Test
    public void testQueryAccountStatus(){
        ResultDO<RealtorAccoutStatusDTO> resultDO=realtorService.queryAccountStatus(256L);
        //Assert.assertNotNull(resultDO.getData());
        System.out.println(resultDO);
    }

//    @Test
//    public void sendCheckCode(){
//        CheckCodeQuery query=new CheckCodeQuery();
//        query.setPhone("18260121981");
//        //query.setPicCheckCode("1111");
//
//        ResultDO<CheckCodeDTO> resultDO =realtorServiceH5.sendCheckCode(query,);
//
//        Assert.assertTrue(resultDO.isSuccess());
//    }

}
