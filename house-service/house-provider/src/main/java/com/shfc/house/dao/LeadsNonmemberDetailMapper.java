package com.shfc.house.dao;

import com.shfc.house.domain.LeadsNonmemberDetail;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsNonmemberDetailMapper.java
 * @Description: 非会员套餐权益表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 16:47
 * version v1.1.0
 */
@Repository
public interface LeadsNonmemberDetailMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsNonmemberDetail record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsNonmemberDetail record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param id
     * @return com.shfc.house.domain.LeadsNonmemberDetail
     * @throws []
     */
    LeadsNonmemberDetail selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsNonmemberDetail record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:47
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsNonmemberDetail record);
    /**
     * 查询今天待生效的非会员权益是否已经生效
     * add by xiehb
     * @return
     */
    int todayAlreadyEffectNonmemberDetail();

    /**
     * 查询今天待生效的非会员权益,取最新的一条记录
     * add by xiehb
     * @return
     */
    int todayEffectNonmemberDetail();
    /**
     * 今天待生效的非会员权益置为“已生效”
     * add by xiehb
     * @return
     */
    int updateTodayEffectNonmemberDetail();
    /**
     * 把已经生效的非会员权益置为“失效”
     * add by xiehb
     * @return
     */
    int updateLoseEffectNonmemberDetail();
}