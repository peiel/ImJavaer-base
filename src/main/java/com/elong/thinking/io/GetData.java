package com.elong.thinking.io;

import java.nio.ByteBuffer;

/**
 * 创建人 : peierlong
 * 描述 : ByteBuffer基本数据类型的应用
 */
public class GetData {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        int i = 0;
        while (i++ < bb.limit()){
            if (bb.get() != 0){
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);

        bb.rewind();
        bb.asCharBuffer().put("hello world");
        char c;
        while ((c = bb.getChar()) != 0){
            System.out.print(c);
        }

        System.out.println();

        bb.rewind();
        bb.asIntBuffer().put(123);
        int anInt = bb.getInt();
        System.out.println(anInt);

        bb.rewind();
        bb.asDoubleBuffer().put(12.12);
        double aDouble = bb.getDouble();
        System.out.println(aDouble);


    }


}
