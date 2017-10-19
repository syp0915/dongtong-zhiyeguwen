package com.shfc.building.query;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/16 上午10:33.
 */
public class OperateAttentionBuildingListQuery implements Serializable{

    private Long realtorId;

    private Long buildingId;

    private Integer oprType;//0-关注 1-取消

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getOprType() {
        return oprType;
    }

    public void setOprType(Integer oprType) {
        this.oprType = oprType;
    }
}
