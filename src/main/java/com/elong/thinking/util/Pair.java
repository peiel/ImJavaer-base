package com.elong.thinking.util;

/**
 * 创建人 : peierlong
 * 描述 : 创建一个键值对实例
 */
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
}
