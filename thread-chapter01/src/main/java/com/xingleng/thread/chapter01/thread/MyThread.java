package com.xingleng.thread.chapter01.thread;
/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread extends Thread {
	
	@Override
	public void run() {
		super.run();
		System.out.println("============线程名称======================>MyThread");
	}

	

}
