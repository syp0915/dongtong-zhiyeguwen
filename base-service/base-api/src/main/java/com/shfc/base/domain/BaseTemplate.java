package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseTemplate.java
 * @Description: 楼盘海报模板
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/01 16:16
 * version v1.0.0
 */
public class BaseTemplate extends BaseBean {
    /**
     * 模板标题
     */
    private String telpmateTitle;

    /**
     * 模板图url
     */
    private String templateUrl;

    /**
     * 模板类型：1：新房，2：二手房
     */
    private Integer type;

    /**
     * 模板状态：1：有效，2：无效
     */
    private Integer status;

    /**
     * 模板内容(html)
     */
    private String template;

    /**
     * 获取模板标题
     *
     * @return telpmate_title
     */
    public String getTelpmateTitle() {
        return telpmateTitle;
    }

    /**
     * 设置模板标题
     *
     * @param telpmateTitle
     */
    public void setTelpmateTitle(String telpmateTitle) {
        this.telpmateTitle = telpmateTitle == null ? null : telpmateTitle.trim();
    }

    /**
     * 获取模板图url
     *
     * @return template_url
     */
    public String getTemplateUrl() {
        return templateUrl;
    }

    /**
     * 设置模板图url
     *
     * @param templateUrl
     */
    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl == null ? null : templateUrl.trim();
    }

    /**
     * 获取模板类型：1：新房，2：二手房
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置模板类型：1：新房，2：二手房
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取模板状态：1：有效，2：无效
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置模板状态：1：有效，2：无效
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取模板内容(html)
     *
     * @return template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * 设置模板内容(html)
     *
     * @param template
     */
    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }
}