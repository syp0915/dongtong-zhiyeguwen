package com.shfc.adviser.ao;

import com.shfc.base.dto.BaseTagDTO;
import com.shfc.base.service.BaseTagService;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 标签
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-05 15:55
 **/
@Service
public class BaseTagAO {
    @Autowired
    private BaseTagService baseTagService;

    public ResultDO<List<BaseTagDTO>> getFeatureList(String tagType){

        return baseTagService.getFeatureList(tagType);
    }
}
