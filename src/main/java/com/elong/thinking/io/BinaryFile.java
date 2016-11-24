package com.elong.thinking.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 创建人 : peierlong
 * 描述 : 二进制读取
 */
public class BinaryFile {

    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(bfile));
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        } finally {
            in.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }


}
