package com.elong.thinking.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : 自己实现简单HashMap 实现 Map的方式
 * @see AbstractMap 相关实现
 *
 */
public class SimpleHashMap2<K, V> implements Map<K, V> {
    //获得一个统一分布的长度
    private static final int SIZE = 997;

    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public int size() {
        int size = 0;
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null){
                size += bucket.size();
            }
        }
        return size;
    }

    public boolean isEmpty() {
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null)
                return false;
        }
        return true;
    }

    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return false;
        Iterator<MapEntry<K, V>> it = buckets[index].iterator();
        for (;it.hasNext();){
            MapEntry<K, V> pair = it.next();
            if (pair.getKey().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> kvMapEntry : bucket) {
                if (kvMapEntry.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

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

    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet())
            put(entry.getKey(), entry.getValue());
    }

    public void clear() {
        buckets = new LinkedList[SIZE];  //GC回收之前对象？
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> kvMapEntry : bucket) {
                set.add(kvMapEntry.getKey());
            }
        }
        return set;
    }

    public Collection<V> values() {
        Collection<V> conVCollection = new ArrayList<V>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> kvMapEntry : bucket) {
                conVCollection.add(kvMapEntry.getValue());
            }
        }
        return conVCollection;
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
}
