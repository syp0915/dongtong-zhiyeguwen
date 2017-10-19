package com.shfc.house.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.shfc.house.dto.LeadsHouseCorrectDTO
 * @Description: leads房源纠错
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 9:38
 * version V1.0.0
 */
public class LeadsHouseCorrectDTO implements Serializable{
    private static final long serialVersionUID = 7533171513280870170L;

    /**
     * 房源id
     */
    private Long leadsHouseId;
    /**
     * 标签id
     */
    private List<Long>  tagIds;

    /**
     * 补充说明
     */
    private String content;

    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
