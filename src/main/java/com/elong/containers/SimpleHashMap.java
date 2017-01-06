package com.elong.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : 自己实现简单HashMap 继承 AbstractMap
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    //获得一个统一分布的长度
    private static final int SIZE = 997;

    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }

        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;

        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair); //做新旧替换
                found = true;
                break;
            }
        }
        if (! found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> pair : buckets[index]) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mPair : bucket)
                set.add(mPair);
        }
        return set;
    }

    @Override
    public void clear() {
       /* 死脑筋实现 sb
       for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            for (MapEntry<K, V> kvMapEntry : bucket) {
                kvMapEntry = null;
            }
        }
        */
       buckets = new LinkedList[SIZE];  //GC回收之前对象？
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        if (bucket == null)
            return null;
        Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        for(;iterator.hasNext();){
            MapEntry<K, V> iPair = iterator.next();
            if (iPair.getKey().equals(key)){
                V value = iPair.getValue();
                iterator.remove(); //重点  在这里执行remove操作
                return value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<Integer, String>();
        simpleHashMap.putAll(SortedMapDemo.getMapData());
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get(1));

        simpleHashMap.remove(1);

        System.out.println(simpleHashMap);

        System.out.println(simpleHashMap.get(1));
    }

}
