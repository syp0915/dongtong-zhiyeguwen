package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseTemplateColor.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/02 16:43
 * version v1.0.0
 */
public class BaseTemplateColor extends BaseBean {
    /**
     * 模板Id
     */
    private Long templateId;

    /**
     * 模板背景色
     */
    private String templateColor;

    /**
     * 获取模板Id
     *
     * @return template_id
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板Id
     *
     * @param templateId
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取模板背景色
     *
     * @return template_color
     */
    public String getTemplateColor() {
        return templateColor;
    }

    /**
     * 设置模板背景色
     *
     * @param templateColor
     */
    public void setTemplateColor(String templateColor) {
        this.templateColor = templateColor == null ? null : templateColor.trim();
    }
}