package com.elong.thinking.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> c) {
        for (Method method : c.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("找到了用例, id = " + useCase.id() + ", description = " + useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }

        for (Integer aCase : useCases) {
            System.out.println("没有用到的用例, id = " + aCase);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 1, 2, 3, 4);
        trackUseCases(useCases, PasswordUtil.class);
    }
}
