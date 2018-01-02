package com.design.test;

import com.design.patterns.observer.ConcreteObserver;
import com.design.patterns.observer.ConcreteWeatherSubject;

public class Test {

    public static void main(String[] args) {

        // 1.创建目标

        ConcreteWeatherSubject weatherSbj = new ConcreteWeatherSubject();

        // 2.创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("黄明的女朋友");
        observerGirl.setRemindThing("是我们的第一次约会的地点,街心公园,不见不散哦");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("老妈");
        observerMum.setRemindThing("是一个购物的好日子,明天去天虹扫货");

        // 3.注册观察者
        weatherSbj.attach(observerGirl);
        weatherSbj.attach(observerMum);

        // 4.目标发布天气
        weatherSbj.setWeatherContent("明天天气晴朗,蓝天白云,气温28度 ");

    }

}
