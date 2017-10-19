package com.shfc.base.dao;

import com.shfc.base.domain.HousePoster;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.base.dao.HousePosterMapper.java
 * @Description: 二手房海报内容
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/08/02 10:11
 * version v1.0.0
 */
@Repository
public interface HousePosterMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param record
     * @return int
     * @throws []
     */
    int insert(HousePoster record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(HousePoster record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param id
     * @return com.shfc.base.domain.HousePoster
     * @throws []
     */
    HousePoster selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(HousePoster record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(HousePoster record);

    /**
     * @Description: 分页获取全部数据库记录
     * @Title selectByPage
     * @Author liaozm
     * @Date 2017/08/02 10:11
     * @return null
     * @throws []
     */
    List<HousePoster> selectByPage(Page<HousePoster> page);
}