package com.elong.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 创建人 : peierlong
 * 描述 : 读写随机访问文件
 */
public class UsingRandomAccessFile {
    static String file = "rtest.data";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");  //r 代表只读
        for (int i = 0; i < 8; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");  //rw 代表可读可写
        for (int i = 0; i < 8; i++)
            rf.writeDouble(i * 1.414);
        rf.writeUTF("hello world");
        rf.close();
        display();
        System.out.println("--------------");
        rf = new RandomAccessFile(file, "rw");
        rf.seek(1*8);  //一个double类型占64位=8个字节
        rf.writeDouble(14.2222);
        rf.close();
        display();

    }
}
