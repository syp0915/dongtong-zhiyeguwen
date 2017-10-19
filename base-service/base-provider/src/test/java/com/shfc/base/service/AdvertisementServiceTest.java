package com.shfc.base.service;

import com.alibaba.fastjson.JSON;
import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.AdvertisementListDTO;
import com.shfc.base.query.AdvertisementsQuery;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 10:17
 **/
public class AdvertisementServiceTest extends JunitBaseTest {
    @Autowired
    private AdvertisementService advertisementService;

    @Test
    public void testAdvertisementService(){
        AdvertisementsQuery queryAdvertisements=new AdvertisementsQuery();
        queryAdvertisements.setSource("4");//
        queryAdvertisements.setPosition("1");
        ResultDO<List<AdvertisementListDTO>> resultDO=advertisementService.queryAdvertisements(queryAdvertisements);
        System.out.println(JSON.toJSON(resultDO));

    }


}
