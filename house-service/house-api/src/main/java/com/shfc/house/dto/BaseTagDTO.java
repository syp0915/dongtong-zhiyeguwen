package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.BaseTagDTO
 * @Description: 基础标签
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 11:28
 * version V1.0.0
 */
public class BaseTagDTO implements Serializable{

    private static final long serialVersionUID = 8280320962899193058L;
    private Long id; // 标签id
    private String name; // 标签名称
    private String color; // 标签颜色

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
