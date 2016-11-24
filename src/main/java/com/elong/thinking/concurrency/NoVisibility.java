package com.elong.thinking.concurrency;

import com.elong.thinking.annotations.NotThreadSafe;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/8 上午11:33
 * 描述 : 在没有同步的情况下共享变量
 */
@NotThreadSafe
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("yield()" + number);
                Thread.yield();
            }
            System.out.println("number : " + number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        number = 42;
        ready = true;
    }
}
