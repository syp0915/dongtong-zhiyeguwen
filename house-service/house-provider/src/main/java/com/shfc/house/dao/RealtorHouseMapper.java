package com.shfc.house.dao;

import com.shfc.house.domain.RealtorHouse;
import com.shfc.house.dto.RealtorHouseDetailDTO;
import com.shfc.house.dto.RealtorHouseInfoDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.RealtorHouseMapper.java
 * @Description: 经纪人自有二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author syp
 * @date 2017/08/22 09:56
 * version v1.0.0
 */
@Repository
public interface RealtorHouseMapper {
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
    int insert(RealtorHouse record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorHouse record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param id
     * @return com.shfc.house.domain.RealtorHouse
     * @throws []
     */
    RealtorHouse selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorHouse record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author syp
     * @Date 2017/08/22 09:56
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorHouse record);

    RealtorHouse queryHousebyCondition(@Param("plotName") String plotName, @Param("unitNo") String unitNo,@Param("houseNo") String houseNo, @Param("realtorId") Long realtorId);

    /**
     * @Description: 根据编号查询房源
     * @Title findHouseByCode
     * @Author  wuky
     * @Date 2017/8/22 17:02
     * @param  houseCode
     * @return NnsHouse
     * @throws
     */
    RealtorHouse findHouseByCode(@Param("houseCode")String houseCode);

    /**
     * 查询二手房列表
     * @param page
     * @return
     */
    List<RealtorHouseInfoDTO> queryHouseList(Page<RealtorHouseInfoDTO> page,@Param("realtorId") Long realtorId);


    /**
     * 查询房源详情
     * @param houseId
     * @return
     */
    RealtorHouseDetailDTO queryHouseDatail(@Param("houseId") Long houseId,@Param("realtorId") Long realtorId);


    /**
     * 二手房上下架、删除操作
     * @param realtorHouse
     * @return
     */
    int updOperation(RealtorHouse realtorHouse);

}