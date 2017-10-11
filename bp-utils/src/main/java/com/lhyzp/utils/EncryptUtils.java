package com.lhyzp.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密工具类---SHA256_HMAC加密
 * Created by Administrator on 2017-10-11.
 */
public class EncryptUtils {

    /**
     * sha256_HMAC加密
     *
     * @param message
     *            消息
     * @param secret
     *            秘钥
     * @return 加密后字符串
     */
    public static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }
    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b
     *            字节数组
     * @return 字符串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }


    /*使用*/
    //public static final String PUBLIC_KEY = "qpda5-eu8uc-bta6c-qrdm4-775v7-nmymb-c1trv";
    //public static final String PRIVATE_KEY = "*cVd)-6FYvS-97zEU-HT^SJ-9qd6&-Cz*md-;fpGt";
    //
    //public static void main(String[] args) {
    //    String encryptKey;
    //    String str = sha256_HMAC("待加密字符串", PRIVATE_KEY);
    //    System.out.println(" getSignature : " + str);
    //
    //}
}
