package com.elong.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建人 : peierlong
 * 描述 : CachedThreadPool 将为每个任务创建一个线程
 */
public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
