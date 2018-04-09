package com.tuanche.security.digital;

import com.tuanche.security.enums.EncodeEnum;
import com.tuanche.security.enums.EncryptionTypeEnum;
import com.tuanche.security.utils.HexAndBytesUtil;

import java.security.MessageDigest;

import static com.tuanche.security.utils.HexAndBytesUtil.bytes2hex;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public class DigitalEncryption {

    /**
     * @author: ants·ht
     * @Description 获取MD5加密串的字节数组
     * @Date: 2018/4/9
     *
     */
    public static byte[] getMD5Byte(final String content) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptionTypeEnum.MD5.getKey());
        byte[] digest = messageDigest.digest(content.getBytes(EncodeEnum.UTF_8.getKey()));
        return digest;
    }

    /**
     * @author: ants·ht
     * @Description 获取MD5加密串
     * @Date: 2018/4/9
     *
     */
    public static String getMD5Str(final String content) throws Exception {
        byte[] md5Byte = getMD5Byte(content);
        return bytes2hex(md5Byte);
    }


    /**
     * @author: ants·ht
     * @Description SHA-1 加密算法  获取结果数组
     * @Date: 2018/4/9
     *
     */
    public static byte[] getSHA1Byte (final String content) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptionTypeEnum.SHA1.getKey());
        return messageDigest.digest(content.getBytes(EncodeEnum.UTF_8.getKey()));
    }

    /**
     * @author: ants·ht
     * @Description SHA-1 加密算法 获取结果字符串
     * @Date: 2018/4/9
     *
     */
    public static String getSHA1Str(final String content) throws Exception {
        byte[] sha1Byte = getSHA1Byte(content);
        return HexAndBytesUtil.bytes2hex(sha1Byte);
    }


}
