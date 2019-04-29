package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread3 extends Thread {
	
	private  int i;
	
	public MyThread3(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("===run==="+i);
	}
	
}
