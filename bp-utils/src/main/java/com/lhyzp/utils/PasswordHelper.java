package com.lhyzp.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密
 * Created by Administrator on 2017-11-6.
 */
public class PasswordHelper {


    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static String encryptPassword(String pwd,String salt){

        String newPassword = new SimpleHash(algorithmName, pwd,  ByteSource.Util.bytes(salt), hashIterations).toHex();

        return newPassword;
    }
}
