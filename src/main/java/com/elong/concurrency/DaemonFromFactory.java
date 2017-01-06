package com.elong.concurrency;

import com.elong.util.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/5 下午3:47
 * 描述 :
 */
public class DaemonFromFactory implements Runnable {

    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(600);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("所有守护线程开始");
        TimeUnit.MILLISECONDS.sleep(2000);
    }
}
