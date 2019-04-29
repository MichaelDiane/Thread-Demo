package com.xingleng.thread.chapter06.model;

import org.springframework.util.ObjectUtils;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示: 多线程与单例模式 示例 懒汉模式 ]
**/
public class MyObject2 {
	
	private static MyObject2 myObject = new MyObject2();
	
	private MyObject2() {
		
	}
	
	public static MyObject2 getInstance() {//演示 “懒汉模式”
		if(ObjectUtils.isEmpty(myObject)) {
			myObject = new MyObject2();
		}
		return myObject;
	}
	
}
