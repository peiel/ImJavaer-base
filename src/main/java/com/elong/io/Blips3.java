package com.elong.io;

import java.io.*;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Blips3 implements Externalizable {

    private int i;
    private String s;

    public Blips3() {
        System.out.println("Blips3 Constructor");
    }

    public Blips3(int i, String s) {
        System.out.println("Blips3 Constructor two params");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return i + " " + s;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blips3 writeExternal");
        out.writeInt(i);
        out.writeObject(s);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blips3 readExternal");
        i = in.readInt();
        s = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blips3 blips3 = new Blips3(47, "aString");
        System.out.println(blips3);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("blips3.txt"));
        objectOutputStream.writeObject(blips3);
        objectOutputStream.close();

        System.out.println("-------------im a 分割线----------------");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("blips3.txt"));
        blips3 = (Blips3) in.readObject();
        System.out.println(blips3);
    }

}


