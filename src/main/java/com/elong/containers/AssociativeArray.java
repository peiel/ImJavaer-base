package com.elong.containers;

/**
 * 创建人 : peierlong
 * 描述 : 用数组实现的简单的Map
 */
public class AssociativeArray<K, V> {

    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < index; i++) {
            sb.append(pairs[i][0].toString());
            sb.append(" : ");
            sb.append(pairs[i][1].toString());
            if (i < index - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(4);
        map.put("1", "pei");
        map.put("2", "er");
        map.put("3", "long");
        map.put("4", "hha");

        try {
            map.put("5", "aha");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(map);

        System.out.println("---------------");

        System.out.println(map.get("1"));

    }


}
