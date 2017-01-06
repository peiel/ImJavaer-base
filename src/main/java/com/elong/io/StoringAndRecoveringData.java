package com.elong.io;

import java.io.*;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("abc.txt"));
        out.writeBoolean(true);
        out.writeUTF("this is a pai");
        out.writeLong(112233L);
        out.writeDouble(3.2);
        out.writeDouble(2.2);
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("abc.txt"));
        boolean b = in.readBoolean();
        System.out.println(b);
        System.out.println(in.readUTF());
        System.out.println(in.readLong());
        System.out.println(in.readDouble());
    }
}
