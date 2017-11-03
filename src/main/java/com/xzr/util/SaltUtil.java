package com.xzr.util;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/27.
 */
public class SaltUtil {


    public static String getSalt(int n){
        char[] code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n ; i++) {
            sb.append(code[random.nextInt(code.length)]);
        }
        return sb.toString();
    }

}
