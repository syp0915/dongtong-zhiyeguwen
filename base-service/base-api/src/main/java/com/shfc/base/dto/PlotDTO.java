package com.shfc.base.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 热门小区
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 09:18
 **/
public class PlotDTO implements Serializable {

    private static final long serialVersionUID = 986479293639472275L;
    private String plotId;
    private String plotName;

    public String getPlotId() {
        return plotId;
    }

    public void setPlotId(String plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }
}
