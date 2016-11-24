package com.elong.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午3:56
 * 描述 : EvenChecker 测试类
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    public void run() {
        while (!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if ((val % 2) != 0 ){
                System.out.println(val + " 不是偶数");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator intGenerator, int count){
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(intGenerator, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator, 10);
    }
}
