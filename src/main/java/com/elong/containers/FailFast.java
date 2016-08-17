package com.elong.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class FailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        Iterator<String> iterator = list.iterator();
        list.add("b");
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
