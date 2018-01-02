package com.design.patterns.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {

    private Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  被代理的对象
     * @param method 被代理对象的方法
     * @param args   方法的参数
     * @return Object 方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间: "
                + (endTime - startTime) + "毫秒!");
        return null;
    }
}
