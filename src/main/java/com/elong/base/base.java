package com.elong.base;

/**
 * 包名: com.elong.base
 * 创建人 : Elong
 * 时间: 09/03/2017 10:37 AM
 * 描述 : 位移操作总结
 */
public class base {
    public static void main(String[] args) {


        System.out.println("---------------- int ------------------");

        int a = 1;
        int b = -1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));

        System.out.println("---------------- long ------------------");

        long c = -1;
        System.out.println(Long.toBinaryString(c));
        c >>>= 10;
        System.out.println(Long.toBinaryString(c));

        System.out.println("---------------- short ------------------");

        short d = -1;
        System.out.println(Integer.toBinaryString(d));
        d >>>= 10;
        System.out.println(Integer.toBinaryString(d));


        System.out.println("---------------- byte ------------------");

        byte e = -1;
        System.out.println(Integer.toBinaryString(e));
        e >>>= 10;
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(e >>> 10));







    }
}
