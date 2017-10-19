package com.shfc.building.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.building.dto
 * @Description :参数详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-06-20 17:13
 * version V1.0.0
 **/
public class BaseParameterDTO implements Serializable {

    /**
     * 参数Id
     */
    private Long id;

    /**
     * 参数类型
     */
    private Integer type;

    /**
     * 参数类型名称
     */
    private String typeName;

    /**
     * 参数key
     */
    private Integer key;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
