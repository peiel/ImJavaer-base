package com.elong.thinking.io;

import java.io.*;
import java.util.Random;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Worm implements Serializable {
    private static Random random = new Random(47);

    private Data[] datas = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };

    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm Constructor " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm() {
        System.out.println("Default Constructor");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(":");
        sb.append(c);
        sb.append("(");
        for (Data data : datas) {
            sb.append(data);
        }
        sb.append(")");
        if (next != null)
            sb.append(next);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm(6, 'a');
        System.out.println(worm);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.txt"));
        objectOutputStream.writeObject("peierlong \n");
        objectOutputStream.writeObject(worm);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));
        String name = (String) objectInputStream.readObject();
        Worm worm1 = (Worm) objectInputStream.readObject();
        System.out.println(name + " " + worm1);
        objectInputStream.close();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream1.writeObject("elong \n");
        objectOutputStream1.writeObject(worm);
        objectOutputStream1.close();
        byteArrayOutputStream.close();


        ObjectInputStream objectInputStream1 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        System.out.println(objectInputStream1.readObject() + " " + objectInputStream1.readObject());
        objectInputStream1.close();

    }
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}