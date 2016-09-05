package com.elong.test;

import com.elong.util.TextFile;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Test {

    public static void main(String[] args) {
        TextFile.write("123.txt", "123123123\n123123123");
        String read = TextFile.read("123.txt");
        System.out.println(read);
    }

}
