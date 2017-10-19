package com.shfc.house.query;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.query
 * @Description :二手房操作条件
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-22 14:26
 * version V1.0.0
 **/
public class RealtorHouseQuery implements Serializable{

    private static final long serialVersionUID = -141602762485991703L;

    /**
     * 经纪人Id
     */
    private Long realtorId;

    /**
     * 房源Id
     */
    private Long houseId;

    /**
     * 操作类型 0-上架 1-下架 2-删除
     */
    private Integer type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
