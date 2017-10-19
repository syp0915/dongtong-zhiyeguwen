package com.shfc.house.query;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-11 13:54
 **/
public class CustomerStoreQuery extends BaseQuery {
    private String keyword;
    private Long realtorCompanyId;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getRealtorCompanyId() {
        return realtorCompanyId;
    }

    public void setRealtorCompanyId(Long realtorCompanyId) {
        this.realtorCompanyId = realtorCompanyId;
    }
}
