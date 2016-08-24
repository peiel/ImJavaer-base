package com.elong.enumerated;

import java.util.EnumSet;

import static com.elong.enumerated.AlarmPoints.*;
import static java.util.EnumSet.allOf;
import static java.util.EnumSet.complementOf;

/**
 * 创建人 : peierlong
 * 描述 : EnumSet演示程序
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPointses  = EnumSet.noneOf(AlarmPoints.class);

        alarmPointses.add(BATHROOM);
        System.out.println(alarmPointses);

        alarmPointses.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(alarmPointses);

        alarmPointses = allOf(AlarmPoints.class);
        System.out.println(alarmPointses);

        alarmPointses.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(alarmPointses);

        alarmPointses = EnumSet.complementOf(alarmPointses);
        System.out.println(alarmPointses);
    }
}
