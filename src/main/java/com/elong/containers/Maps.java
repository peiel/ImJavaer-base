package com.elong.containers;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人 : peierlong
 * 描述 : 展示Map接口的可用操作
 */
public class Maps {

    public static void printKeys(Map<Integer, String> map){
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys : ");
        System.out.println(map.keySet()); //生产一个存放Keys的Set
    }

    public static void test(Map<Integer, String> map){
        System.out.println("获取Map的姓名 : " + map.getClass().getSimpleName());
        map.putAll(getMapData());
        //Map的Key具有Set的行为 再次putAll一次
        map.putAll(getMapData());
        System.out.println("Map的所有的Key " + map.keySet());
        System.out.println("Map的所有的Values " + map.values());
        System.out.println("Map所有键值输出 " + map);

        System.out.println("是否存在这个key --> Map.containsKey() : " + map.containsKey(1));
        System.out.println("是否存在这个value --> Map.containsValue() : " + map.containsValue("aaa"));

        System.out.println("Map.get(1) : " + map.get(1));

        Integer key = map.keySet().iterator().next();
        System.out.println("Map中的第一个Key : " + key);

        map.remove(key); //把第一个key移除
        map.clear(); //清除map中的数据
        System.out.println("查看Map是否为空 : " + (map.isEmpty() ? "空" : "非空"));

        map.putAll(getMapData());
        map.keySet().removeAll(map.keySet());
        System.out.println("map.keySet().removeAll 后 查看Map是否为空 : " + (map.isEmpty() ? "空" : "非空"));

    }


    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
    }


    public static Map<Integer, String> getMapData(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");
        map.put(4, "ddd");
        map.put(5, "eee");
        return map;
    }

}
