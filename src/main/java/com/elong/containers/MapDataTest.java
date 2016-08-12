package com.elong.containers;

import com.elong.util.Generator;
import com.elong.util.MapData;
import com.elong.util.Pair;

import java.util.Iterator;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class MapDataTest {
    public static void main(String[] args) {
        //Pair Generator
        System.out.println(MapData.map(new Letters(), 11));
        //Two separate generator
        //TODO 添加类
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return number < size;
            }
            public Integer next() {
                return number++;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
