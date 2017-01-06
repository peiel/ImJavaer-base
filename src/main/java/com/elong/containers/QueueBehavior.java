package com.elong.containers;

import com.elong.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 创建人 : peierlong
 * 描述 : 队列是一种先进先出的容器
 */
public class QueueBehavior {

    private static <T> void test(Queue<T> queue, Generator<T> gen){
        for (int i = 0; i < 10; i++) {
            queue.offer(gen.next()); //向队列中插入数据
        }
        for (;queue.peek() != null;){
            System.out.print(queue.remove() + " "); //删除并返回该值
        }
        System.out.println();
    }

    private static class Gen implements Generator<String>{
        String[] arr = "c b a d e f h i j k".split(" ");
        int i = 0;
        public String next() {
            return arr[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new ArrayBlockingQueue<String>(10), new Gen()); //数组阻塞队列
        test(new ConcurrentLinkedQueue<String>(), new Gen()); //并发队列
        test(new LinkedBlockingQueue<String>(), new Gen());
        //优先级队列
        test(new PriorityQueue<String>(), new Gen());
        test(new PriorityBlockingQueue<String>(), new Gen());
    }
}
