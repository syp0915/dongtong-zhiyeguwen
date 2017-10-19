package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.CompanyStoreDTO;
import com.shfc.house.dto.CurrentRealtorDTO;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.query.RealtorShortcutQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.RealtorServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/11 下午5:08
 * version V1.0.0
 */
public class RealtorServiceTest extends JunitBaseTest{
    @Autowired
    private RealtorService realtorService;

    @Test
    public void testFindCurrentRealtorById(){
        CurrentRealtorDTO currentRealtorDTO = realtorService.findCurrentRealtorById(1L);
        Assert.assertNotNull(currentRealtorDTO);
    }

    @Test
    public void testShortcut(){
        RealtorShortcutQuery query = new RealtorShortcutQuery();
        query.setPhone("18895738952");//手机号
        query.setCheckCode("160929");//验证码
        query.setMsgId("1");//消息id
        query.setDeviceId("2");//设备ID

        ResultDO<CurrentRealtorDTO> resultDO = realtorService.shortcut(query);
        Assert.assertNotNull(resultDO);

        RealtorShortcutQuery query2 = new RealtorShortcutQuery();
        query2.setPhone("10001921870");//手机号
        query2.setCheckCode("160929");//验证码
        query2.setMsgId("1");//消息id
        query2.setDeviceId("2");//设备ID

        ResultDO<CurrentRealtorDTO> resultDO2 = realtorService.shortcut(query2);
        Assert.assertNotNull(resultDO2);


    }

    @Test
    public void testBasicInfo(){
        RealtorInfoDTO realtorInfoDTO = new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(74L);//经纪人id
        realtorInfoDTO.setRealName("纪杰玲");//真实姓名
        realtorInfoDTO.setStoreCode("ZY001");//门店代码
        realtorInfoDTO.setIdentityNo("123456789098765432");//身份证
        //realtorInfoDTO.setPosition(1);//职位(0-经理;1-店长;2-高级职业顾问;3-中级职业顾问;4-初级职业顾问;)
        realtorInfoDTO.setBuildingNameList("第一小区,第二小区");//主营楼盘
        realtorInfoDTO.setComId(1L);//公司ID
        realtorInfoDTO.setComName("沪联房地产");//公司名称
        realtorInfoDTO.setTelphone("10001921870");//手机号
        realtorInfoDTO.setStoreId(44L);//门店id
        realtorInfoDTO.setStoreName("横沙岛店");//门店名称
        realtorInfoDTO.setDistrictId(310104L);
        realtorInfoDTO.setBlockId(72L);
        realtorInfoDTO.setGender(1);//性别(0男1女)
        realtorInfoDTO.setCardImg("http://shfc-img.os-cn-shanghai.aliyuncs.com/realtor/realtor/2016/09/28/IMG_1475042394540_58265.png");
        ResultDO<String> resultDO = realtorService.basicInfo(realtorInfoDTO);

        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testFindCompanyStoreByStoreCode(){
        CompanyStoreDTO companyStoreDTO = realtorService.findCompanyStoreByStoreCode("1");
        //Assert.assertNotNull(companyStoreDTO);
        System.out.println(companyStoreDTO);
    }

    @Test
    public void testCompanyStoreInfo(){
        List<CompanyStoreDTO> list = realtorService.companyStoreInfo("1");

        Assert.assertNotNull(list);
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
        ResultDO<CurrentRealtorDTO> resultDO = realtorService.identityAuth(realtorInfoDTO);
        Assert.assertNotNull(resultDO);

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
        ResultDO<CurrentRealtorDTO> resultDO2 = realtorService.identityAuth(realtorInfoDTO2);

        Assert.assertNotNull(resultDO2.getErrMsg());
    }

    @Test
    public void testShowCompleteInfo(){
        RealtorInfoDTO realtorInfoDTO = realtorService.showCompleteInfo(1L);
        Assert.assertNotNull(realtorInfoDTO);

        RealtorInfoDTO realtorInfoDTO_2 = realtorService.showCompleteInfo(333L);
        Assert.assertNull(realtorInfoDTO_2);
    }

    @Test
    public void testMyInfo(){
        RealtorInfoDTO realtorInfoDTO = realtorService.myInfo(4L);
        Assert.assertNotNull(realtorInfoDTO);
    }

    @Test
    public void testUpdateUserAutograph(){
        ResultDO<String> resultDO_1 = realtorService.updateUserAutograph(1L,"测试");
        Assert.assertNotNull(resultDO_1);

        ResultDO<String> resultDO_2 = realtorService.updateUserAutograph(28L,"测试11");
        Assert.assertNotNull(resultDO_2);
    }

    /**
     * 经纪人完善基本信息
     * @param
     * @return
     */
    @Test
    public  void testComplete(){
        RealtorInfoDTO realtorInfoDTO=new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(11L);
        realtorInfoDTO.setCardImg("Vn5HZBD0juHlc-VrSs8P5IyjYlc7CwIPOTSxwB_yIfpVa9eERoX4oHJGIgTdlOAd");
        realtorInfoDTO.setRealName("无聊");
        ResultDO<String> resultDO=realtorService.completeBasicInfo(realtorInfoDTO);
        System.out.println(resultDO);
        //Assert.assertFalse(resultDO.isSuccess());

        RealtorInfoDTO realtorInfoDTO1=new RealtorInfoDTO();
        realtorInfoDTO1.setRealtorId(11L);
        realtorInfoDTO1.setCardImg("http://shfc-img.oss-cn-shanghai.aliyuncs.com/entrustprotocol/2017/2/10/IMG_1486718422971.jpg");
        realtorInfoDTO1.setRealName("无聊");
        ResultDO<String> result=realtorService.completeBasicInfo(realtorInfoDTO1);

        //Assert.assertTrue(result.isSuccess());
        System.out.println(result);
    }

    /**
     * 经纪人审核状态查询
     * @param
     * @return
     */
    @Test
    public void testQueryStatus(){
        ResultDO<RealtorAccoutStatusDTO> resultDO=realtorService.queryAccountStatus(11L);
        Assert.assertTrue(resultDO.isSuccess());
    }


    /**
     * 更新经纪人信息
     * @param
     * @return
     */

    @Test
    public void testUpdateInfo(){
        RealtorInfoDTO realtorInfoDTO=new RealtorInfoDTO();
        realtorInfoDTO.setRealtorId(81L);
//        realtorInfoDTO.setDistrictId(Long.parseLong("310104"));
//        realtorInfoDTO.setDistrictName("徐汇区");
//        realtorInfoDTO.setBlockId(Long.parseLong("1"));
//        realtorInfoDTO.setBlockName("田林");
//        realtorInfoDTO.setBuildingNameList("爱文公寓、联华公寓,北京西路1110弄");
        realtorInfoDTO.setHeadPortrait("http://shfc-img.img-cn-shanghai.aliyuncs.com/ext/20170217/2017/02/17/IMG_1487306173873_71755.jpg");
        ResultDO<String> resultDO=realtorService.updateInfo(realtorInfoDTO);
        System.out.println(JSON.toJSONString(resultDO));
    }


}
