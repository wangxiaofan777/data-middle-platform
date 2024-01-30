package com.wxf.kafka;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wxf
 * @since 2024-01-30 10:27:35
 **/
public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.forEach(x -> {
            if (x % 10 == 0) {
                return;
            }
            System.out.println(x);

        });


//        while (true) {
//
//            System.out.println(1);
//
////            return;
////            break;
//            throw new RuntimeException("");
//
//        }
    }
}
