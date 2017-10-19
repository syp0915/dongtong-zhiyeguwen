package com.shfc.base.service;


/**
 * @File com.fc.plot.service.VipAccountService.java
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * @author lvbin
 * @date 2016年9月5日 下午6:39:37
 * @version V1.0
 */

import com.shfc.base.dto.BaseTagDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;

public interface BaseTagService {

    /**
     * @Description: 根据类型查询标签
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  tagType
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<List<BaseTagDTO>>  getFeatureList(String tagType);
    //添加二手房/经纪人客户自定义标签
  //  ResultDO<String> addCustomTags(AddTagBean addTagBean);


}
