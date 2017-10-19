package com.shfc.base.service;

import com.shfc.base.dto.ReactionDTO;
import com.shfc.common.result.ResultDO;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-09 13:26
 **/
public interface ReactionService {
    /**
     * @Description: 建议反馈
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/3 17:17
     * @param  reactionDTO
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    ResultDO<Boolean> addReaction(ReactionDTO reactionDTO);
}
