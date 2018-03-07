package com.elong.test;

/**
 * @author elong
 * @version V1.0
 * @date 2018/3/6
 */
public class TestSync implements Runnable {

    int b = 100;

     void m1() throws InterruptedException {
        b = 1000;
        System.out.println("m1 sleep end");
        System.out.println("b= " + b);
    }

     void m2() throws InterruptedException {
        System.out.println("m2 sleep end");
        b = 2000;
    }

    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync tt = new TestSync();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("main thread b = " + tt.b);
    }

}
