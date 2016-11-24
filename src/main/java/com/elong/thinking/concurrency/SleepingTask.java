package com.elong.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/5 下午2:18
 * 描述 : 睡眠
 */
public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
