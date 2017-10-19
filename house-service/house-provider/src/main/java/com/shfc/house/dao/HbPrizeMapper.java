package com.shfc.house.dao;

import com.shfc.house.domain.HbPrize;
import com.shfc.house.dto.HbPrizeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.HbPrizeMapper.java
 * @Description: 奖品表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/14 18:25
 * version v1.0.0
 */
@Repository
public interface HbPrizeMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int insert(HbPrize record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(HbPrize record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param id
     * @return com.shfc.house.domain.HbPrize
     * @throws []
     */
    HbPrize selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(HbPrize record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(HbPrize record);

    /**
     * 查询奖品
     * @return
     */
    List<HbPrizeDTO> prizeList();
}