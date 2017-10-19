package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.InterestQueryDTO
 * @Description: 权益查询DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/13 10:01
 * version V1.0.0
 */
public class InterestQueryDTO implements Serializable {
    private Long leadsHouseId;//房源ID

    private Long realtorId;//经纪人ID

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }
}
