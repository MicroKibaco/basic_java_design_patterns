package com.design.patterns.factory;
/**
 * 画了一个右偏分发型
 */
public class RightHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("画了一个右偏分发型");
    }
}
