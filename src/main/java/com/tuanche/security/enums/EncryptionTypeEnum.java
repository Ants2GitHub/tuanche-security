package com.tuanche.security.enums;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public enum EncryptionTypeEnum {
    MD5("MD5"),
    SHA1("SHA-1"),
    DES("DES"),
    AES("AES"),

    ;

    private String key;

    EncryptionTypeEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
