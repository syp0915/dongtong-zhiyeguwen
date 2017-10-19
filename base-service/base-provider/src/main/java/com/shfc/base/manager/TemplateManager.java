package com.shfc.base.manager;

import com.shfc.base.dao.BaseTemplateColorMapper;
import com.shfc.base.dao.BaseTemplateMapper;
import com.shfc.base.dao.BuildingPosterMapper;
import com.shfc.base.dao.HousePosterMapper;
import com.shfc.base.domain.BuildingPoster;
import com.shfc.base.domain.HousePoster;
import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.base.dto.TemplateDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-01 16:32
 **/
@Service
public class TemplateManager {
    @Autowired
    private BaseTemplateMapper baseTemplateMapper;
    @Autowired
    private HousePosterMapper housePosterMapper;
    @Autowired
    private BuildingPosterMapper buildingPosterMapper;

    @Autowired
    private BaseTemplateColorMapper baseTemplateColorMapper;

    public List<TemplateDTO> templateList(Integer type){
        return baseTemplateMapper.templateList(type);
    }

    public TemplateDTO queryTemplateById(Long id,Long type){
        return baseTemplateMapper.queryTemplateById(id,type);
    }

    public Long addHousePoster(HousePosterDTO housePosterDTO){
        HousePoster housePoster=new HousePoster();
        BeanUtils.copyProperties(housePosterDTO,housePoster);
        housePosterMapper.insert(housePoster);
        return housePoster.getId();
    }

    public Long updateHousePoster(HousePosterDTO housePosterDTO){
        HousePoster housePoster=queryHousePoster(housePosterDTO.getId());
        BeanUtils.copyProperties(housePosterDTO,housePoster);
        housePosterMapper.updateByPrimaryKey(housePoster);
        return housePoster.getId();
    }

    public HousePoster queryHousePoster(Long id){
        return housePosterMapper.selectByPrimaryKey(id);
    }

    public Long addBuildingPoster(BuildingPosterDTO buildingPosterDTO){
        BuildingPoster buildingPoster=new BuildingPoster();
        BeanUtils.copyProperties(buildingPosterDTO,buildingPoster);
        buildingPosterMapper.insert(buildingPoster);
        return buildingPoster.getId();
    }

    public Long updateBuildingPoster(BuildingPosterDTO buildingPosterDTO){
        BuildingPoster buildingPoster=queryBuildingPoster(buildingPosterDTO.getId());
        BeanUtils.copyProperties(buildingPosterDTO,buildingPoster);
        buildingPosterMapper.updateByPrimaryKey(buildingPoster);
        return buildingPoster.getId();
    }

    public BuildingPoster queryBuildingPoster(Long id){
        return buildingPosterMapper.selectByPrimaryKey(id);
    }


//    public List<String> tempColorList(Long templateId){
//        return baseTemplateColorMapper.queryTemplateColor(templateId);
//    }
}
