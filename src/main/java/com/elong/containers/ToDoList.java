package com.elong.containers;

import java.util.PriorityQueue;

/**
 * 创建人 : peierlong
 * 描述 : 使用优先级队列实现的一个简单的ToDoList
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary; //主
        private int secondary; //次
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return 1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(this.primary) + secondary + " : " + item;
        }
    }

    public boolean add(char primary, int secondary, String item) {
        return super.add(new ToDoItem(primary, secondary, item));
    }

    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add('A', 1, "吃饭");
        toDoItems.add('B', 0, "睡觉");
        toDoItems.add('C', 9, "打豆豆");

        for (;!toDoItems.isEmpty();){
            System.out.println(toDoItems.remove() + " ");
        }

    }
}
