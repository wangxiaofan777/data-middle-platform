package com.wxf.common.tools;

import java.util.UUID;

/**
 * @Description: 随机字符串
 * @Author: du_zj
 * @Date: 2022/3/7  16:11
 */
public class UUIDFactory {

    /**
     * 生辰UUID
     *
     * @return str
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(generateUUID());
    }
}
