package com.shfc.building.dao;

import com.shfc.building.domain.Building;
import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.dto.BuildingListBeanDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.building.dao.BuildingMapper.java
 * @Description: 新房表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 20:24
 * version v1.0.0
 */
@Repository
public interface BuildingMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param record
     * @return int
     * @throws []
     */
    int insert(Building record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(Building record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param id
     * @return com.shfc.building.domain.Building
     * @throws []
     */
    Building selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(Building record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(Building record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 20:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(Building record);


    /**
     * 根据条件查找新房列表
     * @param query
     * @return
     */
    List<BuildingListBeanDTO> getBuildingListBycondition(Page<BuildingListBeanDTO> query);

    /**
     * 根据经纪人id查询关注楼盘列表
     * @param query
     * @return
     */
    List<BuildingListBeanDTO> getRealtorAttentionBuildingList(Page<BuildingListBeanDTO> query);

    /**
     * 首页新房推荐
     * @param count
     * @param latitude
     * @param longitude
     * @return
     */
    List<BuildingListBeanDTO> recommendBuilding(@Param("count") Integer count,@Param("latitude") String latitude,
                                                @Param("longitude") String longitude,@Param("buildingIds")List<Long> buildingIds);
    /**
     * 同区域楼盘
     * @param buildingId
     * @return
     */
    List<BuildingListBeanDTO> querySameAreaBuildingByBuildingId(Long buildingId);

    /**
     * 新房基本详情
     * @param buildingId
     * @return
     */
    BuildingBasicDetailDTO queryBuildingDetail(@Param("buildingId") Long buildingId);

    /**
     * 楼盘户型,面积
     * @param buildingId
     * @return
     */
    BuildingDTO queryAreaAndModel(@Param("buildingId") Long buildingId);

}