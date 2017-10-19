package com.shfc.house.dao;

import com.shfc.house.domain.LeadsComboDetail;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsComboDetailMapper.java
 * @Description: 会员套餐权益表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 16:41
 * version v1.1.0
 */
@Repository
public interface LeadsComboDetailMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsComboDetail record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsComboDetail record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param id
     * @return com.shfc.house.domain.LeadsComboDetail
     * @throws []
     */
    LeadsComboDetail selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsComboDetail record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:41
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsComboDetail record);

    /**
     * 查询今天待生效的套餐权益是否已经生效
     * add by xiehb
     * @return
     */
    int selectTodayAlreadyEffectComboDetail();

    /**
     * 查询今天待生效的套餐权益,取最新的一条记录
     * add by xiehb
     * @return
     */
    int todayEffectComboDetail();

    /**
     * 今天待生效的套餐权益置为“已生效”
     * add by xiehb
     * @return
     */
    int updateTodayEffectComboDetail();
    /**
     * 把已经生效的套餐权益置为“失效”
     * add by xiehb
     * @return
     */
    int updateLoseEffectComboDetail();
}