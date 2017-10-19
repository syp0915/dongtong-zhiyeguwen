package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.building.domain.BuildingCompany.java
 * @Description: 新房公司机构表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingCompany extends BaseBean {
    /**
     * 名称
     */
    private String name;

    /**
     * 房产服务合同编号
     */
    private String compactno;

    /**
     * 0:开发商、1：代理商、2：合作公司
     */
    private Long type;

    /**
     * 电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contactname;

    /**
     * 地址
     */
    private String address;

    private Integer status;

    /**
     * 创建人ID
     */
    private Long creator;

    /**
     * 获取名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取房产服务合同编号
     *
     * @return compactNo
     */
    public String getCompactno() {
        return compactno;
    }

    /**
     * 设置房产服务合同编号
     *
     * @param compactno
     */
    public void setCompactno(String compactno) {
        this.compactno = compactno == null ? null : compactno.trim();
    }

    /**
     * 获取0:开发商、1：代理商、2：合作公司
     *
     * @return type
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置0:开发商、1：代理商、2：合作公司
     *
     * @param type
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 获取电话
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取联系人
     *
     * @return contactName
     */
    public String getContactname() {
        return contactname;
    }

    /**
     * 设置联系人
     *
     * @param contactname
     */
    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    /**
     * 获取地址
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @Title toString
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", compactno=").append(compactno);
        sb.append(", type=").append(type);
        sb.append(", phone=").append(phone);
        sb.append(", contactname=").append(contactname);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}