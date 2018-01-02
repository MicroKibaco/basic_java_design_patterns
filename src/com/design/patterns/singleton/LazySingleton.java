package com.design.patterns.singleton;

/**
 * 单例模式 Singleton
 * 应用场合: 有些对象只需要一个就足够了,如:古代的皇帝,老婆
 * 作用: 保证整个应用程序中某个实例有且只有一个
 * 类型: 饿汉式 懒汉式
 */
public class LazySingleton {

    // 1.将构造方法私有化,不允许外部直接创建对象
    private LazySingleton() {
    }

    // 2.创建类的唯一实例
    private static LazySingleton instance = new LazySingleton();

    public static LazySingleton getInstance() {
        return instance;
    }
}
