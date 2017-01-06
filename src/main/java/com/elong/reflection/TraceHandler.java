package com.elong.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 包名: com.elong.core.volume.one
 * 创建人 : Elong
 * 时间: 2016/12/13 下午3:04
 * 描述 : 包装器类
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }

}
