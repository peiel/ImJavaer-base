package com.elong.thinking.annotations;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Testable {
    public static void execute(){
        System.out.println("execute...");
    }
    @Test
    public static void testExecute(){
        execute();
    }
}
