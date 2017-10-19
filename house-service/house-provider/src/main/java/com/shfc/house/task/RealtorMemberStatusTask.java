package com.shfc.house.task;

import com.shfc.house.manager.MemberManager;
import com.shfc.house.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Package com.shfc.house.task.RealtorMemberStatusTask
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/19 10:30
 * version V1.0.0
 */
@Component
public class RealtorMemberStatusTask {
    @Autowired
    private MemberService memberService;

    /**
     * 每天8点0分跑定时任务，更新失效会员的状态
     */
    //@Scheduled(cron = "0 0 8 ? * *")
    public void run(){
        memberService.memberPastRemind();
    }

    /**
     * 会员到期的前3天  短信提醒
     */
    //@Scheduled(cron = "0 0 9 ? * *")
    public void pastRemind(){
        memberService.threeDayPastRemind();
    }
}
