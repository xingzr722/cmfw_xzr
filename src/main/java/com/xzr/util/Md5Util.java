package com.xzr.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/9/27.
 */
public class Md5Util {

    public static String getMessageDisgest(String password){
        StringBuilder sb = null;
        try {
            //加密类
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            //加密
            byte[] digest = messageDigest.digest(password.getBytes());
            //转为长度为16进制32位字符串
            sb = new StringBuilder();
            for (byte b : digest) {
                int len = b & 0xff;  //0x1-1  0x2-2 0x3-3  0xa-10 0xf-15  ox10-16
                if(len<=15){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(len));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String messageDisgest = getMessageDisgest("123456");
        System.out.println(messageDisgest);

    }


}
