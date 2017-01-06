package com.elong.concurrency;

/**
 * 创建人 : peierlong
 * 描述 : LiftOff测试类
 */
public class BasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("finish!");
    }
}
