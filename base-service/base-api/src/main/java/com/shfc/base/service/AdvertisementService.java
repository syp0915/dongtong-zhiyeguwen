package com.shfc.base.service;

import com.shfc.base.dto.AdvRespDTO;
import com.shfc.base.dto.AdvertisementListDTO;
import com.shfc.base.query.AdvertisementsQuery;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *广告
 * @author wky
 * @version V1.0
 * @create 2017-01-04 10:04
 **/
public interface AdvertisementService {

    /**
     * @Description: 根据条件查询广告信息
     * @Title queryAdvertisements
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  query
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<List<AdvertisementListDTO>> queryAdvertisements(AdvertisementsQuery query);

    /**
     * @Description: 兼容3.0
     * @Title queryAdvertisement
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  query
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<AdvRespDTO> queryAdvertisement(AdvertisementsQuery query);



}
