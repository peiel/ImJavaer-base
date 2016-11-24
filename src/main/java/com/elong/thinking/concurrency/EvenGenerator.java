package com.elong.thinking.concurrency;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午4:05
 * 描述 :
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }



}
