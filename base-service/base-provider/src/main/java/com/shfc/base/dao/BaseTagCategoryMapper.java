package com.shfc.base.dao;

import com.shfc.base.domain.BaseTagCategory;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.base.dao.BaseTagCategoryMapper.java
 * @Description: 标签细分
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
@Repository
public interface BaseTagCategoryMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insert(BaseTagCategory record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BaseTagCategory record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return com.shfc.base.domain.BaseTagCategory
     * @throws []
     */
    BaseTagCategory selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BaseTagCategory record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BaseTagCategory record);

}