package com.shfc.base.manager;

import com.shfc.base.dao.SysMessageMapper;
import com.shfc.base.domain.SysMessage;
import com.shfc.base.dto.SysMessageDTO;
import com.shfc.common.exception.AppException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.base.manager.SysMessageManager
 * @Description: 系统消息管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/14 16:34
 * version V1.0.0
 */
@Service
public class SysMessageManager {
    @Autowired
    private SysMessageMapper sysMessageMapper;

    @Transactional(rollbackFor = AppException.class)
    public Long addMessage(SysMessageDTO messageDTO) throws AppException {
        SysMessage record = new SysMessage();
        BeanUtils.copyProperties(messageDTO, record);
        sysMessageMapper.insert(record);
        return record.getId();
    }

    public List<SysMessageDTO> nnsMessageList(Long userId, Integer userType) {
        return sysMessageMapper.nnsMessageList(userId, userType);
    }

    public List<SysMessageDTO> nnsMessageClassifyList(Long userId, Integer userType, Integer mesType) {
        List<SysMessageDTO> list = sysMessageMapper.nnsMessageClassifyList(userId, userType, mesType);
        //修改未读标志
        List<SysMessage> result=sysMessageMapper.queryByRealtorid(userId, userType, mesType);
        for(SysMessage record:result) {
            record.setStatus(1);//已读
            sysMessageMapper.updateStatusByRealtorId(record);
        }
        return list;
    }

    public Integer queryUnreadByRealtorId(Long userId, Integer userType) {
        return sysMessageMapper.queryUnreadByRealtorId(userId, userType);
    }
}
