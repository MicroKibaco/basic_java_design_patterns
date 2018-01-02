package com.design.patterns.singleton;

/**
 * 懒汉模式
 */
public class HurrySingleton {

    // 1.将构造方式私有化,不允许外边直接创建对象
    private HurrySingleton() {
    }

    // 2.声明类的唯一实例,使用private static 修饰
    private static HurrySingleton instance;

    // 3.提供一个获取实例的方法,使用 public static 修饰
    public static HurrySingleton getInstance() {

        if (instance == null){
            instance = new HurrySingleton();
        }

        return instance;
    }

}

