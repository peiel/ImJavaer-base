package com.elong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建人 : peierlong
 * 描述 : 线程优先级简单测试
 */
public class SimplePriorites implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorites(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorites(Thread.MAX_PRIORITY));
            executorService.execute(new SimplePriorites(Thread.MIN_PRIORITY));
        }
        executorService.shutdown();
    }
}
