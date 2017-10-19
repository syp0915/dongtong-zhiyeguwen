package com.shfc.house.dao;

import com.shfc.house.domain.NnsProtocolRejectCancel;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.NnsProtocolRejectCancelMapper.java
 * @Description: 委托协议拒签/撤销
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
@Repository
public interface NnsProtocolRejectCancelMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int insert(NnsProtocolRejectCancel record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(NnsProtocolRejectCancel record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param id
     * @return com.shfc.house.domain.NnsProtocolRejectCancel
     * @throws []
     */
    NnsProtocolRejectCancel selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(NnsProtocolRejectCancel record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(NnsProtocolRejectCancel record);
}