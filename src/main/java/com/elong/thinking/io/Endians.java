package com.elong.thinking.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 创建人 : peierlong
 * 描述 : 字节存储优先级
 */
public class Endians {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcedf");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN); //高位优先
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN); //低位优先
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));


    }


}
