package com.xingleng.thread.chapter06.model;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示: 使用static 代码块实现单例模式]
**/
public class MyObject4 {
	
	private static MyObject4 instance = null;
	
	private MyObject4() {
		
	}
	
	static {
		instance =  new MyObject4();
	}
	
	public static MyObject4 getInstance() {//演示 “懒汉模式”
		return instance;
	}
	
}
