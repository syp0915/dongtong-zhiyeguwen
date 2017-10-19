package com.shfc.house.dao;

import com.shfc.house.domain.LeadsAddedServices;
import com.shfc.house.dto.ServiceDTO;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.shfc.house.dao.LeadsAddedServicesMapper.java
 * @Description: 增值服务表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/07/11 11:06
 * version v1.0.0
 */
@Repository
public interface LeadsAddedServicesMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param record
     * @return int
     * @throws []
     */
    int insert(LeadsAddedServices record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(LeadsAddedServices record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param id
     * @return com.shfc.house.domain.LeadsAddedServices
     * @throws []
     */
    LeadsAddedServices selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(LeadsAddedServices record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(LeadsAddedServices record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/07/11 11:06
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(LeadsAddedServices record);

    /**
     * @Description: 查询服务详情
     * @Title serviceDetail
     * @Author wuky
     * @Date 2017/07/11 11:06
     * @param serviceId
     * @return int
     * @throws []
     */
    ServiceDTO serviceDetail(Long serviceId);
}