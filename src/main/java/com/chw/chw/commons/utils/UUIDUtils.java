package com.chw.chw.commons.utils;

import java.util.UUID;

public class UUIDUtils {
    public static void main(String[] args) {
        String str= UUID.randomUUID().toString();
        str=str.replaceAll("-","");
        System.out.println(str);
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
