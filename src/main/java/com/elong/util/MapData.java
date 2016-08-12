package com.elong.util;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 创建人 : peierlong
 * 描述 : Map初始化类
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
    //a single Pair Generator
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = gen.next();
            put(pair.key, pair.value);
        }
    }

    //Two separate Generators
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    //A key Generator and a single value
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    //An Iterable and a value Generator
    public MapData(Iterable<K> iterK, Generator<V> genV) {
        for (K key : iterK) {
            put(key, genV.next());
        }
    }

    //An Iterable and a single value
    public MapData(Iterable<K> iterK, V value) {
        for (K key : iterK) {
            put(key, value);
        }
    }

    /**
     * 获取MapData实例
     */
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K, V>(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity){
        return new MapData<K, V>(genK, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> iterK, Generator<V> genV){
        return new MapData<K, V>(iterK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> iterK, V value){
        return new MapData<K, V>(iterK, value);
    }

}
