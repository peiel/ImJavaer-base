package com.elong.core.volume.one;

import java.lang.reflect.Array;

/**
 * 包名: com.elong.core.volume.one
 * 创建人 : Elong
 * 时间: 2016/12/12 下午10:01
 * 描述 : 反射相关例子
 */
public class ReflectionExample {

    /**
     * 好的数据的拷贝
     * @param o 源数组
     * @param newLength 长度
     * @return 新数组
     */
    public static Object goodCopyOf(Object o, int newLength) {
        Class<?> aClass = o.getClass();
        if (!aClass.isArray()) {
            return null;
        }
        Class<?> componentType = aClass.getComponentType();
        int length = Array.getLength(o);
        // 使用反射包下的Array类来构建新的数组, 相对于Object[]来说, 可以指定类型避免转换异常。
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(o, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

}
