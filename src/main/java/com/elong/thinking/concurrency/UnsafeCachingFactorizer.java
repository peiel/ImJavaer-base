package com.elong.thinking.concurrency;

import com.elong.thinking.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 包名: com.elong.concurrency
 * 创建人 : Elong
 * 时间: 16/9/7 下午4:44
 * 描述 :
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet{

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        if (i.equals(lastNumber.get())){
            lastFactors.get();
        }else{
            BigInteger[] factors = {};
            lastNumber.set(i);
            lastFactors.set(factors);
        }
    }

    private BigInteger extractFromRequest(ServletRequest servletRequest) {
        servletRequest.getAsyncContext();
        return BigInteger.valueOf(1);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
