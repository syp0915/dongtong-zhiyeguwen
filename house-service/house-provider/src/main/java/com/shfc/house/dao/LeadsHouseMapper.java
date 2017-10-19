package com.shfc.house.dao;

import com.shfc.house.domain.LeadsHouse;
import com.shfc.house.dto.LeadsHouseDTO;
import com.shfc.house.dto.LeadsHouseDateDTO;
import com.shfc.house.dto.LeadsHouseDetailDTO;
import com.shfc.house.dto.LeadsPlotDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsHouseMapper.java
 * @Description: 房源leads二手房
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/04/07 18:11
 * version v1.0.0
 */
@Repository
public interface LeadsHouseMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsHouse record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsHouse record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param id
     * @return com.shfc.house.domain.LeadsHouse
     * @throws []
     */
    LeadsHouse selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsHouse record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/04/07 18:11
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsHouse record);

    /**
     * 推荐的房源
     * @param count
     * @param plotNameList
     * @return
     */
    List<LeadsHouseDTO> recommendLeadsHouse(@Param("count") Integer count, @Param("plotNameList") String plotNameList,
                                            @Param("leadsHouseIds")List<Long> leadsHouseIds);

    /**
     * 查询房源
     * @param page
     * @return
     */
    List<LeadsHouseDTO> queryLeadsHouse(Page<LeadsHouseDTO> page);

    /**
     * 按小区名称或地址检索房源
     * @param keyword
     * @return
     */
    List<LeadsPlotDTO> queryByKeyword(@Param("keyword") String keyword);

    /**
     * 已看过的房源
     * @param page
     * @param realtorId
     * @return
     */
    List<LeadsHouseDateDTO> scanLeadsHouse(Page<LeadsHouseDateDTO> page, @Param("realtorId") Long realtorId);

    /**
     * 已拨打过的房源
     * @param page
     * @param realtorId
     * @return
     */
    List<LeadsHouseDateDTO> callLeadsHouse(Page<LeadsHouseDateDTO> page, @Param("realtorId") Long realtorId);

    /**
     * 获取详情
     * @param id
     * @return
     */
    LeadsHouseDetailDTO getLeadsHouseById(@Param("id") Long id);

    /**
     * 附近的房源
     * @param count
     * @param longitude
     * @param latitude
     * @return
     */
    List<LeadsHouseDTO> nearbyLeadsHouse(@Param("count")Integer count, @Param("longitude")String longitude,
                                         @Param("latitude")String latitude);
}