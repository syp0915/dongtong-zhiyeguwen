package com.shfc.base.dao;

import com.shfc.base.domain.BaseTemplate;
import com.shfc.base.dto.TemplateDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.base.dao.BaseTemplateMapper.java
 * @Description: 楼盘海报模板
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/01 16:16
 * version v1.0.0
 */
@Repository
public interface BaseTemplateMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param record
     * @return int
     * @throws []
     */
    int insert(BaseTemplate record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BaseTemplate record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param id
     * @return com.shfc.base.domain.BaseTemplate
     * @throws []
     */
    BaseTemplate selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BaseTemplate record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(BaseTemplate record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BaseTemplate record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/08/01 16:16
     * @return null
     * @throws []
     */
    List<BaseTemplate> selectByPage(Page<BaseTemplate> page);

    /**
     * @Description: 海报模板列表
     * @Title templateList
     * @Date 2017/08/01 16:16
     * @throws []
     */
    List<TemplateDTO> templateList(@Param("type")Integer type);

    /**
     * @Description: 海报详情
     * @Title queryTemplateById
     * @Date 2017/08/01 16:16
     * @throws []
     */
    TemplateDTO queryTemplateById(@Param("id")Long id,@Param("type") Long type);
}