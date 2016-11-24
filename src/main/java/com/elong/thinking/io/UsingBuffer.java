package com.elong.thinking.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 创建人 : peierlong
 * 描述 : 使用CharBuffer控制字符替换位置
 */
public class UsingBuffer {

    private static void symmetricScramble(CharBuffer charBuffer) {
        for (; charBuffer.hasRemaining(); ) {
            charBuffer.mark();
            char c1 = charBuffer.get();
            if (!charBuffer.hasRemaining()) continue;
            char c2 = charBuffer.get();
            charBuffer.reset();
            charBuffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] chars = "abcdefg".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(chars.length * 2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(chars);

        System.out.println("get(i) = " + charBuffer.get(0));//使用下标获取的字符并不会对position指针有影响


        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
    }


}
