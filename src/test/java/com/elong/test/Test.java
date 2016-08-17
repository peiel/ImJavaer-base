package com.elong.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Test {

    public static void main(String[] args) {

        List<Object> list = Collections.emptyList();
        List emptyList = Collections.EMPTY_LIST;

        System.out.println(list);
        System.out.println(emptyList);
//        list.add(new Object());
//        list.add(2);]
//        list.add('C');
//        System.out.println(list);

        Set<String> elong = Collections.singleton("elong");
        System.out.println(elong);

        Iterator<String> iterator = elong.iterator();

        for (;iterator.hasNext();){
            System.out.println(iterator.next());
        }



        elong.add("pei");
        System.out.println(elong);


    }

}
