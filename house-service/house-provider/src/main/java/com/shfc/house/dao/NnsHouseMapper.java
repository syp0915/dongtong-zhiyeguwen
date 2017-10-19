package com.shfc.house.dao;

import com.shfc.house.domain.NnsHouse;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.query.NnsHousePublishQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.NnsHouseMapper.java
 * @Description: 置业顾问二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface NnsHouseMapper {
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
    int insert(NnsHouse record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(NnsHouse record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.NnsHouse
     * @throws []
     */
    NnsHouse selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(NnsHouse record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(NnsHouse record);

    /**
      * @Description: 查询房源是否发布
      * @Title queryNnsHousePublish
      * @Author  lv bin
      * @Date 2017/1/8 10:37
      * @param  query
      * @return Long
      * @throws
      */
    Long queryNnsHousePublish(@Param("query") NnsHousePublishQuery query);

    /**
      * @Description: 根据id查询二手房详情
      * @Title findDetailHouseById
      * @Author  lv bin
      * @Date 2017/1/8 11:54
      * @param  id
      * @return NnsHouseDetailDTO
      * @throws
      */
    NnsHouseDetailDTO findDetailHouseById(Long id);

    /**
      * @Description: 根据编号查询房源
      * @Title findHouseByCode
      * @Author  lv bin
      * @Date 2017/1/10 17:02
      * @param  houseCode
      * @return NnsHouse
      * @throws
      */
    NnsHouse findHouseByCode(@Param("houseCode")String houseCode);

}