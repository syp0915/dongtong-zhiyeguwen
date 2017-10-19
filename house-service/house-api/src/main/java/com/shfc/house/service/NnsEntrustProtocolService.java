package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.dto.*;
import com.shfc.mybatis.pagination.Page;

import java.util.List;

/**
 * @Package com.shfc.house.service.NnsEntrustProtocolService
 * @Description: 委托宝-委托协议
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 17:28
 * version V1.0.0
 */
public interface NnsEntrustProtocolService {
    /**
     * 房源委托协议列表
     * @param realtorId
     * @param page
     * @return
     */
    public Page<NnsHouseEntrustListDTO> houseEntrustList(Long realtorId, Page page);

    /**
     * 房源委托协议详情
     * @param protocolId
     * @return
     */
    public ResultDO<NnsHouseEntrustDetailDTO> houseEntrustDetail(Long protocolId);

    /**
     * 查询该协议的状态流转
     * @param protocolId
     * @return
     */
    List<NnsEntrustWorkflowDTO> entrustWorkflowList(Long protocolId);


    /**
     * 根据协议ID查询协议
     * @param protocolId
     * @return
     */
    NnsEntrustProtocol selectProtocolById(Long protocolId);

    /**
     * 发起签署-获取短信内容
     * @param
     * @return
     */
    public ResultDO<String> sendSignNote(SendSignNoteDTO object);

    /**
     * 过期协议批处理
     * @return
     */
    public List<PastProtocolDTO> updatePastProtocol();
}
