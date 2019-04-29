package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread4 extends Thread {
	
	private  int  count=5;
	
	public MyThread4(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		super.run();
		while(count>0) {
			count --;
			System.out.println("===由===" +this.currentThread().getName()+"===计算,count="+count);
		}
	}
	
}
