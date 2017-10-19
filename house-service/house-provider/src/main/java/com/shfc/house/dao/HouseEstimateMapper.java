package com.shfc.house.dao;

import com.shfc.house.domain.HouseEstimate;
import com.shfc.house.query.HouseEstimateQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.HouseEstimateMapper.java
 * @Description: 房源估价
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface HouseEstimateMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insert(HouseEstimate record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(HouseEstimate record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.HouseEstimate
     * @throws []
     */
    HouseEstimate selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(HouseEstimate record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(HouseEstimate record);

    /**
     * @Description: 查询近期估价15天
     * @Title queryRecentEstimate
     * @Author  lv bin
     * @Date 2016/9/28 15:39
     * @param  query
     * @return com.fc.house.domain.HouseEstimate
     * @throws
     */
    HouseEstimate queryRecentEstimate(@Param("query") HouseEstimateQuery query);
}