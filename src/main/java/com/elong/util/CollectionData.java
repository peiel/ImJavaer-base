package com.elong.util;

import java.util.ArrayList;

/**
 * 创建人 : peierlong
 * 描述 : 构建一个类，它的构造器接收Generator和quantity数值
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<T>(gen, quantity);
    }

}
