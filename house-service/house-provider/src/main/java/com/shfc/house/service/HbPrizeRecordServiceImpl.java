package com.shfc.house.service;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.HbPrizeRecordDTO;
import com.shfc.house.manager.HbPrizeRecordManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.house.service.HbPrizeRecordServiceImpl
 * @Description: 中奖记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/15 上午10:00
 * version V1.0.0
 */
@Service
public class HbPrizeRecordServiceImpl implements HbPrizeRecordService {
    @Autowired
    private HbPrizeRecordManager hbPrizeRecordManager;

    public static final Logger LOGGER = Logger.getLogger(PlotServiceImpl.class);

    @Override
    public ResultDO<List<HbPrizeRecordDTO>> prizeRecordQuery(){
        ResultDO<List<HbPrizeRecordDTO>> resultDO = new ResultDO<>();
        try {
            List<HbPrizeRecordDTO> list = hbPrizeRecordManager.prizeRecordQuery();
            for (HbPrizeRecordDTO prizeRecordDTO: list) {
                //电话号码脱敏
                String phone = prizeRecordDTO.getPhone();
                if (!ValidateHelper.isEmptyString(phone)){
                    phone = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
                }
                prizeRecordDTO.setPhone(phone);
            }
            resultDO.setData(list);
            resultDO.setSuccess(true);
        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }
}
