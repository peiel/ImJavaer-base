package com.elong.enumerated;

import java.util.EnumSet;

import static java.util.EnumSet.allOf;

/**
 * 创建人 : peierlong
 * 描述 : EnumSet演示程序
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPointses  = EnumSet.noneOf(AlarmPoints.class);

        alarmPointses.add(AlarmPoints.BATHROOM);
        System.out.println(alarmPointses);

        alarmPointses.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(alarmPointses);

        alarmPointses = allOf(AlarmPoints.class);
        System.out.println(alarmPointses);

        alarmPointses.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(alarmPointses);

        alarmPointses = EnumSet.complementOf(alarmPointses);
        System.out.println(alarmPointses);
    }
}
