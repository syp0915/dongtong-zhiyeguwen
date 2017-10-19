package com.shfc.building.manager;

import com.shfc.building.dao.BuildingMapper;
import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.dto.BuildingListBeanDTO;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.building.query.RealtorAttentionBuildingListQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/13 下午6:20.
 */
@Service
public class BuildingManager {

    @Autowired(required = false)
    private BuildingMapper buildingMapper;

    public Page<BuildingListBeanDTO> getBuildingListByCondition(BuildingListQuery params, Integer pageSize, Integer pageNumber){
        Page<BuildingListBeanDTO> query = new Page<>(pageNumber, pageSize);
        query.setQuery(params);
        buildingMapper.getBuildingListBycondition(query);
        return query;
    }

    public Page<BuildingListBeanDTO> getRealtorAttentionBuildingList(RealtorAttentionBuildingListQuery params, Integer pageSize, Integer pageNumber){
        Page<BuildingListBeanDTO> query = new Page<>(pageNumber, pageSize);
        query.setQuery(params);
        buildingMapper.getRealtorAttentionBuildingList(query);
        return query;
    }

    public List<BuildingListBeanDTO> recommendBuilding(Integer count,String latitude, String longitude,List<Long> buildingIds){
        return buildingMapper.recommendBuilding(count,latitude,longitude,buildingIds);
    }

    public BuildingBasicDetailDTO queryBuildingDetail(Long buildingId){
        return buildingMapper.queryBuildingDetail(buildingId);

    }

    public BuildingDTO queryAreaAndModel(Long buildingId){
        return buildingMapper.queryAreaAndModel(buildingId);
    }
}

