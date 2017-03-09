package com.elong.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.elong.generics
 * 创建人 : Elong
 * 时间: 09/03/2017 4:33 PM
 * 描述 : 使用集合来代替数组查看情况
 */
public class ArrayMaker2<T> {

    List<T> create(){
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        ArrayMaker2<String> arrayMaker2 = new ArrayMaker2<>();
        List<String> strings = arrayMaker2.create();
        System.out.println(strings);

    }

}
