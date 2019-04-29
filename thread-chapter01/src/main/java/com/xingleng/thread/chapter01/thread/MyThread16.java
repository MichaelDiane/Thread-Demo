package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [守护线程的演示例子] 
*/
public class MyThread16 extends Thread {
	
	private int i=0;

	@Override
	public void run() {
		try {
			while(true) {
				i++;
				System.out.println("i="+i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
