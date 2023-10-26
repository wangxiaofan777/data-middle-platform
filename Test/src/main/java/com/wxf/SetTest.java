package com.wxf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxf
 * @since 2023-10-13 13:57
 **/
public class SetTest {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.toArray();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();


        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i <= 10; i++) {
            treeSet.add(i);
            hashSet.add(i);
            linkedHashSet.add(i);
        }
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(treeSet);

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(hashSet);

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(linkedHashSet);
    }


}
