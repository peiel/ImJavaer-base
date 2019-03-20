package com.elong.concurrency;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019-03-20
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello world!");
            }
        }, "thread-1").start();

        Thread.currentThread().join();

    }
}
