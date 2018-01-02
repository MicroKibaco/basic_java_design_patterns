package com.design.patterns.proxy;

public class CarLogProxy implements Moveable {

    private Moveable m;

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("日志开始...");
        m.move();
        System.out.println("日志结束...");
    }

    public CarLogProxy(Moveable m) {
        super();
        this.m = m;
    }
}
