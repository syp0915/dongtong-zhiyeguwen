package com.shfc.house.dao;

import com.shfc.house.domain.NnsEntrustProtocolWorkflow;
import com.shfc.house.dto.NnsEntrustWorkflowDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.NnsEntrustProtocolWorkflowMapper.java
 * @Description: 委托协议状态流转表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
@Repository
public interface NnsEntrustProtocolWorkflowMapper {
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
    int insert(NnsEntrustProtocolWorkflow record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(NnsEntrustProtocolWorkflow record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param id
     * @return com.shfc.house.domain.NnsEntrustProtocolWorkflow
     * @throws []
     */
    NnsEntrustProtocolWorkflow selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(NnsEntrustProtocolWorkflow record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(NnsEntrustProtocolWorkflow record);

    /**
     * 查询该协议的状态流转
     * @param protocolId
     * @return
     */
    List<NnsEntrustWorkflowDTO> entrustWorkflowList(Long protocolId);

    /**
     * 根据协议id获取协议状态列表
     * @param agreementId
     * @return
     */
    List<NnsEntrustProtocolWorkflow> getEntrustListById(Long agreementId);
}