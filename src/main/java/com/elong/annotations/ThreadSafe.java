package com.elong.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包名: com.elong.annotations
 * 创建人 : Elong
 * 时间: 16/9/7 下午4:38
 * 描述 :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
