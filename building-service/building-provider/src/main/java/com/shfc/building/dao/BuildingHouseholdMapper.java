package com.shfc.building.dao;

import com.shfc.building.domain.BuildingHousehold;
import com.shfc.building.dto.HouseTypeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.building.dao.BuildingHouseholdMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
@Repository
public interface BuildingHouseholdMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int insert(BuildingHousehold record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BuildingHousehold record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param id
     * @return com.shfc.building.domain.BuildingHousehold
     * @throws []
     */
    BuildingHousehold selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BuildingHousehold record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(BuildingHousehold record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BuildingHousehold record);

    /**
     * 根据楼盘Id查询对应户型列表
     * @param buildingId
     * @return
     */
    List<HouseTypeDTO> queryHouseTypeList(Long buildingId);
}