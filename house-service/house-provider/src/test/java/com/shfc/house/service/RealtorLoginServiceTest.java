package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.CompanyStoreDTO;
import com.shfc.house.dto.CurrentRealtorDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.query.RealtorShortcutQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.RealtorLoginServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/11 下午5:08
 * version V1.0.0
 */
public class RealtorLoginServiceTest extends JunitBaseTest{
    @Autowired
    private RealtorService realtorService;

    @Test
    public void testShortcut(){
        RealtorShortcutQuery query = new RealtorShortcutQuery();
        query.setPhone("13816513175");//手机号
        query.setCheckCode("061891");//验证码
        query.setMsgId("1499828235295");//消息id
        query.setDeviceId("2");//设备ID

        ResultDO<CurrentRealtorDTO> resultDO = realtorService.shortcut(query);
        Assert.assertNotNull(resultDO);

        System.out.println("testShortcut===  "+resultDO);


    }

    @Test
    public void testBasicInfo(){
        RealtorInfoDTO realtorInfoDTO = new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(10L);//经纪人id
        realtorInfoDTO.setRealName("纪杰玲");//真实姓名
        realtorInfoDTO.setStoreCode("ZY001");//门店代码
        realtorInfoDTO.setIdentityNo("123456789098765432");//身份证
        //realtorInfoDTO.setPosition(1);//职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
        realtorInfoDTO.setBuildingNameList("第一小区,第二小区");//主营楼盘
        realtorInfoDTO.setComId(1L);//公司ID
        realtorInfoDTO.setComName("沪联房地产");//公司名称
        realtorInfoDTO.setTelphone("10001921870");//手机号
        //realtorInfoDTO.setStoreId(44L);//门店id
        realtorInfoDTO.setStoreName("横沙岛店");//门店名称
        realtorInfoDTO.setGender(1);//性别(0男1女)
        ResultDO<String> resultDO = realtorService.basicInfo(realtorInfoDTO);
       // Assert.assertNotNull(resultDO);
        System.out.println(resultDO);

    }

    @Test
    public void testFindCompanyStoreByStoreCode(){
        CompanyStoreDTO companyStoreDTO = realtorService.findCompanyStoreByStoreCode("1");
        System.out.println(companyStoreDTO);
    }

    @Test
    public void testCompanyStoreInfo(){
        List<CompanyStoreDTO> list = realtorService.companyStoreInfo("1");
        System.out.println(list.size());
    }

    @Test
    public void testIdentityAuth(){
        RealtorInfoDTO realtorInfoDTO = new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(258L);//经纪人id
        realtorInfoDTO.setRealName("纪杰玲");//真实姓名
        realtorInfoDTO.setStoreCode("ZY001");//门店代码
        realtorInfoDTO.setIdentityNo("123456789098765432");//身份证
        realtorInfoDTO.setBuildingNameList("第一小区,第二小区");//主营楼盘
        realtorInfoDTO.setComId(1L);//公司ID
        realtorInfoDTO.setComName("沪联房地产");//公司名称
        realtorInfoDTO.setTelphone("10001921870");//手机号
        realtorInfoDTO.setStoreName("横沙岛店");//门店名称
        realtorInfoDTO.setGender(1);//性别(0男1女)
        //ResultDO<String> resultDO = realtorService.identityAuth(realtorInfoDTO);
        //Assert.assertNotNull(resultDO);

        RealtorInfoDTO realtorInfoDTO2 = new RealtorInfoDTO();
        realtorInfoDTO2.setRealtorId(3333L);//经纪人id
        realtorInfoDTO2.setRealName("纪杰玲");//真实姓名
        realtorInfoDTO2.setStoreCode("318");//门店代码
        realtorInfoDTO2.setIdentityNo("123456789098765432");//身份证
        realtorInfoDTO2.setBuildingNameList("第一小区,第二小区");//主营楼盘
        realtorInfoDTO2.setComId(1L);//公司ID
        realtorInfoDTO2.setComName("沪联房地产");//公司名称
        realtorInfoDTO2.setTelphone("10001921870");//手机号
        realtorInfoDTO2.setStoreName("横沙岛店");//门店名称
        realtorInfoDTO2.setGender(1);//性别(0男1女)
       // ResultDO<String> resultDO2 = realtorService.identityAuth(realtorInfoDTO2);

        //Assert.assertNotNull(resultDO2.getErrMsg());
    }

    @Test
    public void testShowCompleteInfo(){
        RealtorInfoDTO realtorInfoDTO = realtorService.showCompleteInfo(1L);
        Assert.assertNotNull(realtorInfoDTO);

        RealtorInfoDTO realtorInfoDTO_2 = realtorService.showCompleteInfo(333L);
        Assert.assertNull(realtorInfoDTO_2);
    }

}
