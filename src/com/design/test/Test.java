package com.design.test;

import com.design.patterns.cglibproxy.CglibProxy;
import com.design.patterns.cglibproxy.Train;
import com.design.patterns.jdkproxy.TimerHandler;
import com.design.patterns.observerpattern.ConcreteObserver;
import com.design.patterns.observerpattern.ConcreteWeatherSubject;
import com.design.patterns.proxy.Car;
import com.design.patterns.proxy.CarLogProxy;
import com.design.patterns.proxy.CarTimerProxy;
import com.design.patterns.proxy.InvocationHandler;
import com.design.patterns.proxy.Moveable;
import com.design.patterns.proxy.PolymericCar;
import com.design.patterns.proxy.Proxy;
import com.design.patterns.proxy.ProxyCar;


public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        // test.observerPatternTest();
        // test.proxyTest();
        // test.integrationTest();
        // test.polymerizeTest();
        // test.logTimerTest();
        // test.jdkProxyTest();
        // test.cglibTest();
       test.customProxyTest();

    }

    private void customProxyTest()  {
        Car car = new Car();
        InvocationHandler h = new TimerHandler(car);
        Moveable m = null;
        try {
            m = (Moveable) Proxy.newProxyInstance(Moveable.class,h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.move();

    }

    private void cglibTest() {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }

    /**
     * loader: 类加载器
     * interface: 实现接口
     * h InvocationHandler
     * 动态代理实现思路:
     * 实现功能: 通过Proxy的newProxyInstance返回代理对象
     * 1. 声明一段源码(动态产生代理)
     * 2. 编译源码(JDK Compiler API),产生新的类(代理类)
     * 3. 将这个类load到内存当中,产生一个新的对象(代理对象)
     * 4. return 代理对象
     */
    private void jdkProxyTest() {
     /*   Car car = new Car();
        InvocationHandler h = new TimerHandler(car);
        Class<?> clz = car.getClass();
        Moveable m = (Moveable) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), h);
        System.out.println("代理类的名字: " + m.getClass().getName());
        m.move();*/
    }

    private void logTimerTest() {
        Car car = new Car();
        CarLogProxy clp = new CarLogProxy(car);
        CarTimerProxy ctp = new CarTimerProxy(clp);
        ctp.move();
    }

    // 使用聚合方式实现
    private void polymerizeTest() {
        Moveable m = new PolymericCar(new Car());
        m.move();
    }

    // 使用集成方式
    private void integrationTest() {
        Moveable car = new ProxyCar();
        car.move();
    }

    private void proxyTest() {
        Car car = new Car();
        car.move();
    }

    private void observerPatternTest() {
        // 1.创建目标

        ConcreteWeatherSubject weatherSbj = new ConcreteWeatherSubject();

        // 2.创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("黄明的女朋友");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("老妈");

        // 3.注册观察者
        weatherSbj.addObserver(observerGirl);
        weatherSbj.addObserver(observerMum);

        // 4.目标发布天气
        weatherSbj.setContent("明天天气晴朗,蓝天白云,气温28度 ");
    }


}
