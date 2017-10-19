package com.shfc.adviser.ao;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.query.NnsHousePublishQuery;
import com.shfc.house.service.NnsHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.adviser.ao.NnsHouseAO
 * @Description: 997房源
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:13
 * version V1.0.0
 */
@Service
public class NnsHouseAO {

    @Autowired
    private NnsHouseService nnsHouseService;

    public ResultDO<Long> queryNnsHousePublish(NnsHousePublishQuery query){
        ResultDO<Long> resultDO = new ResultDO<Long>();
        if(ValidateHelper.isEmpty(query.getPlotId())){
            resultDO.setErrMsg("小区id不能为空");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(query.getUnitNo())){
            resultDO.setErrMsg("楼栋号不能为空");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(query.getRoomNo())){
            resultDO.setErrMsg("门牌号不能为空");
            return resultDO;
        }

        return nnsHouseService.queryNnsHousePublish(query);
    }

    public ResultDO<NnsHouseDetailDTO> findDetailHouseById(Long nnsHouseId){
        ResultDO<NnsHouseDetailDTO> resultDO = new ResultDO<NnsHouseDetailDTO>();
        if(nnsHouseId == null || nnsHouseId.longValue() == 0l){
            resultDO.setErrMsg("二手房id不能为空");
            return resultDO;
        }

        return nnsHouseService.findDetailHouseById(nnsHouseId);
    }

    public ResultDO<Long>

    saveNnsHouseEntrust(NnsHouseEntrustDTO dto){

        return nnsHouseService.saveNnsHouseEntrust(dto);
    }
}
