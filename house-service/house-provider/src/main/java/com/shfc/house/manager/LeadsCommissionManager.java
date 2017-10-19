package com.shfc.house.manager;

import com.shfc.house.dao.LeadsCommissionMapper;
import com.shfc.house.domain.LeadsCommission;
import com.shfc.house.dto.CommissionDTO;
import com.shfc.house.dto.SettlementDetailDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.manager
 * @Description：佣金管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 11:04
 * version V1.0.0
 **/
@Service
public class LeadsCommissionManager {

    @Autowired
    private LeadsCommissionMapper leadsCommissionMapper;


    /**
     * 根据推荐人Id即当前登录经纪人Id按状态分组查询佣金
     * @param referrerId
     * @return
     */
    public List<CommissionDTO> queryCommissionGroupByStatus(Long referrerId){
        return leadsCommissionMapper.queryCommissionGroupByStatus(referrerId);
    }


    /**
     * 根据推荐人Id查询结算明细列表
     * @param settlementDetailDTOPage
     * @return
     */
    public Page<SettlementDetailDTO> querySettlementDetail(Page<SettlementDetailDTO> settlementDetailDTOPage){
        leadsCommissionMapper.querySettlementDetail(settlementDetailDTOPage);
        return settlementDetailDTOPage;
    }

    /**
     * 根据订单编号更新订单状态
     * @param leadsCommission
     * @return
     */
    public int updateStatusByOrderNumber(LeadsCommission leadsCommission){
        return leadsCommissionMapper.updateStatusByOrderNumber(leadsCommission);
    }

    /**
     * 根据订单编号查询对应信息
     * @param orderNmuber
     * @return
     */
    public LeadsCommission queryInfoByOrder(String orderNmuber){
        return leadsCommissionMapper.queryInfoByOrder(orderNmuber);
    }


}
