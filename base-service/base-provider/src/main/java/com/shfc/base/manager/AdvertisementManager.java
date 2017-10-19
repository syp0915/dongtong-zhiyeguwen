package com.shfc.base.manager;

import com.shfc.base.dao.BaseAdvertisementMapper;
import com.shfc.base.dto.AdvertisementListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告接口Manager
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 10:01
 **/

@Service
public class AdvertisementManager {

    @Autowired(required = false)
    private BaseAdvertisementMapper baseAdvertisementMapper;

    public List<AdvertisementListDTO> queryAdvertisementsByCondition(String source,String position){
        return baseAdvertisementMapper.queryAdvertisementsByCondition(source,position);
    }
}
