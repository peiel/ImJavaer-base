package com.elong.util;

import java.util.concurrent.ThreadFactory;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/5 下午3:40
 * 描述 :
 */
public class DaemonThreadFactory implements ThreadFactory{

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
