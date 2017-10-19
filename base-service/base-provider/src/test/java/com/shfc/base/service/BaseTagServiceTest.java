package com.shfc.base.service;/**
 * @File ${package_name}${file_name}
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @author ${user}
 * @date ${date} ${time}
 * @version V1.0
 */

import com.alibaba.fastjson.JSON;
import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.BaseTagDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 测试用例
 *
 * @author wky
 * @version V1.0
 * @create 2016-12-29 10:47
 **/
public class BaseTagServiceTest extends JunitBaseTest {
    @Autowired
    private BaseTagService baseTagService;

    @Test
    public void testBaseTag() {

        ResultDO<List<BaseTagDTO>> resultDO = baseTagService.getFeatureList("2");
        System.out.println(JSON.toJSONString(resultDO));


    }



  /*  @Test
    public void testAddBaseTag() {
        AddTagBean addTagBean = new AddTagBean();
        addTagBean.setUserId("122");
        addTagBean.setType("20");
        addTagBean.setName("地铁pang");
        addTagBean.setColor("#bf81d6");

        ResultDO<String> resultDO = baseTagService.addCustomTags(addTagBean);

        System.out.println("result:" + resultDO.getData());
    }*/
}
