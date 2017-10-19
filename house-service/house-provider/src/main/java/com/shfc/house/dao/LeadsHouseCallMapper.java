package com.shfc.house.dao;

import com.shfc.house.domain.LeadsHouseCall;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsHouseCallMapper.java
 * @Description: 房源拨打记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 14:16
 * version v1.1.0
 */
@Repository
public interface LeadsHouseCallMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsHouseCall record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsHouseCall record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param id
     * @return com.shfc.house.domain.LeadsHouseCall
     * @throws []
     */
    LeadsHouseCall selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsHouseCall record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 14:16
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsHouseCall record);

    /**
     * 查看经纪人是否已拨打过某个房源
     * @param leadsHouseId
     * @param realtorId
     * @return
     */
    LeadsHouseCall findCallByHouseAndRealtorId(@Param("leadsHouseId")Long leadsHouseId, @Param("realtorId")Long realtorId);
}