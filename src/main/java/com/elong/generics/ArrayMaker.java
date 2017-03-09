package com.elong.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 包名: com.elong.generics
 * 创建人 : Elong
 * 时间: 09/03/2017 4:25 PM
 * 描述 : 泛型的擦除导致类型的丢失
 */
public class ArrayMaker<T extends String> {

    private Class<T> clazz;

    public ArrayMaker(Class<T> clazz) {
        this.clazz = clazz;
    }

    T[] create(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

    /**
     * clazz 被存储为Class，没有任何参数。类型信息被擦除后导致的结果。
     */
    public static void main(String[] args) {

        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);

        String[] strings = stringArrayMaker.create(10);

        System.out.println(Arrays.toString(strings));

    }

    /* Output:
     * [null, null, null, null, null, null, null, null, null, null]
     */
}
