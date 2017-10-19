package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.building.domain.BuildingCompanyRel.java
 * @Description: 新房-公司机构官员表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingCompanyRel extends BaseBean {
    /**
     * 楼盘id
     */
    private Long buildingId;

    /**
     * 关联公司机构id
     */
    private Long companyId;

    private Long creator;

    /**
     * 获取楼盘id
     *
     * @return building_id
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置楼盘id
     *
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取关联公司机构id
     *
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置关联公司机构id
     *
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
        sb.append(", companyId=").append(companyId);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}