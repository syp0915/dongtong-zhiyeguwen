package com.shfc.building.query;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/13 下午7:36.
 */
public class RealtorAttentionBuildingListQuery extends BasePageQuery{

    private Long realtorId;

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }
}
