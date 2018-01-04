package com.design.patterns.factory;

/**
 * 画了一个左偏分发型
 */
public class LeftHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("画了一个左偏分发型");
    }
}
