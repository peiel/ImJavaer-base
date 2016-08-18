package com.elong.io;

import java.io.BufferedInputStream;
import java.io.StringReader;

/**
 * 创建人 : peierlong
 * 描述 : 从内存中输入
 */
public class MemoryInput {

    public static void main(String[] args) {
        try {
            StringReader stringReader = new StringReader(BufferedInputFIle.read("c://123.txt"));
            int c;
            while ((c = stringReader.read()) != -1){
                System.out.print((char)c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
