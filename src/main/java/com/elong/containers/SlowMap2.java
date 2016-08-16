package com.elong.containers;

import java.util.*;

/**
 * 创建人 : peierlong
 * 描述 : 使用ArrayList来实现一个Map
 */
public class SlowMap2<K, V> extends AbstractMap<K, V> {
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
        return new AbstractSet<Entry<K, V>>() {
            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<Entry<K, V>>() {
                    private int index = -1;
                    boolean canRemove;
                    public boolean hasNext() {
                        return index < keys.size() -1;
                    }

                    public Entry<K, V> next() {
                        canRemove = true;
                        ++index;
                        return new MapEntry<K, V>(keys.get(index), values.get(index));
                    }

                    public void remove() {
                        if (canRemove){
                            canRemove = false;
                            keys.remove(index);
                            values.remove(index);
                            index--;
                        }
                    }
                };
            }

            @Override
            public boolean contains(Object o) {
                return super.contains(o);
            }

            @Override
            public boolean remove(Object o) {
                return super.remove(o);
            }

            @Override
            public int size() {
                return keys.size();
            }

            @Override
            public void clear() {
                keys.clear();
                values.clear();
            }
        };
    }


    public static void main(String[] args) {
        SlowMap2<Integer, String> map = new SlowMap2<Integer, String>();
        map.putAll(SortedMapDemo.getMapData());
        System.out.println(map);
        System.out.println("-------");
        System.out.println(map.entrySet());
        System.out.println("-------");
        System.out.println(map.get(1));
    }
}
