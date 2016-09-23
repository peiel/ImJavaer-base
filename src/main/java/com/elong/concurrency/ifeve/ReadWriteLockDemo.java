package com.elong.concurrency.ifeve;

import java.util.HashMap;
import java.util.Map;

/**
 * 包名: com.elong.concurrency.ifeve
 * 创建人 : Elong
 * 时间: 9/23/16 11:12 AM
 * 描述 : 跟着敲的代码
 */
public class ReadWriteLockDemo {
//    private int readers = 0;

    private Map<Thread, Integer> readCallingThreads = new HashMap<Thread, Integer>();


    private int writers = 0;
    private int writeRequests = 0;

    private Thread writingThread = null;

    public synchronized void lockRead() throws InterruptedException {
        Thread currentThread = Thread.currentThread();

        while (!canGrantReadAccess(currentThread)) {
            System.out.println(Thread.currentThread().getName() + "lockRead() wait()");
            wait();
        }

        readCallingThreads.put(currentThread, getReadAccessCount(currentThread));
    }

    public synchronized void unlockRead() {
        Thread currentThread = Thread.currentThread();
        Integer count = getReadAccessCount(currentThread);
        if (count == 1) {
            readCallingThreads.put(currentThread, 0);
        } else {
            readCallingThreads.put(currentThread, count - 1);
        }
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        Thread callingThread = Thread.currentThread();

        while (!canGrantWriteAccess(callingThread)) {
            System.out.println(Thread.currentThread().getName() + "lockWrite() wait()");
            wait();
        }

        writeRequests--;
        writers++;
        writingThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException {
        writers--;
        if (writers == 0) {
            writingThread = null;
        }
        notifyAll();
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (readCallingThreads.size() > 0) return false;
        if (writingThread == null) return true;
        if (callingThread != writingThread) return false;
        return true;
    }

    /**
     * 检查读取执行权限
     *
     * @param callingThread 当前线程
     * @return 是否有读取执行权限
     */
    private boolean canGrantReadAccess(Thread callingThread) {
        if (writers > 0) return false;
        if (readCallingThreads.get(callingThread) != null) return true; //重入的读锁比写锁优先级高
        if (writeRequests > 0) return false;
        return true;
    }

    private Integer getReadAccessCount(Thread callingThread) {
        Integer count = readCallingThreads.get(callingThread);
        if (count == null) return 0;
        return count;
    }


}