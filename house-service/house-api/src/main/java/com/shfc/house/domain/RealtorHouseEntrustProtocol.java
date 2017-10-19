package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorHouseEntrustProtocol.java
 * @Description: 997房源委托表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:50
 * version v1.0.0
 */
public class RealtorHouseEntrustProtocol extends BaseBean {
    /**
     * 房源id
     */
    private Long houseId;

    /**
     * 协议url
     */
    private String protocolUrl;

    /**
     * 协议来源（1：经纪人直签，2：线上授权）
     */
    private Integer source;

    /**
     * 是否删除（1：否，2：是）
     */
    private Integer isDelete;

    /**
     * 获取房源id
     *
     * @return house_id
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * 设置房源id
     *
     * @param houseId
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取协议url
     *
     * @return protocol_url
     */
    public String getProtocolUrl() {
        return protocolUrl;
    }

    /**
     * 设置协议url
     *
     * @param protocolUrl
     */
    public void setProtocolUrl(String protocolUrl) {
        this.protocolUrl = protocolUrl == null ? null : protocolUrl.trim();
    }

    /**
     * 获取协议来源（1：经纪人直签，2：线上授权）
     *
     * @return source
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置协议来源（1：经纪人直签，2：线上授权）
     *
     * @param source
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取是否删除（1：否，2：是）
     *
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除（1：否，2：是）
     *
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}