package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread5 extends Thread {
	
	private  long  count=0;
	
	public MyThread5(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		while(true) {
			count++;
		}
	}
	
}
