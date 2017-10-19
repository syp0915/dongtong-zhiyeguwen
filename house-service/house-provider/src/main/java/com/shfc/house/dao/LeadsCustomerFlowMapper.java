package com.shfc.house.dao;

import com.shfc.house.domain.LeadsCustomerFlow;
import com.shfc.house.dto.CustomerDetailDTO;
import com.shfc.house.dto.CustomerFlowDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsCustomerFlowMapper.java
 * @Description: 报备客户状态流表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
@Repository
public interface LeadsCustomerFlowMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsCustomerFlow record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsCustomerFlow record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param id
     * @return com.shfc.house.domain.LeadsCustomerFlow
     * @throws []
     */
    LeadsCustomerFlow selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsCustomerFlow record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsCustomerFlow record);

    /**
     * 根据报备Id查询状态流信息
     * @param reportId
     * @return
     */
    List<CustomerFlowDTO> queryStatusList(Long reportId);
}