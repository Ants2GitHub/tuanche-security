package com.tuanche.security.enums;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public enum EncodeEnum {

    UTF_8("UTF-8"),

    ;


    private String key;

    EncodeEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
