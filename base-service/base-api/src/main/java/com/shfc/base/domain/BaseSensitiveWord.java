package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseSensitiveWord.java
 * @Description: 敏感词
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
public class BaseSensitiveWord extends BaseBean {
    /**
     * 敏感词
     */
    private String sensitiveWord;

    /**
     * 敏感词类型
     */
    private Integer type;

    /**
     * 获取敏感词
     *
     * @return sensitive_word
     */
    public String getSensitiveWord() {
        return sensitiveWord;
    }

    /**
     * 设置敏感词
     *
     * @param sensitiveWord
     */
    public void setSensitiveWord(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord == null ? null : sensitiveWord.trim();
    }

    /**
     * 获取敏感词类型
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置敏感词类型
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @Title toString
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sensitiveWord=").append(sensitiveWord);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}