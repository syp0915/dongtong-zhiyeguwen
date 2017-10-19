package com.shfc.house.dto;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description :报备列表详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 15:32
 * version V1.0.0
 **/
public class ReportDetailDTO  extends PersonalDTO implements Serializable{

    private static final long serialVersionUID = 6191814346570029722L;


    /**
     * 报备记录Id
     */
    private Long reportId;


    /**
     * 客户状态
     */
    private Integer customerStatus;


    /**
     * 佣金奖励
     */
    private String commissionAward;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCommissionAward() {
        return commissionAward;
    }

    public void setCommissionAward(String commissionAward) {
        this.commissionAward = commissionAward;
    }
}
