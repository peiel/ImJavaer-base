package com.elong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/5 下午2:08
 * 描述 : SingleThreadExecutor
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

}
