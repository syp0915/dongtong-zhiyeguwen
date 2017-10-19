package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorHouseTagRel.java
 * @Description: 二手房标签关联表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:50
 * version v1.0.0
 */
public class RealtorHouseTagRel extends BaseBean {
    /**
     * 二手房Id
     */
    private Long houseId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 创建人Id
     */
    private Long creator;

    /**
     * 获取二手房Id
     *
     * @return house_id
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * 设置二手房Id
     *
     * @param houseId
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
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
     * 获取创建人Id
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人Id
     *
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }
}