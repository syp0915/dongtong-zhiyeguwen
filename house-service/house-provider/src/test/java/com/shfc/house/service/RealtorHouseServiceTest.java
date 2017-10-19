package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.dto.RealtorHouseDetailDTO;
import com.shfc.house.dto.RealtorHouseInfoDTO;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.RealtorHouseQuery;
import com.shfc.mybatis.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wuky
 * @version V1.0
 * @create 2017-08-22 15:51
 **/
public class RealtorHouseServiceTest extends JunitBaseTest {

    @Autowired
    private RealtorHouseService realtorHouseService;

    @Test
    public void testAddRealtorHouse(){
        RealtorHouseDTO realtorHouseDTO=new RealtorHouseDTO();
       // realtorHouseDTO.setPlotId(1L);
        realtorHouseDTO.setImportPlotName("祥安1苑");
        realtorHouseDTO.setAddress("祥安路316弄");
        realtorHouseDTO.setDistrictId(310115L);
        realtorHouseDTO.setBlockId(28L);
        realtorHouseDTO.setLongitude("121.821471");
        realtorHouseDTO.setLatitude("30.968626");
        realtorHouseDTO.setUnitNo("12号");
        realtorHouseDTO.setHouseNo("501");
        realtorHouseDTO.setRoom(3);
        realtorHouseDTO.setHall(1);
        realtorHouseDTO.setBathroom(1);
        realtorHouseDTO.setOrientation(1);
        realtorHouseDTO.setFloor(12);
        realtorHouseDTO.setTotalFloor(30);
        realtorHouseDTO.setArea(81.87F);
        //realtorHouseDTO.setTotalPrice(new BigDecimal("400.00"));
        List<Long> tagIds=new ArrayList<>();
        tagIds.add(14L);
        tagIds.add(15L);
        realtorHouseDTO.setTags(tagIds);
        List<String> entrustProtocol=new ArrayList<>();
        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804building-show/2017/08/04/IMG_1501812918240_17274.png");
        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804buiding-show/2017/08/04/IMG_1501813049173_58237.png");
        realtorHouseDTO.setEntrustUrl(entrustProtocol);
        ResultDO<Long> resultDO=realtorHouseService.addRealtorHouse(realtorHouseDTO,210L);
        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testModifyRealtorHouse(){
        RealtorHouseDTO realtorHouseDTO=new RealtorHouseDTO();
        realtorHouseDTO.setHouseId(448L);
        realtorHouseDTO.setImportPlotName("祥安竹苑");
       // realtorHouseDTO.setPlotId(1L);
//        realtorHouseDTO.setAddress("祥安路36弄");
//        realtorHouseDTO.setDistrictId(310115L);
//        realtorHouseDTO.setBlockId(28L);
//        realtorHouseDTO.setLongitude("121.821471");
//        realtorHouseDTO.setLatitude("30.968626");
//        realtorHouseDTO.setUnitNo("10");
//        realtorHouseDTO.setHouseNo("501");
//        realtorHouseDTO.setRoom(3);
//        realtorHouseDTO.setHall(1);
//        realtorHouseDTO.setBathroom(2);
//        realtorHouseDTO.setOrientation(1);
//        realtorHouseDTO.setFloor(12);
//        realtorHouseDTO.setTotalFloor(30);
//        realtorHouseDTO.setArea(81.87F);
       // realtorHouseDTO.setTotalPrice(new BigDecimal("380.00"));
//        List<Long> tagIds=new ArrayList<>();
//        tagIds.add(14L);
//        tagIds.add(15L);
//        realtorHouseDTO.setTags(tagIds);
//        List<String> entrustProtocol=new ArrayList<>();
//        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804building-show/2017/08/04/IMG_1501812918240_17274.png");
//        entrustProtocol.add("http://shfc-img.img-cn-shanghai.aliyuncs.com/other/20170804buiding-show/2017/08/04/IMG_1501813049173_58237.png");
//        realtorHouseDTO.setEntrustUrl(entrustProtocol);
        ResultDO resultDO=realtorHouseService.modifyRealtorHouse(realtorHouseDTO,217L);
        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testRealtorHouseList(){
        BaseQuery baseQuery=new BaseQuery();
        baseQuery.setPageNumber(1);
        baseQuery.setPageSize(10);
        ResultDO<Page<RealtorHouseInfoDTO>> resultDO=realtorHouseService.getRealtorHouseList(baseQuery,217L);
        System.out.println("result------------------>"+JSON.toJSONString(resultDO.getData()));
    }


    @Test
    public void testRealtorHouseDetail(){
        ResultDO<RealtorHouseDetailDTO> resultDO=realtorHouseService.getRealtorHouseDetail(389L,1238L);
        System.out.println("result------------------>"+JSON.toJSONString(resultDO.getData()));
    }

    @Test
    public void testRealtorHouseUpd(){
        RealtorHouseQuery realtorHouseQuery=new RealtorHouseQuery();
        realtorHouseQuery.setHouseId(447L);
        realtorHouseQuery.setRealtorId(217L);
        realtorHouseQuery.setType(0);
        ResultDO<Boolean> resultDO=realtorHouseService.upDownOrDel(realtorHouseQuery);
        System.out.println("result------------------>"+JSON.toJSONString(resultDO.getData()));
    }



}
