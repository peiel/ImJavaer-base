package com.elong.containers;

import java.util.Map;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V result = value;
        this.value = value;
        return result;
    }

    public boolean equals(Object o) {
        if (!(o instanceof MapEntry))
            return false;
        MapEntry ma = (MapEntry) o;
        return (key == null ? ma.getKey() == null : key.equals(ma.getKey()))
                && (value == null ? ma.getValue() == null : value.equals(ma.getValue()));
    }

    public int hashCode() {
        //TODO 正确覆盖hashcode后再尝试运行Maps.java程序
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    public String toString() {
        return key + " = " + value;
    }


}
