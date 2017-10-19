package com.shfc.building.dao;

import com.shfc.building.domain.BuildingPic;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.building.dao.BuildingPicMapper.java
 * @Description: 新房图片表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/12 19:28
 * version v1.0.0
 */
@Repository
public interface BuildingPicMapper {
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
    int insert(BuildingPic record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BuildingPic record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param id
     * @return com.shfc.building.domain.BuildingPic
     * @throws []
     */
    BuildingPic selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BuildingPic record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(BuildingPic record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/12 19:28
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BuildingPic record);
}