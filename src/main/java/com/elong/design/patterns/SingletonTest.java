package com.elong.design.patterns;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.design.patterns
 * 创建人 : Elong
 * 时间: 2016/11/24 下午4:51
 * 描述 : 单例模式DEMO
 */
public class SingletonTest {

    public static void main(String[] args) {
        SingletonObject firstObj = SingletonObject.getInstance();
        firstObj.setObjName("firstName");
        System.out.println(firstObj.getObjName());   //输出 firstName

        SingletonObject secondObj = SingletonObject.getInstance();
        System.out.println(secondObj.getObjName());  //输出 firstName
        secondObj.setObjName("secondName");
        System.out.println(secondObj.getObjName());  //输出 secondName
        System.out.println(firstObj.getObjName());   //输出 secondName, 说明持有的是一份实例

        //用equals 比较, 返回true
        System.out.println(firstObj.equals(secondObj));
        //用 == 比较, 返回true
        System.out.println(firstObj == secondObj);

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 通过反射机制, 可以调用私有的无参构造函数(并非单例了)
         */
        try {
            Constructor<SingletonObject> constructor = SingletonObject.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonObject invokeObj = constructor.newInstance();
            invokeObj.setObjName("invokeName");
            System.out.println(invokeObj.getObjName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

