package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.HbPrizeDTO;
import com.shfc.house.dto.HbRunPrizeDTO;
import com.shfc.house.dto.HbWinPrizeDTO;
import com.shfc.house.dto.RealtorAccoutStatusDTO;

import java.util.List;

/**
 * @Package com.shfc.house.service.ActivityService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/15 16:56
 * version V1.0.0
 */
public interface ActivityService {
    /**
     *抽奖前判断经纪人是否登录，根据wxOpenId查找绑定记录，有记录则登录
     * @param wxOpenId
     * @return
     */
    public List<RealtorAccoutStatusDTO> loginStatusByOpenId(String wxOpenId);
    /**
     * 抽奖接口
     * @param query
     * @return
     */
    public ResultDO<HbWinPrizeDTO> runPrize(HbRunPrizeDTO query);
}
