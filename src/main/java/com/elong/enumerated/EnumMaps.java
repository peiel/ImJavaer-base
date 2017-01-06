package com.elong.enumerated;

import java.util.EnumMap;
import java.util.Map;

import static javax.swing.UIManager.get;

/**
 * 创建人 : peierlong
 * 描述 : EnumMaps演示程序  使用了命令设计模式: 需要一个拥有单一方法的接口，然后实现这个接口来产生不同行为的子类
 */
public class EnumMaps {
    public static void main(String[] args) {

        EnumMap<AlarmPoints, Command> alarmPointsCommandEnumMap = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);

        alarmPointsCommandEnumMap.put(AlarmPoints.KITCHEN, new Command() {
            public void action() {
                System.out.println("kitchen fire!");
            }
        });
        alarmPointsCommandEnumMap.put(AlarmPoints.BATHROOM, new Command() {
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> alarmPointsCommandEntry : alarmPointsCommandEnumMap.entrySet()) {
            System.out.print(alarmPointsCommandEntry.getKey() + ": ");
            alarmPointsCommandEntry.getValue().action();
        }
        try {
            alarmPointsCommandEnumMap.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


interface Command{
    void action();
}
