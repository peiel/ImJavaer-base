package com.elong.io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing Objects: ");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        //保存序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("blips.txt"));
        objectOutputStream.writeObject(blip1);
        objectOutputStream.writeObject(blip2);
        objectOutputStream.close();

        System.out.println("---------------可爱的分割线---------------");

        //读取序列化对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("blips.txt"));
        Blip1 b1 = (Blip1) objectInputStream.readObject();
        Blip2 b2 = (Blip2) objectInputStream.readObject();
    }

}

class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("blip1 writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("blip1 readExternal");
    }
}

class Blip2 implements Externalizable {

    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2 readExternal");
    }
}