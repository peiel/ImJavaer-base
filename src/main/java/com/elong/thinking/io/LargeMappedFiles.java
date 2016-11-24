package com.elong.thinking.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class LargeMappedFiles {
    static int lenth = 0x8FFFFFF;

    public static void main(String[] args) throws IOException {
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, lenth);
        for (int i = 0; i < lenth; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
        System.out.println("finish writing");
        for (int i = lenth / 2; i < lenth / 2 + 6; i++) {
            System.out.print(mappedByteBuffer.get(i) + "\t");
        }
    }


}
