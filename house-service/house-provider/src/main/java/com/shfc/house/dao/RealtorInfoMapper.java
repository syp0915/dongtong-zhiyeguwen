package com.shfc.house.dao;

import com.shfc.house.domain.RealtorInfo;
import com.shfc.house.dto.CompanyStoreDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.RealtorInfoMapper.java
 * @Description: 经纪人基本信息表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:25
 * version v1.0.0
 */
@Repository
public interface RealtorInfoMapper {
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
    int insert(RealtorInfo record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(RealtorInfo record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param id
     * @return com.shfc.house.domain.RealtorInfo
     * @throws []
     */
    RealtorInfo selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(RealtorInfo record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:25
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(RealtorInfo record);

    /**
     * 根据门店代码查询公司和门店
     * @param storeCode
     * @return
     */
    public CompanyStoreDTO findCompanyStoreByStoreCode(String storeCode);

    /**
     *  门店代码查询公司和门店详细信息
     * @param storeCode
     * @return
     */
    public List<CompanyStoreDTO> companyStoreInfo(String storeCode);

    /**
     * 根据手机号校验该账户是否被解约过（disable='1'）,并返回comId
     */
    public List <Long> findComIdByPhone(String phone);

    //根据账户ID查询基本信息
    RealtorInfo selectByAccountId(Long accountId);

    /**
     * 展示经纪人个人信息
     * @param realtorId
     * @return
     */
    public RealtorInfoDTO showCompleteInfo(Long realtorId);

    /**
     * 经纪人-我的
     * @param realtorId
     * @return
     */
    public RealtorInfoDTO myInfo(Long realtorId);

    /**
     * 通过经纪人id获取经纪人信息
     * @param realtorId
     */
    public RealtorInfo selectByRealtorId(Long realtorId);

    /**
     *  门店代码查询公司和门店详细信息
     * @param storeId
     * @return
     */
    public List<CompanyStoreDTO> queryStoreById(Long storeId);

    /**
     *  根据名片链接查看是否已使用该名片
     * @param cardImg
     * @return
     */
    public Integer queryCardByUrl(String cardImg);

    public RealtorInfoDTO queryStatusByRealtorId(Long realtorId);


}