package com.elong.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 创建人 : peierlong
 * 描述 : 格式化内存输入流
 */
public class FormatMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream("nihao".getBytes()));
            for(;;){
                System.out.println((char)dataInputStream.readByte());
            }
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("结束");
        }
    }
}
