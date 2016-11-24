package com.elong.thinking.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 创建人 : peierlong
 * 描述 : BufferToText
 */
public class BufferToText {

    public static void main(String[] args) throws IOException {
        //ByteBuffer.asCharBuffer() 读出的是乱码
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("你好".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fc.read(byteBuffer);
        fc.close();
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());

        byteBuffer.rewind();
        String encode = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encode + ": " + Charset.forName(encode).decode(byteBuffer));

        //指定编码后可以正确读出数据
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("哈喽".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        byteBuffer.clear();
        fc.read(byteBuffer);
        fc.close();
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());

        //写入的时候想ByteBuffer中put数据
        fc = new FileOutputStream("data2.txt").getChannel();
        byteBuffer.asCharBuffer().put("呵呵");
        fc.write(byteBuffer);
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        byteBuffer.clear();
        fc.read(byteBuffer);
        fc.close();
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());





    }

}
