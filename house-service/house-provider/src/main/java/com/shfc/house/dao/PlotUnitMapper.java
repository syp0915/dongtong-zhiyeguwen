package com.shfc.house.dao;

import com.shfc.house.domain.PlotUnit;
import com.shfc.house.dto.PlotUnitDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.PlotUnitMapper.java
 * @Description: 小区楼栋表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface PlotUnitMapper {
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
    int insert(PlotUnit record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(PlotUnit record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.PlotUnit
     * @throws []
     */
    PlotUnit selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(PlotUnit record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(PlotUnit record);

    /**
     * @Title: findPlotUnitByPlotId
     * @Description: 根据小区id查询楼栋列表
     * @param @param plotId
     * @param @return    设定文件
     * @return List<PlotUnitBean>    返回类型
     * @throws
     */
    List<PlotUnitDTO> findPlotUnitByPlotId(Long plotId);
}