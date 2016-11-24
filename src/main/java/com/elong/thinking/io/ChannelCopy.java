package com.elong.thinking.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创建人 : peierlong
 * 描述 : Byte流复制文件
 */
public class ChannelCopy {

    private static final int BSIZE = 1;

    public static void main(String[] args) {
        try {
            FileChannel
                    in = new FileInputStream("data.txt").getChannel(),
                    out = new FileOutputStream("data.copy").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
            int i = 1;
            while (in.read(byteBuffer) != -1) {
                System.out.println(i++);
                byteBuffer.flip();
                out.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
