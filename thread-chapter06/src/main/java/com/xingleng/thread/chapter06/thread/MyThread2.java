package com.xingleng.thread.chapter06.thread;

import com.xingleng.thread.chapter06.model.MyObject2;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示: 多线程与单例模式-懒汉模式 示例]
**/
public class MyThread2  extends Thread {
	
	@Override
	public void run() {
		
		System.out.println( MyObject2.getInstance().hashCode() );
		
	}
	
}
