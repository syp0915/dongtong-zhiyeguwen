package com.shfc.house.dao;

import com.shfc.house.domain.RealtorStoreStaffRel;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.RealtorStoreStaffRelMapper.java
 * @Description: 经纪人门店和经纪人关联表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/01/11 14:59
 * version v1.0.0
 */
@Repository
public interface RealtorStoreStaffRelMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param record
     * @return int
     * @throws []
     */
    int insert(RealtorStoreStaffRel record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorStoreStaffRel record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param id
     * @return com.shfc.house.domain.RealtorStoreStaffRel
     * @throws []
     */
    RealtorStoreStaffRel selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorStoreStaffRel record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/01/11 14:59
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorStoreStaffRel record);
    /**
     * @Description: 根据经纪人Id查询查询经纪人门店关系
     * @Title queryRelByRealtorId
     * @Author wuky
     * @param realtorId
     * @return int
     * @throws []
     */
    RealtorStoreStaffRel queryRelByRealtorId(Long realtorId);
}