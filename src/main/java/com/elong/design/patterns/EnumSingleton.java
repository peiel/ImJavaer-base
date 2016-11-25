package com.elong.design.patterns;

/**
 * 包名: com.elong.design.patterns
 * 创建人 : Elong
 * 时间: 2016/11/25 下午6:40
 * 描述 : 单元素的枚举类型实现单例
 */
public enum EnumSingleton {

    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }
}
