package com.elong.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.elong.generics
 * 创建人 : Elong
 * 时间: 09/03/2017 4:37 PM
 * 描述 :
 */
public class FilledListMaker<T> {

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> maker = new FilledListMaker<>();
        List<String> fucks = maker.create("fuck", 10);
        System.out.println(fucks);
    }

}
