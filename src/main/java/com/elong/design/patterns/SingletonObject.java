package com.elong.design.patterns;

import java.io.Serializable;

/**
 * 包名: com.elong.design.patterns
 * 创建人 : Elong
 * 时间: 2016/11/25 下午6:37
 * 描述 : 单例对象(第一种是公有静态final域, 第二种是公有静态工厂, 本例使用第二种)
 */
class SingletonObject implements Serializable {

    private static SingletonObject singletonObject = null;
    private String objName;

    private SingletonObject() {
        if (singletonObject != null)
            throw new IllegalArgumentException("单例模式不能创建新的实例了");
    }

    /*
     * 命名规范:  getInstance返回唯一实例,  newInstance返回不通实例
     */
    static SingletonObject getInstance() {
        if (singletonObject == null)
            singletonObject = new SingletonObject();
        return singletonObject;
    }

    String getObjName() {
        return objName;
    }

    void setObjName(String objName) {
        this.objName = objName;
    }

    /**
     * 此方法保证在反序列化的时候保持单例
     */
    private Object readResolve(){
        return singletonObject;
    }

}
