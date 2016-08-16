package com.elong.containers;

import java.util.LinkedHashMap;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(SortedMapDemo.getMapData());
//        System.out.println(linkedHashMap);
        linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
        linkedHashMap.putAll(SortedMapDemo.getMapData());
        System.out.println(linkedHashMap);
        for (int i = 1; i < 5; i++) {
            linkedHashMap.get(i);
        }
        linkedHashMap.get(2);
        System.out.println(linkedHashMap);
    }


}
