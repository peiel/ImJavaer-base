package com.elong.containers;

/**
 * 创建人 : peierlong
 * 描述 : 双向队列测试类
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        for (int i = 20; i <= 40; i++) {
            deque.addFirst(i);
        }
        for (int i = 80; i <= 90; i++){
            deque.addLst(i);
        }

        for (;deque.size()!=0;){
            System.out.print(deque.removeFirst() + " ");
//            System.out.print(deque.removeLast() + " ");
        }
    }
}
