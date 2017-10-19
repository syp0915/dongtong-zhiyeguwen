package com.shfc.house.dao;

import com.shfc.house.domain.WxAccountRelation;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import com.shfc.house.dto.WxOpenBindingRecordDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.WxOpenBindingRecordMapper.java
 * @Description: 微信公众号绑定关系表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/02/14 18:25
 * version v1.0.0
 */
@Repository
public interface WxAccountRelationMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int insert(WxAccountRelation record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(WxAccountRelation record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param id
     * @return com.shfc.house.domain.WxOpenBindingRecord
     * @throws []
     */
    WxAccountRelation selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(WxAccountRelation record);
    /**
     * @Description: 根据accountId来更新对应数据库字段
     * @Title updateBindRecordByaccountId
     * @Author wuky
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int updateBindRecordByaccountId(WxAccountRelation record);


    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(WxAccountRelation record);

    /**
     * @Description: 根据openId获取数据库记录
     * @Title selectByPrimaryKey
     * @Author xiehb
     * @Date 2017/02/14 18:25
     * @param wxopenId
     * @return com.shfc.house.domain.WxOpenBindingRecord
     * @throws []
     */
    List<WxAccountRelation> queryByOpenId(String wxopenId);

    /**
     * @Description: 根据账号获取数据库记录

     * @param accountId
     * @throws []
     */
    List<WxAccountRelation> queryBingRecordByaccountId(Long accountId);

    /**
     * @Description: 根据realtorId 查询微信信息
     * @Title selectByPrimaryKey
     * @Author zhoumin
     * @Date 2017/02/17 09:08
     * @param realtorId
     * @return com.shfc.house.domain.WxOpenBindingRecord
     * @throws []
     */
    WxOpenBindingRecordDTO queryWxInfo(Long realtorId);
    /**
     * 抽奖前判断经纪人是否登录，根据wxOpenId查找绑定记录，有记录经纪人账户已登录
     * @param wxOpenId
     * @return
     */
    List<RealtorAccoutStatusDTO> loginStatusByOpenId(String wxOpenId);
}