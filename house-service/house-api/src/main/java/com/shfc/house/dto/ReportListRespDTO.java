package com.shfc.house.dto;

import com.shfc.house.base.BaseRespBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description :报备列表响应参数
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 15:46
 * version V1.0.0
 **/
public class ReportListRespDTO extends BaseRespBean implements Serializable{

    private static final long serialVersionUID = 1002658955982647905L;

    /**
     * 报备列表
     */
    private List<ReportDetailDTO> reportDetailList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ReportDetailDTO> getReportDetailList() {
        return reportDetailList;
    }

    public void setReportDetailList(List<ReportDetailDTO> reportDetailList) {
        this.reportDetailList = reportDetailList;
    }
}
