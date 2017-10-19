package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.dto.NnsEntrustWorkflowDTO;
import com.shfc.house.dto.NnsHouseEntrustDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustListDTO;
import com.shfc.mybatis.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.NnsEntrustProtocolServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/1/13 上午10:15
 * version V1.0.0
 */
public class NnsEntrustProtocolServiceTest extends JunitBaseTest{
    @Autowired
    private NnsEntrustProtocolService nnsEntrustProtocolService;

    @Test
    public void testHouseEntrustList(){
        Page<NnsHouseEntrustListDTO> page = nnsEntrustProtocolService.houseEntrustList(330L,new Page(1,20));
        Assert.assertNotNull(page);
    }

    @Test
    public void testHouseEntrustDetail(){
        ResultDO<NnsHouseEntrustDetailDTO> resultDO_1 = nnsEntrustProtocolService.houseEntrustDetail(5L);
        Assert.assertNotNull(resultDO_1);

        ResultDO<NnsHouseEntrustDetailDTO> resultDO_2 = nnsEntrustProtocolService.houseEntrustDetail(2L);
        Assert.assertNotNull(resultDO_2);

        ResultDO<NnsHouseEntrustDetailDTO> resultDO_3 = nnsEntrustProtocolService.houseEntrustDetail(1L);
        Assert.assertNotNull(resultDO_3);

        ResultDO<NnsHouseEntrustDetailDTO> resultDO_4 = nnsEntrustProtocolService.houseEntrustDetail(3L);
        Assert.assertNotNull(resultDO_4);
    }

    @Test
    public void testEntrustWorkflowList(){
        List<NnsEntrustWorkflowDTO> list = nnsEntrustProtocolService.entrustWorkflowList(0L);
        Assert.assertNotNull(list);

        List<NnsEntrustWorkflowDTO> list_2 = nnsEntrustProtocolService.entrustWorkflowList(4L);
        Assert.assertNotNull(list_2);
    }

    @Test
    public void testSelectProtocolById(){
        NnsEntrustProtocol nnsEntrustProtocol = nnsEntrustProtocolService.selectProtocolById(1L);
        Assert.assertNotNull(nnsEntrustProtocol);
    }

    @Test
    public void testSendSignNote(){
        //ResultDO<String> resultDO_1 = nnsEntrustProtocolService.sendSignNote(33L);
       // Assert.assertNotNull(resultDO_1);

        //ResultDO<String> resultDO_2 = nnsEntrustProtocolService.sendSignNote(1L);
       // Assert.assertNotNull(resultDO_2);
    }
}
