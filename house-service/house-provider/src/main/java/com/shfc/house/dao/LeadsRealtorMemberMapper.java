package com.shfc.house.dao;

import com.shfc.house.domain.LeadsRealtorMember;
import com.shfc.house.dto.ComboDTO;
import com.shfc.house.dto.InterestDTO;
import com.shfc.house.dto.MemberCentreDTO;
import com.shfc.house.dto.RealtorMemberDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsRealtorMemberMapper.java
 * @Description: 经纪人开通会员表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author zm
 * @date 2017/04/06 16:55
 * version v1.1.0
 */
@Repository
public interface LeadsRealtorMemberMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsRealtorMember record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsRealtorMember record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param id
     * @return com.shfc.house.domain.LeadsRealtorMember
     * @throws []
     */
    LeadsRealtorMember selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsRealtorMember record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author zm
     * @Date 2017/04/06 16:55
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsRealtorMember record);

    LeadsRealtorMember queryStatusByRealtorId(Long realtorId);
    /**
     * 根据经纪人ID查询经纪人是否开通会员
     * @param realtorId
     * @return
     */
    MemberCentreDTO selectByRealtorId(Long realtorId);

    List<ComboDTO> validComboList(Long realtorId);

    /**
     * 查询全部的有效套餐
     * @return
     */
    List<ComboDTO> allComboList();
    /**
     * 每天查询有效的权益
     * @return
     */
    List<InterestDTO> queryInterestByDay();

    /**
     * 查询经纪人开通会员表
     * @param realtorId
     * @return
     */
    LeadsRealtorMember selectUniqueByRealtorId(Long realtorId);

    /**
     * 查询已经到期的会员
     */
    List<RealtorMemberDTO> pastMemberList();
    /**
     * 查询已经到期的会员
     * 并更新到期的会员状态
     * @return
     */
    int updateRealtorMemberList();

    /**
     * 查询还有3天即将过期的会员
     * @return
     */
    List<RealtorMemberDTO> threeDayPastMemberList();
}