package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread9 extends Thread {

	@Override
	public void run() {
		System.out.println("MyThread9 Run Priority="+this.getPriority()); //输出获取线程的优先级值
		
	}
	
}
