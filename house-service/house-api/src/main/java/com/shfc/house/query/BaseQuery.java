package com.shfc.house.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.BaseQuery
 * @Description: 基础查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 9:03
 * version V1.0.0
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = -7567837330176113154L;
    private Integer pageNumber=1;
    private Integer pageSize=20;

    public BaseQuery(){}

    public BaseQuery(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
