package com.design.patterns.factory;

import java.util.Map;

/**
 * 发型工厂
 */
public class HairFactory {

    /**
     * 根据类型来创造对象
     */
    public HairInterface getHair(String key) {

        if ("left".equals(key)) {
            return new LeftHair();
        }
        if ("right".equals(key)) {
            return new LeftHair();
        } else {
            return null;
        }
    }

    /**
     * 根据类的名称来生成对象
     */

    public HairInterface getHairByClass(String className) {
        try {
            HairInterface hair = (HairInterface) Class.forName(className).newInstance();
            return hair;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 根据类的key来生成对象
     */

    public HairInterface getHairByClassKey(String key) {
        try {
            Map<String, String> map = new PropertiesReader().getProperties();
            HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
            return hair;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
