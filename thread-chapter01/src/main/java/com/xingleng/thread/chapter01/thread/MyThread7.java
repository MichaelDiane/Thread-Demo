package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread7 extends Thread {

	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count=0;
		for (int i = 0; i < 50000000; i++) {
			Thread.yield(); //这里目的是通过 yield方法,将CPU资源交出.即放弃当前cpu资源;注释这行代码时,耗时会立刻出来.
			count=count+(i+1);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("用时:"+(endTime-beginTime)+"毫秒!");
	}
	
}
