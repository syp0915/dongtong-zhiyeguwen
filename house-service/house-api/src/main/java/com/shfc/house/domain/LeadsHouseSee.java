package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsHouseSee.java
 * @Description: 房源查看记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/04/07 18:11
 * version v1.0.0
 */
public class LeadsHouseSee extends BaseBean {
    /**
     * 二手房id
     */
    private Long leadsHouseId;

    /**
     * 经纪人id
     */
    private Long realtorId;

    public LeadsHouseSee() {
    }

    public LeadsHouseSee(Long leadsHouseId, Long realtorId, Long creater) {
        this.leadsHouseId = leadsHouseId;
        this.realtorId = realtorId;
        super.setCreater(creater);
    }

    /**
     * 获取二手房id
     *
     * @return leads_house_id
     */
    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    /**
     * 设置二手房id
     *
     * @param leadsHouseId
     */
    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
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
     * @Title toString
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leadsHouseId=").append(leadsHouseId);
        sb.append(", realtorId=").append(realtorId);
        sb.append("]");
        return sb.toString();
    }
}