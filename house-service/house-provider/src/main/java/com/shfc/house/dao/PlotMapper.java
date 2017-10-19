package com.shfc.house.dao;

import com.shfc.house.domain.Plot;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.query.NearbyPlotQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.PlotMapper.java
 * @Description: 小区
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface PlotMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insert(Plot record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(Plot record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.Plot
     * @throws []
     */
    Plot selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(Plot record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(Plot record);

    /**
     * @Description: 根据关键字查询小区
     * @Title queryPlotByKeyword
     * @Author  lv bin
     * @Date 2017/1/3 17:17
     * @param  keyword
     * @return List<PlotAddressDTO>
     * @throws
     */
    List<PlotAddressDTO> queryPlotByKeyword(@Param("keyword")String keyword);

    /**
     * @Description: 根据经纬度获取周边小区
     * @Title queryNearbyPlotGPS
     * @Author  lv bin
     * @Date 2017/1/3 17:17
     * @param  query
     * @return List<PlotAddressDTO>
     * @throws
     */
    List<PlotAddressDTO> queryNearbyPlotGPS(@Param("query") NearbyPlotQuery query);
}