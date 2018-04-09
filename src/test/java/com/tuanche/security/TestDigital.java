package com.tuanche.security;

import com.tuanche.security.digital.DigitalEncryption;
import com.tuanche.security.digital.SymmetricEncryption;
import org.junit.Test;

import javax.crypto.SecretKey;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public class TestDigital {

    @Test
    public void testMd5() throws Exception {
        String contetn = "hello world";
        String md5Str = DigitalEncryption.getMD5Str(contetn);
        System.out.println(md5Str);

        String sha1Str = DigitalEncryption.getSHA1Str(contetn);
        System.out.println(sha1Str);
    }

    @Test
    public void testDES() throws Exception {
        String content = "{\"addtime\":1522633944,\"applyId\":\"11882518\",\"brandId\":31,\"brandName\":\"一汽-大众奥迪\",\"cityId\":177,\"cityName\":\"武汉\",\"name\":\"杨洁\",\"phone\":15071251826,\"styleId\":309,\"styleName\":\"奥迪Q3\"}";

        SecretKey secretKey = SymmetricEncryption.loadKeyDES(SymmetricEncryption.getKeyDES());
        String s = SymmetricEncryption.encryptDES(content, secretKey);
        System.out.println(s);

        String s1 = SymmetricEncryption.decryptDES(s, secretKey);
        System.out.println(s1);
    }

    @Test
    public void testAES() throws Exception {
        String content = "{\"addtime\":1522633944,\"applyId\":\"11882518\",\"brandId\":31,\"brandName\":\"一汽-大众奥迪\",\"cityId\":177,\"cityName\":\"武汉\",\"name\":\"杨洁\",\"phone\":15071251826,\"styleId\":309,\"styleName\":\"奥迪Q3\"}";

        SecretKey secretKey = SymmetricEncryption.loadKeyAES(SymmetricEncryption.getKeyAES());
        String s = SymmetricEncryption.encryptAES(content, secretKey);
        System.out.println(s);

        String s1 = SymmetricEncryption.decryptAES(s, secretKey);
        System.out.println(s1);
    }
}
