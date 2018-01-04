package com.design.patterns.factory;

/**
 * 人物实现接口
 */
public interface PersonFactory {

	public Boy getBoy();

	public Girl getGirl();
	
}
