package com.elong.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/5 下午3:07
 * 描述 :
 */
public class SimpleDemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(1100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SimpleDemons());
        executorService.shutdown();*/
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("所有守护进程已启动");
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
