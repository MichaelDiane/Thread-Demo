package com.xingleng.thread.chapter01.runnable;
/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 3:57:06 PM 
* @desc [类说明] 
*/
public class MyRunnable implements Runnable {

	public MyRunnable() {
		
	}

	@Override
	public void run() {
		System.out.println("运行中!");
	}

}
