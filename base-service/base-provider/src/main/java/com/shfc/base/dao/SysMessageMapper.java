package com.shfc.base.dao;

import com.shfc.base.domain.SysMessage;
import com.shfc.base.dto.SysMessageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.user.dao.SysMessageMapper.java
 * @Description: 系统消息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/01/10 19:53
 * version v1.0.0
 */
@Repository
public interface SysMessageMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param record
     * @return int
     * @throws []
     */
    int insert(SysMessage record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(SysMessage record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param id
     * @return com.shfc.user.domain.SysMessage
     * @throws []
     */
    SysMessage selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(SysMessage record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/10 19:53
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(SysMessage record);

    /**
     * 999项目-通知列表
     * @param userId
     * @param userType
     * @return
     */
    List<SysMessageDTO> nnsMessageList(@Param("userId") Long userId, @Param("userType") Integer userType);

    /**
     * 999项目-通知列表_分类列表
     * @param userId
     * @param userType
     * @param mesType
     * @return
     */
    List<SysMessageDTO> nnsMessageClassifyList(@Param("userId") Long userId, @Param("userType") Integer userType, @Param("mesType") Integer mesType);
    /**
     * 999项目-未读消息
     * @param userId
     * @param userType
     * @return
     */
    Integer queryUnreadByRealtorId(@Param("userId") Long userId, @Param("userType") Integer userType);

    /**
     * 999项目-修改未读状态标志
     * @param record
     * @return int
     * @return
     */
    int updateStatusByRealtorId(SysMessage record);


    List<SysMessage> queryByRealtorid(@Param("userId") Long userId, @Param("userType") Integer userType, @Param("mesType") Integer mesType);


}