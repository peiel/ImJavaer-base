package com.elong.thinking.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人 : peierlong
 * 描述 : 使用某个规则生成hash值
 */
public class CountedString {
    private static List<String> create = new ArrayList<String>();
    private String s;
    private int id = 10;

    public CountedString(String s) {
        this.s = s;
        create.add(this.s);
        for (String s1 : create) {
            if (s1.equals(this.s)){
                id++;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString && s.equals(((CountedString)obj).s) && id == ((CountedString)obj).id;
    }

    @Override
    public String toString() {
        return "\nString " + s + " id " + id + " hashcode " + hashCode();
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] countedStrings = new CountedString[5];
        for (int i = 0; i < countedStrings.length; i++) {
            countedStrings[i] = new CountedString("elong");
            map.put(countedStrings[i], i);
        }
        System.out.println(map);

        for (CountedString cs : countedStrings) {
            System.out.println(cs);
            System.out.println(map.get(cs));
        }
    }
}
