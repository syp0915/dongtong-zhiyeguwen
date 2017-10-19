package com.shfc.base.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告查询Bean
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 09:47
 **/
public class AdvertisementsQuery implements Serializable {
    /**
	 * @author wky
	 * @date 2017年1月4日 下午1:30:35
	 * @version V1.0
	 */
	private static final long serialVersionUID = 8173117748333032369L;
	private String source;//0-专业终端 1-用户app 2-经纪人App 3-web
    private String position;//0-登录广告 1-首页

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
