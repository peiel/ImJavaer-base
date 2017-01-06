package com.elong.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 包名: com.elong.core.volume.one
 * 创建人 : Elong
 * 时间: 2016/12/13 下午3:16
 * 描述 : 代理测试类
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + i;
            InvocationHandler invocationHandler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, invocationHandler);
            elements[i] = proxy;
        }

        int key = new Random().nextInt(elements.length) + 1;
        System.out.println("key : " + key);
        int result = Arrays.binarySearch(elements, key);
        if (result > 0) System.out.println(elements[result]);
    }

}
