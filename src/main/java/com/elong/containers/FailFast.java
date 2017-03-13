package com.elong.containers;

import org.junit.Test;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : java.util.ConcurrentModificationException 快速失败
 *       在获取迭代器后再次进行操作会出现此异常
 */
public class FailFast {

    @Test
    public void failFast_1() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        Iterator<String> iterator = list.iterator();
        list.add("b");
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void failFast_2() {
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
