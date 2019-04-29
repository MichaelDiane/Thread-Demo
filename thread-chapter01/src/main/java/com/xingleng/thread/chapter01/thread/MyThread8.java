package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc  演示线程的优先级具由继承性的演示例子
*/
public class MyThread8 extends Thread {

	@Override
	public void run() {
		System.out.println("MyThread8 Run Priority="+this.getPriority()); //输出获取线程的优先级值
		MyThread9 myThread9 =  new MyThread9();
		myThread9.start();
	}
	
}
