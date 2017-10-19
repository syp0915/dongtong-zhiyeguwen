package com.shfc.house.dao;

import com.shfc.house.domain.RealtorHouseTagRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.RealtorHouseTagRelMapper.java
 * @Description: 二手房标签关联表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:56
 * version v1.0.0
 */
@Repository
public interface RealtorHouseTagRelMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int insert(RealtorHouseTagRel record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorHouseTagRel record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param id
     * @return com.shfc.house.domain.RealtorHouseTagRel
     * @throws []
     */
    RealtorHouseTagRel selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorHouseTagRel record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorHouseTagRel record);

    /**
     * @Description: 根据houseId删除标签
     * @Title deleteTagsByHouseId
     * @Author wuky
     * @Date 2017/08/22 09:56
     * @param houseId
     * @return int
     * @throws []
     */
    int deleteTagsByHouseId(@Param("houseId") Long houseId);
}