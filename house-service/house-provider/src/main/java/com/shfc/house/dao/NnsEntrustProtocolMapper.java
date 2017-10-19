package com.shfc.house.dao;

import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.dto.NnsHouseEntrustDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustListDTO;
import com.shfc.house.dto.PastProtocolDTO;
import com.shfc.mybatis.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.house.dao.NnsEntrustProtocolMapper.java
 * @Description: 委托协议表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
@Repository
public interface NnsEntrustProtocolMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int insert(NnsEntrustProtocol record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(NnsEntrustProtocol record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param id
     * @return com.shfc.house.domain.NnsEntrustProtocol
     * @throws []
     */
    NnsEntrustProtocol selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(NnsEntrustProtocol record);

    /**
     * @Title updateByPrimaryKeyWithBLOBs
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeyWithBLOBs(NnsEntrustProtocol record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(NnsEntrustProtocol record);

    /**
     * 委托宝-房源委托列表
     * @param realtorId
     * @param page
     * @return
     */
    List<NnsHouseEntrustListDTO> houseEntrustList(@Param("realtorId") Long realtorId, Page page);

    /**
     * 委托宝-房源委托详情
     * @param protocolId
     * @return
     */
    NnsHouseEntrustDetailDTO houseEntrustDetail(Long protocolId);

    /**
     * 查询协议
     * @param realtorId
     * @param nnsHouseId
     * @return
     */
    List<Long> selectExistProtocol(@Param("realtorId") Long realtorId,@Param("nnsHouseId") Long nnsHouseId);

    /**
     * 根据用户id获取协议列表
     * @param query
     * @return
     */
    List<HashMap<String, Object>> getEntrustListByUserId(Page<HashMap<String, Object>> query);

    /**
     * 根据协议id获取协议相关信息
     * @param id
     * @return
     */
    HashMap<String, Object> getEntrustInfoById(Long id);

    /**
     * 查询过期的协议
     * @return
     */
    List<PastProtocolDTO> selectPastProtocol();

    /**
     *更新过期协议
     * @param id
     * @return
     */
    int updatePastProtocol(Long id);

    /**
     * 发送签署短信-查询小区名称
     * @param protocolId
     * @return
     */
    String findPlotNameByProtocolId(Long protocolId);

    /**
     * 获取指定房源已签约委托的有效协议数量
     * @param houseId
     * @return
     */
    int getEffectiveEntrustCountByHouseId(Long houseId);
}