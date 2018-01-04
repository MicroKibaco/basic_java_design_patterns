package com.design.patterns.templatefunc;

/**
 * 抽象基类,为所有算法提供一个算法框架
 * 提神饮料
 */
public abstract class RefreshBeverage {
    /**
     * 制备饮料的模板方法
     * 封装了所有子类共同遵循的算法框架
     */
    public final void preBeverageTempl() {
        // 步骤1: 将水煮沸
        boilWater();

        // 步骤2: 泡制饮料
        brew();

        // 步骤3: 倒入杯中
        pullInCup();

        // 步骤4: 加入调味料
        addCondiments();

    }

    /**
     * 基本方法: 加入调味料
     */
    protected abstract void addCondiments();

    /**
     * 基本方法: 将饮料倒入杯中
     */
    private void pullInCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void brew();

    /**
     * 基本方法: 将水煮沸
     */
    private void boilWater() {
        System.out.println("将水煮沸");

    }

}
