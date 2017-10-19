package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsRealtorMember.java
 * @Description: 经纪人开通会员表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 16:55
 * version v1.1.0
 */
public class LeadsRealtorMember extends BaseBean {
    /**
     * 经纪人主键ID
     */
    private Long realtorId;

    /**
     * 会员截止日期
     */
    private Date deadline;

    /**
     * 状态()正常1过期
     */
    private Integer status;

    /**
     * 获取经纪人主键ID
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人主键ID
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取会员截止日期
     *
     * @return deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * 设置会员截止日期
     *
     * @param deadline
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * 获取状态()正常1过期
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态()正常1过期
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/06 16:55
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", realtorId=").append(realtorId);
        sb.append(", deadline=").append(deadline);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}