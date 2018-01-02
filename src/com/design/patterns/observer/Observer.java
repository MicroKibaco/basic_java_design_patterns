package com.design.patterns.observer;

/**
 * 这是一个观察者接口,定义一个更新接口给那些在目标发生改变的时候通知对象
 */
public interface Observer {

    /**
     * 更新接口
     * @param content 传入的目标对象,方便获取目标对象的相应状态
     */
     void update(String content);
}
