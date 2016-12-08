package com.elong.test;

import com.alibaba.fastjson.JSONObject;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println("start");
//            Thread thread = new TestThread();
//            thread.start();
//        System.out.println("thread.getname() " + thread.getName());
//        System.out.println("end");
//        System.exit(1);


//        Thread t1 = new Thread(new TestThread(),"t1name");
//        t1.run();
//        System.out.println("t1.getname: " + t1.getName());
//


        /*System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getName() + "running");
                }
            }.start();
        }*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("money", "0");

        System.out.println(jsonObject);


    }

}

class TestThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}
