package com.elong.containers;

import com.elong.util.CollectionData;
import com.elong.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 创建人 : peierlong
 * 描述 : 初始化一个LinkedHashSet的实例
 * 注意 : CollectionData 其实就是 适配器设计模式
 */
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 7));
        System.out.println(set);

        Set<String> set2 = new LinkedHashSet<String>();
        set2.addAll(CollectionData.list(new Government(), 7));
        System.out.println(set2);
    }
}

class Government implements Generator<String> {
    private String[] foundation = "Hello My Name Is Pei Er Long".split(" ");
    private int index;

    public String next() {
        return foundation[index++];
    }
}