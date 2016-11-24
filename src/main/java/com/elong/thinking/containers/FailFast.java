package com.elong.thinking.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : java.util.ConcurrentModificationException 快速失败
 *       在获取迭代器后再次进行操作会出现此异常
 */
public class FailFast {
    public static void main1(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        Iterator<String> iterator = list.iterator();
        list.add("b");
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aaa");
        map.put(2, "bbb");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

        map.put(3, "ccc");

        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next);
        }


    }
}
