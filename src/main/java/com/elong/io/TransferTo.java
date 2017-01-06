package com.elong.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 创建人 : peierlong
 * 描述 : Byte流复制升级版  一个通道写入数据 一个通道读取数据 两个通道直接相连
 */
public class TransferTo {

    public static void main(String[] args) {
        try {
            FileChannel
                    in = new FileInputStream("data.txt").getChannel(),
                    out = new FileOutputStream("data.copy").getChannel();

//            in.transferTo(0, in.size(), out);
            out.transferFrom(in, 0, in.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
