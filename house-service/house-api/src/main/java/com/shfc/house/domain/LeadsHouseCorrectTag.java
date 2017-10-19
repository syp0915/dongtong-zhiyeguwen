package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsHouseCorrectTag.java
 * @Description: 房源纠错
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:04
 * version v1.1.0
 */
public class LeadsHouseCorrectTag extends BaseBean {
    /**
     * 纠错id
     */
    private Long leadsCorrectId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 获取纠错id
     *
     * @return leads_correct_id
     */
    public Long getLeadsCorrectId() {
        return leadsCorrectId;
    }

    /**
     * 设置纠错id
     *
     * @param leadsCorrectId
     */
    public void setLeadsCorrectId(Long leadsCorrectId) {
        this.leadsCorrectId = leadsCorrectId;
    }

    /**
     * 获取标签id
     *
     * @return tag_id
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置标签id
     *
     * @param tagId
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/06 14:04
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leadsCorrectId=").append(leadsCorrectId);
        sb.append(", tagId=").append(tagId);
        sb.append("]");
        return sb.toString();
    }
}