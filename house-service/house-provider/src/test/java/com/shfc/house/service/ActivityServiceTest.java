package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.HbRunPrizeDTO;
import com.shfc.house.dto.HbWinPrizeDTO;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.house.service.ActivityServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/17 16:19
 * version V1.0.0
 */
public class ActivityServiceTest extends JunitBaseTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void testLoginStatusByOpenId(){
        List<RealtorAccoutStatusDTO> list =  activityService.loginStatusByOpenId("110");
        RealtorAccoutStatusDTO accoutStatusDTO = list.get(0);
        if(accoutStatusDTO!=null)
        System.out.println("testLoginStatusByOpenId========="+accoutStatusDTO.getRealtorId()+"&"+accoutStatusDTO.getPhone()+"&"+accoutStatusDTO.getStatus()+"&"+accoutStatusDTO.getPrizeRecordNum());
    }
    @Test
    public void runPrize(){
        for(int i =0;i<1;i++){
            HbRunPrizeDTO query = new HbRunPrizeDTO();
            query.setWxOpenId("110");
            query.setRealtorId(330L);
            query.setPhone("13816513175");
            ResultDO<HbWinPrizeDTO> resultDO =  activityService.runPrize(query);
            if(resultDO.isSuccess()){
                HbWinPrizeDTO hbWinPrizeDTO = resultDO.getData();
                System.out.println("runPrize======="+ hbWinPrizeDTO.getPrizeId()+"&"+hbWinPrizeDTO.getPrizeName()+"&"+ hbWinPrizeDTO.getPrizeMoney());
            }else {
                System.out.println(resultDO.getErrMsg());
            }
        }
    }
}
