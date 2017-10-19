package com.shfc.house.dao;

import com.shfc.house.domain.PlotPrice;
import com.shfc.house.dto.PlotPriceDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.PlotPriceMapper.java
 * @Description: 小区/板块/区县/城市/交易趋势
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface PlotPriceMapper {
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
    int insert(PlotPrice record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(PlotPrice record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.PlotPrice
     * @throws []
     */
    PlotPrice selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(PlotPrice record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(PlotPrice record);

    /**
     * @Title: findPlotPrice
     * @Description: 查询成交行情
     * @param @param bean
     * @param @return    设定文件
     * @return PlotPrice    返回类型
     * @throws
     */
    PlotPrice findPlotPrice(@Param("query")PlotPrice plotPrice);

    /**
     * @Title: queryPlotPrice
     * @Description: 查询成交行情
     * @param @param bean
     * @param @return    设定文件
     * @return List<PlotPriceDTO>    返回类型
     * @throws
     */
    List<PlotPriceDTO> queryPlotPrice(@Param("query")PlotPriceDTO bean, @Param("month")String month, @Param("count")int count);
}