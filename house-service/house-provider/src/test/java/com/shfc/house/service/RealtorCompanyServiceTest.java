package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.RealtorCompany;
import com.shfc.house.domain.RealtorStore;
import com.shfc.house.dto.RealtorCompanyDTO;
import com.shfc.house.dto.RealtorStoreDTO;
import com.shfc.house.query.CustomerStoreQuery;
import com.shfc.mybatis.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.house.service.RealtorCompanyServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/20 上午10:10
 * version V1.0.0
 */
public class RealtorCompanyServiceTest extends JunitBaseTest {
    @Autowired
    private RealtorCompanyService realtorCompanyService;

    @Test
    public void testSelectRealtorCompanyById(){
        RealtorCompany realtorCompany = realtorCompanyService.selectRealtorCompanyById(3L);
        Assert.assertNotNull(realtorCompany);
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        RealtorCompany realtorCompany = new RealtorCompany();
        realtorCompany.setId(1L);
        realtorCompany.setComCreateAt(new Date());//公司成立时间
        realtorCompany.setComType(new Byte("1"));//企业类型 1-普通企业 2-社会团体 3-色也单位 4-民办非企业单位 5-民办非企业单位 6-党政及国家机构
        realtorCompany.setComTel("18895738952");//公司电话
        realtorCompany.setComImg("http://shfc-img.oss-cn-shanghai.aliyuncs.com/realtor/company/2016/11/30/IMG_1480504798041_827.png");//公司图片
        realtorCompany.setLinkman("三子");//联系人
        realtorCompany.setContractNumber("SHFC111");//合同编号
        realtorCompany.setCodeType(true);//代码类型 1-组织机构代码,2-三证合一的社会信用代码
        realtorCompany.setChargePerson("张三");//签章负责人姓名
        realtorCompany.setChargePersonType(new Byte("1"));//签章负责人类型 1-法人 2-代理人
        realtorCompany.setChargePersonIdentity("232212345654678897");//签章负责人身份证号码
        realtorCompany.setSealData("ceshi111111");//经纪公司签章数据 base64数据

        ResultDO<Long> resultDO = realtorCompanyService.updateByPrimaryKeySelective(realtorCompany);
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testSelectRealtorCompanyByKey(){
        ResultDO<List<RealtorCompany>> resultDO = realtorCompanyService.selectRealtorCompanyByKey("地产",new Page(1,10));
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testSelectRealtorStoreByCompanyId(){
        ResultDO<List<RealtorStore>> resultDO = realtorCompanyService.selectRealtorStoreByCompanyId(1,new Page(1,10));
        Assert.assertNotNull(resultDO);
    }

    @Test
    public void testQueryCompanyByKeyword(){
        ResultDO<List<RealtorCompanyDTO>> resultDO=realtorCompanyService.queryCompanyByKeyword("链家");
        System.out.println(JSON.toJSONString(resultDO));

    }

    @Test
    public void testQueryStoreByKeyword(){
        CustomerStoreQuery query=new CustomerStoreQuery();
        query.setRealtorCompanyId(1400L);
        query.setKeyword("古北");
        query.setPageSize(10);
        ResultDO<Page<RealtorStoreDTO>> resultDO=realtorCompanyService.queryStoreByKeyword(query);
        System.out.println(JSON.toJSONString(resultDO));

    }
}
