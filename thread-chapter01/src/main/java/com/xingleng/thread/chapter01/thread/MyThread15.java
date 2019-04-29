package com.xingleng.thread.chapter01.thread;

import java.util.Random;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread15 extends Thread {
	
	private int count=0;
	

	public int getCount() {
		return count;
	}



	@Override
	public void run() {
		while(true) {
			this.count++;
		}
	}
	
}
