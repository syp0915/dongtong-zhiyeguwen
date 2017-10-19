package com.shfc.building.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.building.domain.BuildingPic.java
 * @Description: 新房图片表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
public class BuildingPic extends BaseBean {
    /**
     * 图片名称
     */
    private String name;

    /**
     * 关联id
     */
    private Long associateId;

    /**
     * 图片类型0-楼盘图 1-楼栋图 2-户型图 3-房间图
     */
    private Integer bizType;

    /**
     * 一级分类0-规划图 1-效果图 2-样间图 3-配套图 4-位置图 5-实景图
     */
    private Integer catalog1;

    /**
     * 二级分类
     */
    private Integer catalog2;

    /**
     * 逻辑删除0-正常 1-已删除
     */
    private Integer isDelete;

    /**
     * 审核状态0-审核通过 1-审核中 2-审核不通过
     */
    private Integer checkStatus;

    private Integer width;

    private Integer height;

    private BigDecimal coordinateX;

    private BigDecimal coordinateY;

    private Integer picIndex;

    private String pattern;

    /**
     * 创建者
     */
    private Long creator;

    private String picUrl;

    /**
     * 获取图片名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置图片名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取关联id
     *
     * @return associate_id
     */
    public Long getAssociateId() {
        return associateId;
    }

    /**
     * 设置关联id
     *
     * @param associateId
     */
    public void setAssociateId(Long associateId) {
        this.associateId = associateId;
    }

    /**
     * 获取图片类型0-楼盘图 1-楼栋图 2-户型图 3-房间图
     *
     * @return biz_type
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * 设置图片类型0-楼盘图 1-楼栋图 2-户型图 3-房间图
     *
     * @param bizType
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取一级分类0-规划图 1-效果图 2-样间图 3-配套图 4-位置图 5-实景图
     *
     * @return catalog1
     */
    public Integer getCatalog1() {
        return catalog1;
    }

    /**
     * 设置一级分类0-规划图 1-效果图 2-样间图 3-配套图 4-位置图 5-实景图
     *
     * @param catalog1
     */
    public void setCatalog1(Integer catalog1) {
        this.catalog1 = catalog1;
    }

    /**
     * 获取二级分类
     *
     * @return catalog2
     */
    public Integer getCatalog2() {
        return catalog2;
    }

    /**
     * 设置二级分类
     *
     * @param catalog2
     */
    public void setCatalog2(Integer catalog2) {
        this.catalog2 = catalog2;
    }

    /**
     * 获取逻辑删除0-正常 1-已删除
     *
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置逻辑删除0-正常 1-已删除
     *
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取审核状态0-审核通过 1-审核中 2-审核不通过
     *
     * @return check_status
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置审核状态0-审核通过 1-审核中 2-审核不通过
     *
     * @param checkStatus
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * @return width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return coordinate_x
     */
    public BigDecimal getCoordinateX() {
        return coordinateX;
    }

    /**
     * @param coordinateX
     */
    public void setCoordinateX(BigDecimal coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * @return coordinate_y
     */
    public BigDecimal getCoordinateY() {
        return coordinateY;
    }

    /**
     * @param coordinateY
     */
    public void setCoordinateY(BigDecimal coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * @return pic_index
     */
    public Integer getPicIndex() {
        return picIndex;
    }

    /**
     * @param picIndex
     */
    public void setPicIndex(Integer picIndex) {
        this.picIndex = picIndex;
    }

    /**
     * @return pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    /**
     * 获取创建者
     *
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return pic_url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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
        sb.append(", associateId=").append(associateId);
        sb.append(", bizType=").append(bizType);
        sb.append(", catalog1=").append(catalog1);
        sb.append(", catalog2=").append(catalog2);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", coordinateX=").append(coordinateX);
        sb.append(", coordinateY=").append(coordinateY);
        sb.append(", picIndex=").append(picIndex);
        sb.append(", pattern=").append(pattern);
        sb.append(", creator=").append(creator);
        sb.append(", picUrl=").append(picUrl);
        sb.append("]");
        return sb.toString();
    }
}