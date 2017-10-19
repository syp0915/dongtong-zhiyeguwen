package com.shfc.house.dao;

import com.shfc.house.domain.RealtorStore;
import com.shfc.house.dto.RealtorStoreDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.shfc.house.dao.RealtorStoreMapper.java
 * @Description: 经纪公司门店
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/16 13:42
 * version v1.0.0
 */
@Repository
public interface RealtorStoreMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param record
     * @return int
     * @throws []
     */
    int insert(RealtorStore record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorStore record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param id
     * @return com.shfc.house.domain.RealtorStore
     * @throws []
     */
    RealtorStore selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorStore record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/16 13:42
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorStore record);

    /**
     * 根据公司ID查询门店
     * @param map
     * @return
     */
    List<RealtorStore> selectRealtorStoreByCompanyId(Map<String,Object> map);


    /**
     * 根据公司ID查询门店
     * @param page
     * @return
     */
    List<RealtorStoreDTO> queryStoreByKeyword(Page page);

    /**
     * 根据公司ID查询门店
     * @param keyword
     * @param realtorCompanyId
     * @return
     */
    List<RealtorStoreDTO> queryStore(@Param("keyword") String keyword, @Param("realtorCompanyId") Long realtorCompanyId);
    /**
     * 根据店名查找店铺
     * @param storeName
     * @return
     */
    RealtorStore findStoreByName(String storeName);

    /**
     * 查询门店代码中最大值
     * @return
     */
    String selectMaxCode();
}