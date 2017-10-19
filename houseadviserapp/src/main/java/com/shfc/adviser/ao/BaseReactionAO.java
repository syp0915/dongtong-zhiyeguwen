package com.shfc.adviser.ao;

import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.base.dto.ReactionDTO;
import com.shfc.base.service.ReactionService;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 14:34
 **/
@Service
public class BaseReactionAO {
    @Autowired
    private ReactionService reactionService;

    public ResultDO<Boolean> addReaction(ReactionDTO dto){
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            ResultDO<Boolean> resultDO=new ResultDO<Boolean>();
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        dto.setUserId(String.valueOf(realtorId));
        return reactionService.addReaction(dto);
    }

}
