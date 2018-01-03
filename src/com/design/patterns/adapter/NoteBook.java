package com.design.patterns.adapter;

public class NoteBook {

    private ThreePlugIf plug;

    private NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    // 使用插座充电
    private void charge() {

        plug.powerWithThree();

    }

    public static void main(String[] args) {
        GBTwoPlug twoPlug = new GBTwoPlug();
        ThreePlugIf three = new TwoPlugAdapter(twoPlug);
        NoteBook nb = new NoteBook(three);
        nb.charge();

        three = new TwoPlugAdapterExtends();
        nb = new NoteBook(three);
        nb.charge();
    }

}
