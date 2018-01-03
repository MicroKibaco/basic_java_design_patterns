package com.design.patterns.adapter;

/**
 * 二相转三相的插座适配器
 */
public class TwoPlugAdapter implements ThreePlugIf {

    private GBTwoPlug mGBTwoPlug;

    public TwoPlugAdapter(GBTwoPlug gbtwoplug) {
        mGBTwoPlug = gbtwoplug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转化");
        mGBTwoPlug.powerWithTwo();
    }


}
