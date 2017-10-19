package com.shfc.building.dao;

import com.shfc.building.domain.BuildingRealtorAttention;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.building.dao.BuildingRealtorAttentionMapper.java
 * @Description: 新房-经纪人关注表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
@Repository
public interface BuildingRealtorAttentionMapper {
    /**
     * @param id
     * @return int
     * @throws []
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    int insert(BuildingRealtorAttention record);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    int insertSelective(BuildingRealtorAttention record);

    /**
     * @param id
     * @return com.shfc.building.domain.BuildingRealtorAttention
     * @throws []
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    BuildingRealtorAttention selectByPrimaryKey(Long id);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    int updateByPrimaryKeySelective(BuildingRealtorAttention record);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     */
    int updateByPrimaryKey(BuildingRealtorAttention record);

    /**
     * 检查关注是否存在
     *
     * @param realtorId
     * @param buildingId
     * @return
     */
    int checkIsAttentionExist(@Param("realtorId") Long realtorId, @Param("buildingId") Long buildingId);

    /**
     * 取消关注
     *
     * @param realtorId
     * @param buildingId
     * @return
     */
    int cancelAttention(@Param("realtorId") Long realtorId, @Param("buildingId") Long buildingId);
}