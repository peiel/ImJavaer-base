package com.elong.concurrency;


import com.elong.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/7 下午4:06
 * 描述 : 一种线程安全的做法
 */
@ThreadSafe
public class CountingFactorizer implements Servlet {

    //使用原子操作的Long进行操作
    private final AtomicLong count = new AtomicLong(0);

    //非线程安全的做法
//    private Long notSafeCount;

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count.incrementAndGet();
//        notSafeCount++;
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

}
