package com.shfc.base.service;

import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.base.dto.TemplateDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 海报模板服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-01 16:27
 **/
public interface TemplateService {
    /**
     * 海报模板列表
     * @param type
     * @return
     */
    ResultDO<List<TemplateDTO>> templateList(Integer type);

    /**
     * 海报详情
     * @param type
     * @param templateId
     * @return
     */
    TemplateDTO queryTemplate(Long templateId,Long type);

    /**
     * * 添加/修改二手房海报内容
    * @param housePosterDTO
    * @return
    * */
    ResultDO<Long> addHousePoster(HousePosterDTO housePosterDTO);

//    /**
//     * 二手房源生成海报
//     * @param templateId,houseId
//     * @return
//     */
//    ResultDO<TempLateDetailDTO> describeHousePoster(Long templateId, Long houseId);

    /**
     * 添加/修改楼盘海报内容
     * @param buildingPosterDTO
     * @return
     */
    ResultDO<Long> addBuildingPoster(BuildingPosterDTO buildingPosterDTO);


//    /**
//     * 自有楼盘生成海报
//     * @param templateId,houseId
//     * @return
//     */
//    ResultDO<TempLateDetailDTO> describeBuildingPoster(Long templateId, Long buildingId);



}
