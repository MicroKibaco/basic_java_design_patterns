package com.design.patterns.observer;

/**
 * 具体的目标对象,把负责有关状态存入相应的观察者对象中
 */
public class ConcreteWeatherSubject extends WeatherSubject {

    // 天气内容的情况,这个消息从目标处获取
    private String weatherContent;

    // 观察者的名字,是谁收到这个讯息,黄晓明的老婆还是他妈
    private String observerName;

    public String getObserverName() {
        return observerName;
    }


    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        // 内容有了,说明天气更新了,通知所有订阅的人
        this.notifyObservers(weatherContent);
    }
}
