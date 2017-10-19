package com.shfc.house.manager;

import com.shfc.house.dao.HbPrizeRecordMapper;
import com.shfc.house.dto.HbPrizeRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.house.manager.PrizeRecordManager
 * @Description: 中奖记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/15 上午10:57
 * version V1.0.0
 */
@Service
public class HbPrizeRecordManager {
    @Autowired
    private HbPrizeRecordMapper hbPrizeRecordMapper;

    public List<HbPrizeRecordDTO> prizeRecordQuery(){
        return hbPrizeRecordMapper.prizeRecordQuery();
    }
}
