package com.shfc.house.dao;

import com.shfc.house.domain.LeadsHouseCorrect;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsHouseCorrectMapper.java
 * @Description: 房源纠错
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 17:24
 * version v1.1.0
 */
@Repository
public interface LeadsHouseCorrectMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsHouseCorrect record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsHouseCorrect record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param id
     * @return com.shfc.house.domain.LeadsHouseCorrect
     * @throws []
     */
    LeadsHouseCorrect selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsHouseCorrect record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 17:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsHouseCorrect record);
}