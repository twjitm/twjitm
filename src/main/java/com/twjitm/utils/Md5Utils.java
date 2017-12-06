package com.twjitm.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 文江 on 2017/12/6.
 */
public class Md5Utils {


    public static String md5ToString(String string) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
       // md5.digest()
        BASE64Decoder decoder=new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(string);
            return new String(bytes,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
return null;
    }

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String StringToMd5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();

//加密后的字符串
        String newstr = null;
        try {
            newstr = base64en.encode(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newstr;
    }

    public static void main(String[] args) {
        System.out.println(StringToMd5("123456"));
        System.out.println( md5ToString(StringToMd5("123456")));
    }
}
