package com.shfc.base.service;

import com.shfc.base.manager.ReactionManager;
import com.shfc.base.dto.ReactionDTO;
import com.shfc.common.base.ValidateHelper;
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
 * @create 2017-01-09 13:32
 **/
@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionManager reactionManager;
    @Override
    public ResultDO<Boolean> addReaction(ReactionDTO reactionDTO) {
        ResultDO<Boolean> resultDO=new ResultDO<Boolean>();
        String userId = reactionDTO.getUserId();

        String retroaction = reactionDTO.getRetroaction();


        if(ValidateHelper.isEmpty(userId)){
            resultDO.setErrMsg("请求参数不可为空");
            return resultDO;
        }

        if(ValidateHelper.isEmpty(retroaction)){
            resultDO.setErrMsg("请求参数不可为空");
            return resultDO;
        }

        //未注册用户不允许创建建议反馈


     //插入数据库
        int result=reactionManager.addReaction(reactionDTO);
        if(result==1){
            resultDO.setSuccess(true);
        }

        return resultDO;
    }
}
