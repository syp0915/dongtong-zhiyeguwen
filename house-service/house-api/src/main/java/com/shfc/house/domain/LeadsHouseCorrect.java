package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsHouseCorrect.java
 * @Description: 房源纠错
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 17:24
 * version v1.1.0
 */
public class LeadsHouseCorrect extends BaseBean {
    /**
     * 房源id
     */
    private Long leadsHouseId;

    /**
     * 纠错内容
     */
    private String content;

    /**
     * 审核状态0-待审核 1-审核通过 2-审核不通过
     */
    private Integer auditStatus;

    /**
     * 审核内容
     */
    private String auditContent;

    /**
     * 审核人id
     */
    private Long auditId;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 获取房源id
     *
     * @return leads_house_id
     */
    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    /**
     * 设置房源id
     *
     * @param leadsHouseId
     */
    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }

    /**
     * 获取纠错内容
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置纠错内容
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取审核状态0-待审核 1-审核通过 2-审核不通过
     *
     * @return audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态0-待审核 1-审核通过 2-审核不通过
     *
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核内容
     *
     * @return audit_content
     */
    public String getAuditContent() {
        return auditContent;
    }

    /**
     * 设置审核内容
     *
     * @param auditContent
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    /**
     * 获取审核人id
     *
     * @return audit_id
     */
    public Long getAuditId() {
        return auditId;
    }

    /**
     * 设置审核人id
     *
     * @param auditId
     */
    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/06 17:24
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leadsHouseId=").append(leadsHouseId);
        sb.append(", content=").append(content);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditContent=").append(auditContent);
        sb.append(", auditId=").append(auditId);
        sb.append(", auditTime=").append(auditTime);
        sb.append("]");
        return sb.toString();
    }
}