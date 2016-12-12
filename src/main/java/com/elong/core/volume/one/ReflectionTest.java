package com.elong.core.volume.one;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 包名: com.elong.core.volume.one
 * 创建人 : Elong
 * 时间: 2016/12/12 下午8:39
 * 描述 : 反射测试类, 返回某个类的信息
 */
public class ReflectionTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要显示的类全名称(例如: java.util.Date)");
        String name = scanner.next();

        try {
            Class aClass = Class.forName(name);
            Class superclass = aClass.getSuperclass();
            String modifiers = Modifier.toString(aClass.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superclass != null && superclass != Object.class) {
                System.out.println(" extend " + superclass.getName());
            }
            System.out.print("\n{\n");
            printConstructors(aClass);
            System.out.println();
            printMethods(aClass);
            System.out.println();
            printFields(aClass);
            System.out.println();
            System.out.print("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void printConstructors(Class cl) {
        for (Constructor c : cl.getDeclaredConstructors()) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String name = method.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(returnType.getName() + " " + name + "(");
            Class<?>[] types = method.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(types[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(type.getName() + " " + name + ";");
        }
    }


}
