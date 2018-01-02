package com.design.patterns.observer;

/**
 * 具体的观察者对象,实现更新方法,使自身的状态和目标保持一致
 */
public class ConcreteObserver implements Observer {

    // 天气内容的情况,这个消息从目标处获取
    private String weatherContent;

    // 观察者的名字,是谁收到这个讯息,黄晓明的老婆还是他妈
    private String observerName;


    // 提醒内容:黄明的女朋友提醒约会,而他老妈提醒购物
    private String remindThing;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }


    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
    /**
     * @param content 获取目标状态到观察者状态中
     */
    @Override
    public void update(String content) {
        System.out.println(observerName + "收到了 " + content +","+remindThing);
    }



}
