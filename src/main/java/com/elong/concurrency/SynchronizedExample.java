package com.elong.concurrency;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/9 下午6:53
 * 描述 :
 */
public class SynchronizedExample {
    public static void main(String[] args){
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter);
        Thread  threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
    }
}

 class Counter{
    long count = 0;

    public synchronized void add(long value){
        this.count += value;
    }
}

 class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i);
        }
    }
}