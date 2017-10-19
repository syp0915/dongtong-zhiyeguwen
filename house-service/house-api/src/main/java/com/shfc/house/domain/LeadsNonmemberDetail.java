package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.LeadsNonmemberDetail.java
 * @Description: 非会员套餐权益表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 16:47
 * version v1.1.0
 */
public class LeadsNonmemberDetail extends BaseBean {
    /**
     * 查看房源次数
     */
    private Integer houseNum;

    /**
     * 拨打电话次数
     */
    private Integer phoneNum;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 状态()正常1失效
     */
    private Integer status;

    /**
     * 获取查看房源次数
     *
     * @return house_num
     */
    public Integer getHouseNum() {
        return houseNum;
    }

    /**
     * 设置查看房源次数
     *
     * @param houseNum
     */
    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    /**
     * 获取拨打电话次数
     *
     * @return phone_num
     */
    public Integer getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置拨打电话次数
     *
     * @param phoneNum
     */
    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 获取生效日期
     *
     * @return effective_date
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 设置生效日期
     *
     * @param effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 获取状态()正常1失效
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态()正常1失效
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author zm
     * @Date 2017/04/12 10:04
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", houseNum=").append(houseNum);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}