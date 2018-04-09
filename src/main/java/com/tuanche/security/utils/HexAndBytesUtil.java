package com.tuanche.security.utils;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public final class HexAndBytesUtil {


    public static String bytes2hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i < bytes.length; i++) {
            byte b = bytes[i];
            // 是否为负数
            boolean negative = false;
            if(b < 0) { negative =  true; }
            int inte = Math.abs(b);
            // 负数转为整数（最高位的负号变成数值计算）,再转十六进制
            if(negative) { inte = inte | 0x80 ; }
            String temp = Integer.toHexString(inte & 0xFF);
            if (temp.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(temp.toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static byte[] hex2bytes(String hex) {
        byte[] bytes = new byte[hex.length()/2];
        for (int i = 0;i < hex.length();i = i+2) {
            String subStr = hex.substring(i, i + 2);
            // 是否为负数
            boolean negative = false;
            int inte = Integer.parseInt(subStr,16);
            if(inte > 127) { negative = true; }
            if(inte ==  128) {
                inte = -128;
            } else if(negative) {
                inte = 0 - (inte & 0x7F);
            }
            byte b = (byte) inte;
            bytes[i/2] = b;
        }
        return bytes;
    }
}
