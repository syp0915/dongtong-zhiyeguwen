package com.shfc.base.service;

import com.alibaba.fastjson.JSON;
import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.AliyunSTSRespDTO;
import com.shfc.base.dto.AppUpdateRespDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/19 上午10:50.
 */
public class AppServiceTest extends JunitBaseTest {

    @Autowired(required = false)
    private AppService appService;

    @Test
    public void testQueryAppUpdate(){
        ResultDO<AppUpdateRespDTO> resultDO = appService.queryAppUpdate(0, "v2.0.0");
        System.out.println("result------------>" + JSON.toJSONString(resultDO));
    }

    @Test
    public void testGetAliyunTokenInfo(){
        ResultDO<AliyunSTSRespDTO> resultDO = appService.getAliyunTokenInfo("android");
        System.out.println("result------------>" + JSON.toJSONString(resultDO));
    }
}
