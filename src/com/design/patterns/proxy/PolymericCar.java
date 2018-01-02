package com.design.patterns.proxy;

public class PolymericCar implements Moveable {

    private Car car;

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        car.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 汽车行驶时间: "
                + (endTime - startTime) + "毫秒!");
    }

    public PolymericCar(Car car) {
        super();
        this.car = car;
    }
}
