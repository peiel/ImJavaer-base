package com.elong.thinking.enumerated;

import java.util.Random;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> tClass) {
        return random(tClass.getEnumConstants());
    }

    private static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }

}
