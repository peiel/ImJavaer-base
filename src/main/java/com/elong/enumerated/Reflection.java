package com.elong.enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * 创建人 : peierlong
 * 描述 : 利用反射来查看Enum类
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("---- Analyzing " + enumClass + "-------");
        System.out.println("Interface");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base : " + enumClass.getSuperclass());
        System.out.println("Method : ");
        Set<String> methods = new HashSet<String>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);

        Set<String> analyze = analyze(Enum.class);

        System.out.println("---------exploreMethods.containsAll(analyze)---------");
        System.out.println(exploreMethods.containsAll(analyze));

        System.out.println("------exploreMethods.removeAll(analyze)--------");
        System.out.println(exploreMethods.removeAll(analyze));
        System.out.println(exploreMethods);

    }


}

enum Explore{
    HERE, THERE
}
