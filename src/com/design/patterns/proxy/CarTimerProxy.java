package com.design.patterns.proxy;

public class CarTimerProxy implements Moveable {

    private Moveable m;

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间: "
                + (endTime - startTime) + "毫秒!");
    }

    public CarTimerProxy(Moveable m) {
        super();
        this.m = m;
    }
}
