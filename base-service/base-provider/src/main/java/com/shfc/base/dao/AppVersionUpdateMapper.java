package com.shfc.base.dao;

import com.shfc.base.domain.AppVersionUpdate;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.base.dao.AppVersionUpdateMapper.java
 * @Description: app更新信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author Jianguo Li
 * @date 2017/06/13 20:33
 * version v1.0.0
 */
@Repository
public interface AppVersionUpdateMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param record
     * @return int
     * @throws []
     */
    int insert(AppVersionUpdate record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(AppVersionUpdate record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param id
     * @return com.shfc.base.domain.AppVersionUpdate
     * @throws []
     */
    AppVersionUpdate selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(AppVersionUpdate record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(AppVersionUpdate record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Jianguo Li
     * @Date 2017/06/13 20:33
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(AppVersionUpdate record);

    /**
     * 根据系统类型查找更新信息
     * @param osType
     * @return
     */
    AppVersionUpdate findByOsType(Integer osType);
}