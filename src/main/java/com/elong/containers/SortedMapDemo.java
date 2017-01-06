package com.elong.containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 创建人 : peierlong
 * 描述 : SortedMapDemo
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(getMapData());
        System.out.println(sortedMap);
        System.out.println("first key is :: " + sortedMap.firstKey());
        System.out.println("last key is :: " + sortedMap.lastKey());
        int one = 0, two = 0;
        Iterator<Integer> iterator = sortedMap.keySet().iterator();
        for (int i = 0; i < 9; i++) {
            if (i == 2) one = iterator.next();
            else if (i == 6) two = iterator.next();
            else iterator.next();
        }
        System.out.println("one :: " + String.valueOf(one));
        System.out.println("two :: " + String.valueOf(two));

        System.out.println("subMap :: " + sortedMap.subMap(one, two));
        System.out.println("headMap :: " + sortedMap.headMap(one));
        System.out.println("tailMap :: " + sortedMap.tailMap(two));

    }


    public static Map<Integer, String> getMapData(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "bbb");
        map.put(4, "ddd");
        map.put(1, "aaa");
        map.put(3, "ccc");
        map.put(6, "fff");
        map.put(7, "ggg");
        map.put(5, "eee");
        map.put(9, "iii");
        map.put(8, "hhh");
        return map;
    }

}
