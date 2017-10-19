package com.shfc.house.manager;

import com.shfc.house.dao.LeadsComboMapper;
import com.shfc.house.domain.LeadsCombo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.house.manager.LeadsComboManager
 * @Description: 套餐管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/13 13:50
 * version V1.0.0
 */
@Service
public class LeadsComboManager {
    @Autowired
    private LeadsComboMapper leadsComboMapper;

    /**
     * 主键ID查询套餐
     * @param id
     * @return
     */
    public LeadsCombo select(Long id){
        return leadsComboMapper.selectByPrimaryKey(id);
    }
}
