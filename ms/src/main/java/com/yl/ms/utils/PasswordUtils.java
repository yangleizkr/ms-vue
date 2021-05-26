package com.yl.ms.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author yl
 */
public class PasswordUtils {


    public static String digestPassword(String password){
        String s = SecureUtil.md5(password);
        return s;
    }

}
