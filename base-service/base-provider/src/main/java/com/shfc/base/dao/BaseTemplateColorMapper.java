package com.shfc.base.dao;

import com.shfc.base.domain.BaseTemplateColor;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.base.dao.BaseTemplateColorMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/02 16:43
 * version v1.0.0
 */
@Repository
public interface BaseTemplateColorMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param record
     * @return int
     * @throws []
     */
    int insert(BaseTemplateColor record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BaseTemplateColor record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param id
     * @return com.shfc.base.domain.BaseTemplateColor
     * @throws []
     */
    BaseTemplateColor selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BaseTemplateColor record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BaseTemplateColor record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/08/02 16:43
     * @return null
     * @throws []
     */
    List<BaseTemplateColor> selectByPage(Page<BaseTemplateColor> page);


    /**
     * @Description: 获取模板背景色列表
     * @Title queryTemplateColor
     * @Date 2017/08/02 15:34
     * @return null
     * @throws []
     */
    List<String> queryTemplateColor(@Param("templateId") Long templateId);
}