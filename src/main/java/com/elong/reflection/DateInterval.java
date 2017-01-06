package com.elong.reflection;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 包名: com.elong.core.volume.one
 * 创建人 : Elong
 * 时间: 2016/12/13 下午4:02
 * 描述 : 泛型方法的擦除
 */
public class DateInterval extends Pair<Date>{

    public DateInterval(Date first, Date second) {
        super(first, second);
    }

    @Override
    public void setSecond(Date second) {
        if (second.compareTo(getFirst()) > 0){
            super.setSecond(second);
        }
    }

    public static void main(String[] args) {
        DateInterval dateInterval = new DateInterval(new Date(), new Date());

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dateInterval.setSecond(new Date());

        System.out.println(dateInterval);


    }

}


class Pair<T>{
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
