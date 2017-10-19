package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsHouseOperate.java
 * @Description: 房源操作记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:15
 * version v1.1.0
 */
public class LeadsHouseOperate extends BaseBean {
    /**
     * 管理员操作人id
     */
    private Long adminId;

    /**
     * 房源leads二手房id
     */
    private Long leadsHouseId;

    /**
     * 房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    private Integer leadsHouseStatus;

    /**
     * 编辑会后房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     */
    private Integer editStatus;

    /**
     * 操作内容
     */
    private String operateContent;

    /**
     * 获取管理员操作人id
     *
     * @return admin_id
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员操作人id
     *
     * @param adminId
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取房源leads二手房id
     *
     * @return leads_house_id
     */
    public Long getLeadsHouseId() {
        return leadsHouseId;
    }

    /**
     * 设置房源leads二手房id
     *
     * @param leadsHouseId
     */
    public void setLeadsHouseId(Long leadsHouseId) {
        this.leadsHouseId = leadsHouseId;
    }

    /**
     * 获取房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     *
     * @return leads_house_status
     */
    public Integer getLeadsHouseStatus() {
        return leadsHouseStatus;
    }

    /**
     * 设置房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     *
     * @param leadsHouseStatus
     */
    public void setLeadsHouseStatus(Integer leadsHouseStatus) {
        this.leadsHouseStatus = leadsHouseStatus;
    }

    /**
     * 获取编辑会后房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     *
     * @return edit_status
     */
    public Integer getEditStatus() {
        return editStatus;
    }

    /**
     * 设置编辑会后房源状态(0-待审核、1-有效、2-已售、3-暂缓、4-未知、5-房源无效、6-电话无效)
     *
     * @param editStatus
     */
    public void setEditStatus(Integer editStatus) {
        this.editStatus = editStatus;
    }

    /**
     * 获取操作内容
     *
     * @return operate_content
     */
    public String getOperateContent() {
        return operateContent;
    }

    /**
     * 设置操作内容
     *
     * @param operateContent
     */
    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/06 14:15
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", leadsHouseId=").append(leadsHouseId);
        sb.append(", leadsHouseStatus=").append(leadsHouseStatus);
        sb.append(", editStatus=").append(editStatus);
        sb.append(", operateContent=").append(operateContent);
        sb.append("]");
        return sb.toString();
    }
}