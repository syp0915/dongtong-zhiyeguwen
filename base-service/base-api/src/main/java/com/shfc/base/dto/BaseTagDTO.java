package com.shfc.base.dto;

import java.io.Serializable;

public class BaseTagDTO implements Serializable{
    /**
	 * @author wky
	 * @date 2016年12月29日 上午11:02:47
	 * @version V1.0
	 */
	private static final long serialVersionUID = 6066264494420891860L;
	private String id;
    private String name;
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
