package com.shfc.building.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.building.dto
 * @Description ：标签
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-13 15:43
 * version V1.0.0
 **/
public class BaseTagDTO implements Serializable{

    /**
     * 标签Id
     */
    private Long tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签颜色
     */
    private String tagColor;


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }
}
