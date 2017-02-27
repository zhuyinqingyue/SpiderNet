package com.spidernet.util;

import java.util.UUID;

public class UtilTest
{

    public static String getUUID()
    {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    public static void main(String... args) {
        String uuid = getUUID();
        System.out.println(uuid);
    }
}
