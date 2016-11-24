package com.elong.thinking.containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 创建人 : peierlong
 * 描述 : SortedSet Demo
 * 关系 : TreeSet --> NavigableSet --> SortedSet
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        String str[] = "one two three four five six seven eight".split(" ");
        for (String s : str) {
            System.out.println(s);
            sortedSet.add(s);
        }
        System.out.println("-------");
//        Collections.addAll(sortedSet, str);
        System.out.println(sortedSet);

        System.out.println("sortedSet.first() : " + sortedSet.first());
        System.out.println("sortedSet.last() : " + sortedSet.last());

        System.out.println("--------");
        String low = null;
        String high = null;
        String content = null;
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i < 6; i++) {
            if (i == 2) low = it.next();
            else if (i == 4) high = it.next();
            else content = it.next();
        }

        System.out.println(low);
        System.out.println(high);

        System.out.println(sortedSet.subSet(low, high)); //包前不包后
        System.out.println(sortedSet.headSet(low)); //不包括low
        System.out.println(sortedSet.tailSet(high)); //包括high

    }
}
