package com.elong.thinking.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 创建人 : peierlong
 * 描述 : 回调线程Demo
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            list.add(exe.submit(new TaskWithResult(i)));
        }
        for (Future<String> stringFuture : list) {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exe.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskWithResult id = " + id;
    }

    public String call() throws Exception {
        return toString();
    }
}


