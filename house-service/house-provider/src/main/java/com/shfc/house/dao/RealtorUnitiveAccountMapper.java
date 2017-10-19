package com.shfc.house.dao;

import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.RealtorUnitiveAccountMapper.java
 * @Description: 经纪人/经纪公司/门店统一的账户表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:25
 * version v1.0.0
 */
@Repository
public interface RealtorUnitiveAccountMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int insert(RealtorUnitiveAccount record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorUnitiveAccount record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param id
     * @return com.shfc.house.domain.RealtorUnitiveAccount
     * @throws []
     */
    RealtorUnitiveAccount selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorUnitiveAccount record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorUnitiveAccount record);

    /**
     * 根据手机号查询经纪人
     * @param phone
     * @return
     */
    List<RealtorUnitiveAccount> findByPhone(String phone);
    /**
     * 根据id查询经纪人
     * @param id
     * @return
     */
    RealtorUnitiveAccount queryRealtorById(Long id);


    /**
     * @Description: 根据id获取经纪人状态记录
     * @Title selectByPrimaryKey

     * @param id
     * @throws []
     */
    List<RealtorAccoutStatusDTO> queryStatusById(Long id);
}