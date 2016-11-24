package com.elong.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午2:28
 * 描述 : 在Thread类中设置一个静态域,并将这个处理器设置为未捕获异常处理器
 */
public class SettingDefaultHandler{
    public static void main(String[] args) {
        //设置
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}
