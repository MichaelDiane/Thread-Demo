package com.xingleng.thread.chapter01.thread;

import java.util.Random;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread12 extends Thread {

	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 1000; i++) {
			Random random = new Random();
			random.nextInt();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("=====Thread  12 Use Time====="+(endTime-beginTime)); //输出获取线程的优先级值
	}
	
}
