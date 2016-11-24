package com.elong.thinking.concurrency;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/6 下午2:47
 * 描述 : IntGenerator 抽象类
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }

}
