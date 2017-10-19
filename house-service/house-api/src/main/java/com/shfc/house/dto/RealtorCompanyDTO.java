package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人公司
 *
 * @author wky
 * @version V1.0
 * @create 2017-06-05 16:56
 **/
public class RealtorCompanyDTO implements Serializable {
    private Long id;

    private String comAbbr;

    private String comName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComAbbr() {
        return comAbbr;
    }

    public void setComAbbr(String comAbbr) {
        this.comAbbr = comAbbr;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
