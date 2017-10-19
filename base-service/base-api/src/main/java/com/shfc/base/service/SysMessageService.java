package com.shfc.base.service;

import com.shfc.base.dto.SysMessageDTO;
import com.shfc.common.exception.AppException;

import java.util.List;

/**
 * @Package com.shfc.base.service.SysMessageService
 * @Description: 本地消息通知服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/15 12:59
 * version V1.0.0
 */
public interface SysMessageService {
    /**
     * 添加通知
     * @param messageDTO
     * @return
     */
    public Long addMessage(SysMessageDTO messageDTO) throws AppException;
    /**
     * 999项目-通知列表
     * @param userId
     * @param userType
     * @return
     */
    public List<SysMessageDTO> nnsMessageList(Long userId,Integer userType);

    /**
     * 999项目-通知列表_分类列表
     * @param userId
     * @param userType
     * @param mesType
     * @return
     */
    public List<SysMessageDTO>  nnsMessageClassifyList(Long userId,Integer userType,Integer mesType);


    /**
     * 999项目-未读消息
     * @param userId
     * @param userType
     * @return
     */
    public Integer  nnsUnReadMsg(Long userId,Integer userType);
}
