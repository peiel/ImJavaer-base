package com.elong.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : 实用方法  同步容器
 */
public class Synchronization {

    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> ls = Collections.synchronizedList(new ArrayList<String>());
        Set<String> ss = Collections.synchronizedSet(new HashSet<String>());
        SortedSet<String> sortedSet = Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String, String> stringStringMap = Collections.synchronizedMap(new HashMap<String, String>());
        SortedMap<String, String> stringStringSortedMap = Collections.synchronizedSortedMap(new TreeMap<String, String>());
    }

}
