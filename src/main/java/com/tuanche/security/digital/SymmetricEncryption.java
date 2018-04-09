package com.tuanche.security.digital;

import com.tuanche.security.enums.EncodeEnum;
import com.tuanche.security.enums.EncryptionTypeEnum;
import com.tuanche.security.utils.HexAndBytesUtil;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import static com.tuanche.security.utils.Base64EncryptionUtil.base642Byte;
import static com.tuanche.security.utils.Base64EncryptionUtil.byte2Base64;
import static com.tuanche.security.utils.HexAndBytesUtil.bytes2hex;
import static com.tuanche.security.utils.HexAndBytesUtil.hex2bytes;

/**
 * @author ants·ht
 * @date 2018/4/9
 * @description
 */
public class SymmetricEncryption {

    /**
     * @author: ants·ht
     * @Description 生成 DES 加密所需要的 秘钥 Key
     * @Date: 2018/4/9
     *
     */
    public static String getKeyDES() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptionTypeEnum.DES.getKey());
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        return byte2Base64(secretKey.getEncoded());
    }

    /**
     * @author: ants·ht
     * @Description 加载 生成的 DES 的秘钥Key
     * @Date: 2018/4/9
     *
     */
    public static SecretKey loadKeyDES(String base64Key) throws Exception {
        byte[] bytes = base642Byte(base64Key);
        return new SecretKeySpec(bytes,EncryptionTypeEnum.DES.getKey());
    }

    /**
     * @author: ants·ht
     * @Description DES 加密
     * @Date: 2018/4/9
     *
     */
    public static byte[] encryptDES(byte[] source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.DES.getKey());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(source);
    }

    /**
     * @author: ants·ht
     * @Description DES 加密
     * @Date: 2018/4/9
     *
     */
    public static String encryptDES(String source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.DES.getKey());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] bytes = cipher.doFinal(source.getBytes(EncodeEnum.UTF_8.getKey()));
        return bytes2hex(bytes);
    }

    /**
     * @author: ants·ht
     * @Description DES 解密
     * @Date: 2018/4/9
     *
     */
    public static byte[] decryptDES(byte[] source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.DES.getKey());
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return cipher.doFinal(source);
    }

    /**
     * @author: ants·ht
     * @Description DES 解密
     * @Date: 2018/4/9
     *
     */
    public static String decryptDES(String source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.DES.getKey());
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return new String(cipher.doFinal(hex2bytes(source)),EncodeEnum.UTF_8.getKey());
    }

    /**
     * @author: ants·ht
     * @Description 生成AES加密使用的key
     * @Date: 2018/4/9
     *
     */
    public static String getKeyAES() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(EncryptionTypeEnum.AES.getKey());
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        return byte2Base64(secretKey.getEncoded());
    }

    /**
     * @author: ants·ht
     * @Description 加载 AES 所用的 Key
     * @Date: 2018/4/9
     *
     */
    public static SecretKey loadKeyAES(String base64Key) throws Exception {
        byte[] bytes = base642Byte(base64Key);
        return new SecretKeySpec(bytes,EncryptionTypeEnum.AES.getKey());
    }

    /**
     * @author: ants·ht
     * @Description AES 加密
     * @Date: 2018/4/9
     *
     */
    public static byte[] encryptAES(byte[] source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.AES.getKey());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(source);
    }

    /**
     * @author: ants·ht
     * @Description AES 加密
     * @Date: 2018/4/9
     *
     */
    public static String encryptAES(String source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.AES.getKey());
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return bytes2hex(cipher.doFinal(source.getBytes(EncodeEnum.UTF_8.getKey())));
    }

    /**
     * @author: ants·ht
     * @Description AES 解密
     * @Date: 2018/4/9
     *
     */
    public static byte[] decryptAES(byte[] source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.AES.getKey());
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return cipher.doFinal(source);
    }

    /**
     * @author: ants·ht
     * @Description AES 解密
     * @Date: 2018/4/9
     *
     */
    public static String decryptAES(String source,SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(EncryptionTypeEnum.AES.getKey());
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return new String(cipher.doFinal(hex2bytes(source)),EncodeEnum.UTF_8.getKey());
    }
}
