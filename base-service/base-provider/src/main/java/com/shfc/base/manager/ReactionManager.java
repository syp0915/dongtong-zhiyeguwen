package com.shfc.base.manager;

import com.shfc.base.dao.BaseRetroactionMapper;
import com.shfc.base.domain.BaseRetroaction;
import com.shfc.base.dto.ReactionDTO;
import com.shfc.common.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-09 15:29
 **/
@Service
public class ReactionManager {
    @Autowired(required = false)
    private BaseRetroactionMapper baseRetroactionMapper;

    @Transactional(rollbackFor = AppException.class)
    public int addReaction(ReactionDTO reactionDTO){

        BaseRetroaction baseRetroaction = new BaseRetroaction();
        baseRetroaction.setUserid(reactionDTO.getUserId());
        baseRetroaction.setRetroaction(reactionDTO.getRetroaction());
        baseRetroaction.setCreateTime(new Date());

        return baseRetroactionMapper.insertSelective(baseRetroaction);

    }
}
