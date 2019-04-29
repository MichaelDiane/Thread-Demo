package com.xingleng.thread.chapter06.thread;

import com.xingleng.thread.chapter06.model.MyObject3;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示: 多线程与单例模式 示例 使用静态内部类实现单例模式]
**/
public class MyThread3  extends Thread {
	
	@Override
	public void run() {
		System.out.println( MyObject3.getInstance().hashCode() );
		
	}
	
}
