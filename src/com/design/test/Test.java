package com.design.test;


import com.design.patterns.observerpattern.ConcreteObserver;
import com.design.patterns.observerpattern.ConcreteWeatherSubject;

public class Test {

    public static void main(String[] args) {

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
