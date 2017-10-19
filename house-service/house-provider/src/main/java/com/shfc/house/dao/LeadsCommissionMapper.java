package com.shfc.house.dao;

import com.shfc.house.domain.LeadsCommission;
import com.shfc.house.domain.LeadsCustomer;
import com.shfc.house.dto.CommissionDTO;
import com.shfc.house.dto.SettlementDetailDTO;
import com.shfc.house.query.CommissionQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsCommissionMapper.java
 * @Description: 佣金表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
@Repository
public interface LeadsCommissionMapper {
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
    int insert(LeadsCommission record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsCommission record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param id
     * @return com.shfc.house.domain.LeadsCommission
     * @throws []
     */
    LeadsCommission selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsCommission record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsCommission record);

    /**
     * 根据推荐人Id即当前登录经纪人Id按状态分组查询佣金
     * @param referrerId
     * @return
     */
    List<CommissionDTO> queryCommissionGroupByStatus(Long referrerId);

    /**
     * 根据推荐人Id查询结算明细列表
     * @return
     */
    List<SettlementDetailDTO> querySettlementDetail(Page<SettlementDetailDTO> commissionQueryPage);

    /**
     * 根据订单编号更新订单状态
     * @param leadsCommission
     * @return
     */
    int updateStatusByOrderNumber(LeadsCommission leadsCommission);

    /**
     * 根据订单编号查询对应信息
     * @param orderNumber
     * @return
     */
    LeadsCommission queryInfoByOrder(String orderNumber);

}