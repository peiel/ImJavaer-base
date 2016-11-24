package com.elong.thinking.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : 使用ArrayList来实现一个Map
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    @Override
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> keyIter = keys.iterator();
        Iterator<V> valueIter = values.iterator();
        for (; keyIter.hasNext(); ) {
            set.add(new MapEntry<K, V>(keyIter.next(), valueIter.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<Integer, String> map = new SlowMap<Integer, String>();
        map.putAll(SortedMapDemo.getMapData());
        System.out.println(map);
        System.out.println("-------");
        System.out.println(map.entrySet());
        System.out.println("-------");
        System.out.println(map.get(1));
    }
}
