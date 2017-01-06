package com.elong.util;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.util
 * 创建人 : Elong
 * 时间: 16/9/5 下午6:08
 * 描述 : DaemonThreadFactory来创建线程池
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }

}
