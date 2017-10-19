package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorHouseStatusFlow.java
 * @Description: 997房源状态流表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:50
 * version v1.0.0
 */
public class RealtorHouseStatusFlow extends BaseBean {
    /**
     * 房源Id
     */
    private Long houseId;

    /**
     * 状态(1-待审核 2-审核通过 3-审核不通过 4-上架 5-下架 )
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取房源Id
     *
     * @return house_id
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * 设置房源Id
     *
     * @param houseId
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取状态(1-待审核 2-审核通过 3-审核不通过 4-上架 5-下架 )
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(1-待审核 2-审核通过 3-审核不通过 4-上架 5-下架 )
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}