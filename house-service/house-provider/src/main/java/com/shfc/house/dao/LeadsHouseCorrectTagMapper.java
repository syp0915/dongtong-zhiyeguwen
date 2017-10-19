package com.shfc.house.dao;

import com.shfc.house.domain.LeadsHouseCorrectTag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsHouseCorrectTagMapper.java
 * @Description: 房源纠错
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:04
 * version v1.1.0
 */
@Repository
public interface LeadsHouseCorrectTagMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsHouseCorrectTag record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsHouseCorrectTag record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param id
     * @return com.shfc.house.domain.LeadsHouseCorrectTag
     * @throws []
     */
    LeadsHouseCorrectTag selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsHouseCorrectTag record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:04
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsHouseCorrectTag record);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int batchInsert(List<LeadsHouseCorrectTag> list);
}