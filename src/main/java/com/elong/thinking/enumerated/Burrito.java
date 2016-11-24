package com.elong.thinking.enumerated;

import static com.elong.thinking.enumerated.Spiciness.*;

/**
 * 创建人 : peierlong
 * 描述 : 枚举类型可以使用 import static 静态导入
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(FLAMING));
        System.out.println(new Burrito(HOT));
    }
}
