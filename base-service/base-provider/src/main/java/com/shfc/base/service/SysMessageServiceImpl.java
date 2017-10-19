package com.shfc.base.service;

import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.manager.SysMessageManager;
import com.shfc.common.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.base.service.SysMessageServiceImpl
 * @Description: 本地 通知服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/15 13:24
 * version V1.0.0
 */
@Service
public class SysMessageServiceImpl implements SysMessageService {
    @Autowired
    private SysMessageManager sysMessageManager;

    @Override
    public Long addMessage(SysMessageDTO messageDTO) throws AppException {
        return sysMessageManager.addMessage(messageDTO);
    }
    @Override
    public List<SysMessageDTO> nnsMessageList(Long userId, Integer userType) {
        return sysMessageManager.nnsMessageList(userId,userType);
    }

    @Override
    public List<SysMessageDTO> nnsMessageClassifyList(Long userId, Integer userType, Integer mesType) {
        return sysMessageManager.nnsMessageClassifyList(userId,userType,mesType);
    }

    @Override
    public Integer nnsUnReadMsg(Long userId, Integer userType) {
        return sysMessageManager.queryUnreadByRealtorId(userId,userType);
    }
}
