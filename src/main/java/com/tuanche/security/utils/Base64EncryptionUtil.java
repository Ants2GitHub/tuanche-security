package com.tuanche.security.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description Base64 加密算法相关
 */
public class Base64EncryptionUtil {

    /**
     * @author: ants·ht
     * @Description 字节数组加密成base64 的字符串
     * @Date: 2018/4/9
     *
     */
    public static String byte2Base64(final byte[] bytes) throws Exception {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }


    /**
     * @author: ants·ht
     * @Description String 类型的base64串转换成字节数组
     * @Date: 2018/4/9
     *
     */
    public static byte[] base642Byte(final String base64) throws Exception {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        return base64Decoder.decodeBuffer(base64);
    }

}
