package com.elong.design.patterns;

/**
 * 包名: com.elong.design.patterns
 * 创建人 : Elong
 * 时间: 2016/11/24 下午4:51
 * 描述 : 证明单例模式可以用 == 比较
 */
public class Singleton {

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

    }

}

class SingletonObject {

    private static SingletonObject singletonObject = null;
    private String objName;

    private SingletonObject() {}

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

}

