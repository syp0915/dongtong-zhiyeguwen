package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.HbPrizeRecordDTO;

import java.util.List;

/**
 * @Package com.shfc.house.service.HbPrizeRecordService
 * @Description: 中奖记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/15 上午10:10
 * version V1.0.0
 */
public interface HbPrizeRecordService {
    /**
     * @Description: 查询中奖记录
     * @Title prizeRecordQuery
     * @Author  zhoumin
     * @Date 2017/2/15 10:17
     * @return ResultDO<List<HbPrizeRecordDTO>>
     * @throws
     */
    public ResultDO<List<HbPrizeRecordDTO>> prizeRecordQuery();
}
