package com.shfc.house.dao;

import com.shfc.house.domain.LeadsCombo;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsMemberComboMapper.java
 * @Description: 会员套餐表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/10 14:25
 * version v1.1.0
 */
@Repository
public interface LeadsComboMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsCombo record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsCombo record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param id
     * @return com.shfc.house.domain.LeadsMemberCombo
     * @throws []
     */
    LeadsCombo selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsCombo record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/10 14:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsCombo record);

    /**
     * 查询今天待生效的套餐是否已经生效
     * add by xiehb
     * @return
     */
    int selectTodayAlreadyEffectCombo();

    /**
     * 查询今天待生效的套餐,取最新的一条记录
     * add by xiehb
     * @return
     */
    int todayEffectCombo();

    /**
     * 今天待生效的套餐置为“已生效”
     * add by xiehb
     * @return
     */
    int updateTodayEffectCombo();
    /**
     * 把已经生效的套餐置为“失效”
     * add by xiehb
     * @return
     */
    int updateLoseEffectCombo();
}