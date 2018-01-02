package com.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 目标对象,它知道观察他的观察者,并提供注册(添加)和删除观察者的接口
 */
public class WeatherSubject {

    // 用来保存和注册观察者对象
    private List<Observer> observers = new ArrayList<>();

    // 把订阅天气的人添加到订阅者列表中
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除集合中的指定观察者
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有已经订阅天气的人
     */
    protected void notifyObservers(String content) {
        for (Observer observer : observers) {
            observer.update(content);
        }
    }

}
