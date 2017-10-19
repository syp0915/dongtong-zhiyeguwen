package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.ImportReqBean
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/6/7 14:02
 * version V1.0.0
 */
public class ImportReqBean implements Serializable {
    private String filePath;//xlsx文件路径

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
