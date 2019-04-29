package com.xingleng.thread.chapter06.model;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示: 多线程与单例模式 示例 使用静态内部类实现单例模式 ]
**/
public class MyObject3 {
	
	private MyObject3() {
		
	}
	
	private static class MyObjectHandler{//静态内置内
		private static MyObject3 myObject =  new MyObject3();
	}
	
	public static MyObject3 getInstance() {//演示 “懒汉模式”
		return MyObjectHandler.myObject;
	}
	
}
