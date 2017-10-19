package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.LeadsAddedServices.java
 * @Description: 增值服务表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 11:06
 * version v1.0.0
 */
public class LeadsAddedServices extends BaseBean {
    /**
     * bannerId
     */
    private Long bannerId;

    /**
     * 服务名称
     */
    private String servicesName;

    /**
     * 产品类型(0-贷款、1-理财、2-装修、3-保险、4-其它)
     */
    private Integer type;

    /**
     * 佣金奖励
     */
    private String commission;

    /**
     * 奖励条件
     */
    private String conditional;

    /**
     * 所属公司ID
     */
    private Long merchanismId;

    private Long creator;

    /**
     * 服务文案
     */
    private String servicesOfficial;

    /**
     * 获取bannerId
     *
     * @return banner_id
     */
    public Long getBannerId() {
        return bannerId;
    }

    /**
     * 设置bannerId
     *
     * @param bannerId
     */
    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * 获取服务名称
     *
     * @return services_name
     */
    public String getServicesName() {
        return servicesName;
    }

    /**
     * 设置服务名称
     *
     * @param servicesName
     */
    public void setServicesName(String servicesName) {
        this.servicesName = servicesName == null ? null : servicesName.trim();
    }

    /**
     * 获取产品类型(0-贷款、1-理财、2-装修、3-保险、4-其它)
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置产品类型(0-贷款、1-理财、2-装修、3-保险、4-其它)
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取佣金奖励
     *
     * @return commission
     */
    public String getCommission() {
        return commission;
    }

    /**
     * 设置佣金奖励
     *
     * @param commission
     */
    public void setCommission(String commission) {
        this.commission = commission == null ? null : commission.trim();
    }

    /**
     * 获取奖励条件
     *
     * @return conditional
     */
    public String getConditional() {
        return conditional;
    }

    /**
     * 设置奖励条件
     *
     * @param conditional
     */
    public void setConditional(String conditional) {
        this.conditional = conditional == null ? null : conditional.trim();
    }

    /**
     * 获取所属公司ID
     *
     * @return merchanism_id
     */
    public Long getMerchanismId() {
        return merchanismId;
    }

    /**
     * 设置所属公司ID
     *
     * @param merchanismId
     */
    public void setMerchanismId(Long merchanismId) {
        this.merchanismId = merchanismId;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取服务文案
     *
     * @return services_official
     */
    public String getServicesOfficial() {
        return servicesOfficial;
    }

    /**
     * 设置服务文案
     *
     * @param servicesOfficial
     */
    public void setServicesOfficial(String servicesOfficial) {
        this.servicesOfficial = servicesOfficial == null ? null : servicesOfficial.trim();
    }
}