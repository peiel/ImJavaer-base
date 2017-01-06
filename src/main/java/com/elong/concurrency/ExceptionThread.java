package com.elong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午2:05
 * 描述 : try catch 无法捕获线程中抛出的异常
 */
public class ExceptionThread implements Runnable{

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        /*
         * 注意:  try catch 无法捕获线程中抛出的异常
         */
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
            exec.shutdown();
        } catch (Exception e) {
            System.out.println("被捕获到后执行");
        }

    }
}
