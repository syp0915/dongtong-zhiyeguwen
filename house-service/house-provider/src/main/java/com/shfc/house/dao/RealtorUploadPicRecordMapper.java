package com.shfc.house.dao;

import com.shfc.house.domain.RealtorUploadPicRecord;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.RealtorUploadPicRecordMapper.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/22 14:40
 * version v1.0.0
 */
@Repository
public interface RealtorUploadPicRecordMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param record
     * @return int
     * @throws []
     */
    int insert(RealtorUploadPicRecord record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorUploadPicRecord record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param id
     * @return com.shfc.house.domain.RealtorUploadPicRecord
     * @throws []
     */
    RealtorUploadPicRecord selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorUploadPicRecord record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(RealtorUploadPicRecord record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/03/22 14:40
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorUploadPicRecord record);
}