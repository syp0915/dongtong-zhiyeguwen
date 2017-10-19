package com.shfc.house.dao;

import com.shfc.house.domain.LeadsHouseSee;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsHouseSeeMapper.java
 * @Description: 房源查看记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/04/07 18:11
 * version v1.0.0
 */
@Repository
public interface LeadsHouseSeeMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsHouseSee record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsHouseSee record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param id
     * @return com.shfc.house.domain.LeadsHouseSee
     * @throws []
     */
    LeadsHouseSee selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsHouseSee record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsHouseSee record);
}