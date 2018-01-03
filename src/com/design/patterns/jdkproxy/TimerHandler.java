package com.design.patterns.jdkproxy;


import com.design.patterns.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {

    private Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  被代理的对象
     * @param m 被代理对象的方法
     * @param args   方法的参数
     * @return Object 方法的返回值
     */


    @Override
    public void invoke(Object o, Method m) {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        try {
            m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间: "
                + (endTime - startTime) + "毫秒!");
    }
}
