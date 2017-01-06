package com.elong.concurrency;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 上午11:11
 * 描述 : 在一个线程中执行 t.join() 那么,当前线程就会等待t执行完后再执行。
 */
public class Joining {

    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 15000),
                grumpy = new Sleeper("Grumpy", 15000);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }

}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + "被唤醒");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + "加入完成");
    }
}