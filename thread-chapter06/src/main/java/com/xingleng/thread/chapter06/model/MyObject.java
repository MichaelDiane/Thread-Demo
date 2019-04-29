package com.xingleng.thread.chapter06.model;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示: 多线程与单例模式 示例 ]
**/
public class MyObject {
	
	private static MyObject myObject = new MyObject();
	
	private MyObject() {
		
	}
	
	public static MyObject getInstance() {
		return myObject;
	}
	
}
