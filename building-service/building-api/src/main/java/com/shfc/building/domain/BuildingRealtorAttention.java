package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.building.domain.BuildingRealtorAttention.java
 * @Description: 新房-经纪人关注表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingRealtorAttention extends BaseBean {
    /**
     * 被关注楼盘d
     */
    private Long buildingId;

    /**
     * 经纪人id
     */
    private Long realtorId;

    private Long creator;

    private Date moidfyTime;

    /**
     * 获取被关注楼盘d
     *
     * @return building_id
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置被关注楼盘d
     *
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取经纪人id
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人id
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return moidfy_time
     */
    public Date getMoidfyTime() {
        return moidfyTime;
    }

    /**
     * @param moidfyTime
     */
    public void setMoidfyTime(Date moidfyTime) {
        this.moidfyTime = moidfyTime;
    }

    /**
     * @Title toString
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buildingId=").append(buildingId);
        sb.append(", realtorId=").append(realtorId);
        sb.append(", creator=").append(creator);
        sb.append(", moidfyTime=").append(moidfyTime);
        sb.append("]");
        return sb.toString();
    }
}