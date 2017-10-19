package com.shfc.house.dao;

import com.shfc.house.domain.RealtorHouseEntrustProtocol;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.RealtorHouseEntrustProtocolMapper.java
 * @Description: 997房源委托表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:56
 * version v1.0.0
 */
@Repository
public interface RealtorHouseEntrustProtocolMapper {
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
    int insert(RealtorHouseEntrustProtocol record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorHouseEntrustProtocol record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param id
     * @return com.shfc.house.domain.RealtorHouseEntrustProtocol
     * @throws []
     */
    RealtorHouseEntrustProtocol selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorHouseEntrustProtocol record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorHouseEntrustProtocol record);

    /**
     * @Description: 根据houseId删除房源委托协议链接
     * @Title deleteEntrustUrlByHouseId
     * @Author wuky
     * @Date 2017/08/22 09:56
     * @param houseId
     * @return int
     * @throws []
     */
    int deleteEntrustUrlByHouseId(@Param("houseId") Long houseId);
}