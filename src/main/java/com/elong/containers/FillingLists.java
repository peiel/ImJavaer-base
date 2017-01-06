package com.elong.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 创建人 : erlong.pei
 * 描述 : 填充容器演示
 *     注意一个细节，容器内的所有的引用都指向了同一个对象
 */
public class FillingLists {

    public static void main(String[] args) {
        try {
            List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("function1")));
            System.out.println(list);
            //fill 方法具有一定的局限性，只能填充容器中已有的引用
            Collections.fill(list, new StringAddress("function2"));
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StringAddress {
    private String s;
    StringAddress(String s) {
        this.s = s;
    }
    @Override
    public String toString() {
        return super.toString() + " == " + this.s;
    }
}