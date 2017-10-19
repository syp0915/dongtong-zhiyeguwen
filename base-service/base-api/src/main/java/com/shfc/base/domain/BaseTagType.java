package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseTagType.java
 * @Description: 标签类型
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
public class BaseTagType extends BaseBean {
    /**
     * 标签类型名称
     */
    private String tagType;

    /**
     * 获取标签类型名称
     *
     * @return tag_type
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * 设置标签类型名称
     *
     * @param tagType
     */
    public void setTagType(String tagType) {
        this.tagType = tagType == null ? null : tagType.trim();
    }

    /**
     * @Title toString
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagType=").append(tagType);
        sb.append("]");
        return sb.toString();
    }
}