package com.shfc.adviser.ao;

import com.shfc.base.dto.AdvRespDTO;
import com.shfc.base.dto.AdvertisementListDTO;
import com.shfc.base.query.AdvertisementsQuery;
import com.shfc.base.service.AdvertisementService;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-06 13:18
 **/
@Service
public class AdvertisementAO {
    @Autowired
    private AdvertisementService advertisementService;

    public ResultDO<List<AdvertisementListDTO>> queryAdvertisements(AdvertisementsQuery query){
        return advertisementService.queryAdvertisements(query);
    }


    public ResultDO<AdvRespDTO> queryAdvertisement(AdvertisementsQuery query){
        return advertisementService.queryAdvertisement(query);
    }

}
