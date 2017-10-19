package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.AppVersionUpdate.java
 * @Description: app更新信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/13 20:33
 * version v1.0.0
 */
public class AppVersionUpdate extends BaseBean {
    /**
     * 系统类型0-iOS 1-Android
     */
    private Integer osType;

    /**
     * 版本代码
     */
    private Integer versionCode;

    /**
     * 版本号
     */
    private String versionName;

    /**
     * 是否强制更新0-是 1-否
     */
    private Integer isForce;

    private Long creator;

    /**
     * 更新描述
     */
    private String desc;

    /**
     * 安装包下载url
     */
    private String downUrl;

    /**
     * 获取系统类型0-iOS 1-Android
     *
     * @return os_type
     */
    public Integer getOsType() {
        return osType;
    }

    /**
     * 设置系统类型0-iOS 1-Android
     *
     * @param osType
     */
    public void setOsType(Integer osType) {
        this.osType = osType;
    }

    /**
     * 获取版本代码
     *
     * @return version_code
     */
    public Integer getVersionCode() {
        return versionCode;
    }

    /**
     * 设置版本代码
     *
     * @param versionCode
     */
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    /**
     * 获取版本号
     *
     * @return version_name
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 设置版本号
     *
     * @param versionName
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     * 获取是否强制更新0-是 1-否
     *
     * @return is_force
     */
    public Integer getIsForce() {
        return isForce;
    }

    /**
     * 设置是否强制更新0-是 1-否
     *
     * @param isForce
     */
    public void setIsForce(Integer isForce) {
        this.isForce = isForce;
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
     * 获取更新描述
     *
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置更新描述
     *
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 获取安装包下载url
     *
     * @return down_url
     */
    public String getDownUrl() {
        return downUrl;
    }

    /**
     * 设置安装包下载url
     *
     * @param downUrl
     */
    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl == null ? null : downUrl.trim();
    }

    /**
     * @Title toString
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", osType=").append(osType);
        sb.append(", versionCode=").append(versionCode);
        sb.append(", versionName=").append(versionName);
        sb.append(", isForce=").append(isForce);
        sb.append(", creator=").append(creator);
        sb.append(", desc=").append(desc);
        sb.append(", downUrl=").append(downUrl);
        sb.append("]");
        return sb.toString();
    }
}