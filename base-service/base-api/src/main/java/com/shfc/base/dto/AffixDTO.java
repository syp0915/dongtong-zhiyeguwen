package com.shfc.base.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-10 11:10
 **/
public class AffixDTO implements Serializable {
    private static final long serialVersionUID = 2459213970247777632L;
    private String fileName;//附件名称
    private String file;//附件

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
