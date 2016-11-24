package com.elong.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午2:11
 * 描述 : 验证线程中抛出的异常被 Thread.UncaughtExceptionHandler 捕获
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable{
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}


class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory{

    public Thread newThread(Runnable r) {
        System.out.println(this + " crate new thread!");
        Thread t = new Thread(r);
        System.out.println("create " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return t;
    }
}