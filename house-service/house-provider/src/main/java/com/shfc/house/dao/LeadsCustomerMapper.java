package com.shfc.house.dao;

import com.shfc.house.domain.LeadsCustomer;
import com.shfc.house.dto.CustomerDetailDTO;
import com.shfc.house.dto.ReportDetailDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.shfc.house.dao.LeadsCustomerMapper.java
 * @Description: 报备客户表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 10:57
 * version v1.0.0
 */
@Repository
public interface LeadsCustomerMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsCustomer record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsCustomer record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param id
     * @return com.shfc.house.domain.LeadsCustomer
     * @throws []
     */
    LeadsCustomer selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsCustomer record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 10:57
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsCustomer record);


    /**
     * 根据推荐人Id查询报备客户列表
     * @param settlementDetailDTOPage
     * @return
     */
    List<ReportDetailDTO> queryRepostList(Page<ReportDetailDTO> settlementDetailDTOPage);

    /**
     * 根据报备Id查询客户信息
     * @param reportId
     * @return
     */
    CustomerDetailDTO queryCustomerDetail(Long reportId);

    /**
     * 判断报备客户Id是否存在
     * @param reportId
     * @return
     */
    int queryReportIsExist(Long reportId);
    /**
     * 判断报备客户在同一个经纪人,同一个服务下是否已存在
     * @param referrerId
     * @param customerPhone
     * @param serviceId
     * @return
     */
    int isReport(@Param("referrerId") Long referrerId,@Param("customerPhone")String customerPhone,@Param("serviceId")Long serviceId);
}