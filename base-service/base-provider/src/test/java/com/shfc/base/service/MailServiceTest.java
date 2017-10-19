package com.shfc.base.service;

import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.AffixDTO;
import com.shfc.base.dto.MailDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 邮件发送测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-12 09:55
 **/
public class MailServiceTest extends JunitBaseTest{
    @Autowired
    private MailService mailService;

    @Test
    public void testSendService(){
        MailDTO mailDTO =new MailDTO();
        ResultDO<Boolean> resultDO=null;
        mailDTO.setTo("88888888@qq.com");
        mailDTO.setSubject("一个带附件的JavaMail邮件");
        mailDTO.setContent(" <p style=\"text-align: left;\">\n" +
                "     尽管房地产低迷，但没有影响到房地产税相关政策的出台。尽管中国房地产业协会副会长任志强近日表示：“房地产税和房价没关系”。但是买房的朋友依然非常关注相应税收的情况，究竟征收的标准是什么，税该如何计算?<br/>\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     房产税征收标准及税收如何计算\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (1)时间认定：2011年1月28日起购买的住房\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：新购住房是指2011年1月28日起购买的住房，购房时间以购房合同最后一页上打印的日期为准。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (2)缴纳房产税时间怎样确定?&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     房产税税款自纳税人取得应税住房产权的次月起计算，按年计征，不足一\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     年的按月计算应纳房产税税额。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：看房产证上的日期，从第二个月开始计算，满一年的按一年计\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     算;不足一年时间的，按月计算。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (3)征收对象：本市居民二套房、非本市居民新购房\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：征收对象具体包括两类：\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     一是本市居民家庭在本市新购且属于该居民家庭第二套及以上的住房(包括新购二手存量住房和新建商品住房);&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     二是非本市居民家庭在本市新购的住房。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (4)界定三类免征对象\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     A.对本市居民家庭换购住房给予优惠\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：本市居民家庭原来已拥有一套唯一住房，因为改善居住条件而\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     新购住房的，该居民家庭新购住房先按规定核定征免房产税，当其在新购住房后的一年内出售家庭原有唯一住房的，对新购住房已按规定缴纳的房产税，可予退还。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     B.对本市居民家庭子女成年后因婚姻等购房需求给予优惠&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：对本市居民家庭中的子女成年后因婚姻等需要而首次新购、且属该子女家庭唯一的住房，暂免征收房产税。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     C.对在本市工作生活的非本市居民家庭购房给予优惠\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：对于在本市工作生活的非本市居民的基本居住需求，给予优惠：一是，对符合国家和本市有关规定引进的高层次人才、重点产业紧缺急需人才，持有本市居住证并在本市工作生活的，其在本市新购且属于家庭唯一的住房，暂免征收房产税。二是，对持有本市居住证满三年并在本市工作生活的购房人，其在本市新购且属于家庭唯一的住房，暂免征收房产税;持有本市居住证但不满三年的购房人，其上述住房先按规定征收房产税，待持有本市居住证满三年且在本市工作生活的，其上述住房已征收的房产税，可予退还。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (5)如何进行征免认定?&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     对于新购住房的，购房人在办理房地产登记前，应按照地方税务机关的要求，主动提供家庭成员情况和由市房屋状况信息中心出具的其在本市拥有住房相关信息的查询结果。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：家庭成员情况：夫妻、未成年小孩，身份证、户口本、出生证\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     明、结婚证等;&nbsp;市房产交易中心出具的查询单。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (6)计税依据：交易价格的70%&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     税率：实行0.4%～0.6%差别化税率\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：房产税暂按应税住房市场交易价格的70%计算缴纳;&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     本市开展对部分个人住房征收房产税试点实行差别化的比例税率，即：适\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     用税率暂定为0.6%，但对应税住房每平方米市场交易价格低于本市上年度新建商品\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     住房平均销售价格2倍(含2倍)的，税率可暂减为0.4%;&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     应纳税额=应税面积×新购房单价×70%×税率\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     &nbsp;&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     (7)征税面积如何计算?&nbsp;\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     对本市居民家庭给予人均60平方米的免税住房面积(指住房建筑面积)扣除。合并计算的家庭全部住房面积为居民家庭新购住房面积和其他住房面积的总和。\n" +
                " </p>\n" +
                " <p style=\"text-align: left;\">\n" +
                "     【解读】：对本市居民家庭给予人均60平方米的免税住房面积(指住房建筑面积)扣除。即，对本市居民家庭在本市新购且属于该居民家庭第二套及以上住房的，合并计算的家庭全部住房面积人均不超过60平方米(含60&nbsp;平方米)的，其新购的住房暂免征收房产税;人均超过60平方米的，对属新购住房超出部分的面积，按规定计算征收房产税。\n" +
                " </p>\n" +
                " ");
        //String[] url={"http://fdfs.pre01.shfc999.com/group1/M00/00/00/wKhYrliAdO-AT0qyAAoNTjwf0wQ726.jpg","http://fdfs.pre01.shfc999.com/group1/M00/00/00/wKhYrliAdO-AT0qyAAoNTjwf0wQ726.jpg"};
        ArrayList<AffixDTO> list=new ArrayList<AffixDTO>();
        AffixDTO affixDTO=new AffixDTO();
        affixDTO.setFileName("a.jpg");
        affixDTO.setFile("http://shfcjr-img.oss-cn-shanghai.aliyuncs.com/house/community/2017/04/14/20170414143902690.jpg");
        list.add(affixDTO);

        AffixDTO affixDTO1=new AffixDTO();
        affixDTO1.setFileName("b.jpg");
        affixDTO1.setFile("http://shfcjr-img.oss-cn-shanghai.aliyuncs.com/house/community/2017/04/14/20170414143902690.jpg");
        list.add(affixDTO1);

        mailDTO.setList(list);
       // mailDTO.setAffix("http://shfc-file.oss-cn-shanghai.aliyuncs.com/supervision/%E6%A5%BC%E5%B8%82%E8%B0%83%E6%8E%A7%E2%80%9C%E6%B2%AA%E5%85%AD%E6%9D%A1%E2%80%9D%E5%85%AC%E5%B8%8310_09-%E5%9B%BD%E8%AF%AD1080P.mp4");
        resultDO =mailService.sendMail(mailDTO);
        Assert.assertTrue(resultDO.isSuccess());

    }


}
