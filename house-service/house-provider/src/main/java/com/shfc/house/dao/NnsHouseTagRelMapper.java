package com.shfc.house.dao;

import com.shfc.house.domain.NnsHouseTagRel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.house.dao.NnsHouseTagRelMapper.java
 * @Description: 置业顾问房源标签关系表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
@Repository
public interface NnsHouseTagRelMapper {
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
    int insert(NnsHouseTagRel record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(NnsHouseTagRel record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param id
     * @return com.shfc.house.domain.NnsHouseTagRel
     * @throws []
     */
    NnsHouseTagRel selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(NnsHouseTagRel record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(NnsHouseTagRel record);

    /**
     * 根据房源id获取标签列表
     * @param houseId
     * @return
     */
    List<HashMap<String, Object>> getTagListByHouseId(Long houseId);
}