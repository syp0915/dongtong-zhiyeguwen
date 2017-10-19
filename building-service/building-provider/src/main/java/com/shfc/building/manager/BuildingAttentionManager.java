package com.shfc.building.manager;

import com.shfc.building.dao.BuildingRealtorAttentionMapper;
import com.shfc.building.domain.BuildingRealtorAttention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/16 上午10:59.
 */
@Service
public class BuildingAttentionManager {

    @Autowired(required = false)
    private BuildingRealtorAttentionMapper buildingRealtorAttentionMapper;

    /**
     * 检查关注是否存在
     * @param realtorId
     * @param buildingId
     * @return
     */
    public boolean checkIsAttentionExist(Long realtorId, Long buildingId){
        return buildingRealtorAttentionMapper.checkIsAttentionExist(realtorId, buildingId) > 0;
    }

    /**
     * 取消关注
     * @param realtorId
     * @param buildingId
     * @return
     */
    public boolean cancelAttention(Long realtorId, Long buildingId){
        return buildingRealtorAttentionMapper.cancelAttention(realtorId, buildingId) > 0;
    }

    /**
     * 设置关注
     * @param realtorId
     * @param buildingId
     * @return
     */
    public boolean setAttention(Long realtorId, Long buildingId){
        BuildingRealtorAttention buildingRealtorAttention = new BuildingRealtorAttention();
        buildingRealtorAttention.setBuildingId(buildingId);
        buildingRealtorAttention.setRealtorId(realtorId);
        return buildingRealtorAttentionMapper.insert(buildingRealtorAttention) > 0;
    }
}
