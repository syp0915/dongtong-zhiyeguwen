package com.shfc.base.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-02 13:37
 **/
public class TempLateDetailDTO implements Serializable {
    private String templateTitle;
    private String template;
    private String longitude;
    private String latitude;

    private List<String> bgColor;

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<String> getBgColor() {
        return bgColor;
    }

    public void setBgColor(List<String> bgColor) {
        this.bgColor = bgColor;
    }
}
