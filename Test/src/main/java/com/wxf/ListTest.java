package com.wxf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wxf
 * @since 2023-11-10 23:19:31
 **/
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("java");
        list.add("aa");
        list.add("java");
        list.add("java");
        list.add("bb");

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("=======" + i);
            if ("java".equals(list.get(i))) {
                list.remove(i);
                System.out.println("size: " + list.size());
            }
        }
        System.out.println(list);
    }
}
