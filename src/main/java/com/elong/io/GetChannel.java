package com.elong.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            //向文件中写入数据
            FileChannel fileChannel = new FileOutputStream("data.txt").getChannel();
            fileChannel.write(ByteBuffer.wrap("a".getBytes()));
            fileChannel.close();
            //追加数据
            FileChannel rw = new RandomAccessFile("data.txt", "rw").getChannel();
            rw.position(rw.size());
            rw.write(ByteBuffer.wrap("\nbbb".getBytes()));
            rw.close();
            //读取文件
            FileChannel read = new FileInputStream("data.txt").getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BSIZE);
            read.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char)byteBuffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}


