package com.elong.thinking.concurrency;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
