package com.shfc.base.service;

import com.shfc.base.JunitBaseTest;
import com.shfc.base.dto.ReactionDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-09 15:43
 **/
public class ReactionServiceTest extends JunitBaseTest {
    @Autowired
    private ReactionService reactionService;

    @Test
    public void testAddReactionTest() {
        ResultDO<Boolean> resultDO=null;
        ReactionDTO reactionDTO = new ReactionDTO();
        reactionDTO.setUserId("   ");
        reactionDTO.setRetroaction("做的挺....");

       resultDO = reactionService.addReaction(reactionDTO);

        Assert.assertNotNull(resultDO.getErrMsg());

        //
        //AddReactionBean addReactionBean2 = new AddReactionBean();
        reactionDTO.setUserId("123");
        reactionDTO.setRetroaction("做的挺....");

       resultDO = reactionService.addReaction(reactionDTO);

        Assert.assertTrue(resultDO.isSuccess());
        Assert.assertNull(resultDO.getErrMsg());


       // AddReactionBean addReactionBean3 = new AddReactionBean();
        reactionDTO.setUserId("123");
        reactionDTO.setRetroaction("");

       resultDO = reactionService.addReaction(reactionDTO);

        Assert.assertNotNull(resultDO.getErrMsg());
    }
}
