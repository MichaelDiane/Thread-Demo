package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.ObjectService;

/**
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc [演示同步代码块的阻碍塞问题]
**/
public class MyThread10 extends Thread {
	
	private ObjectService objectService;
	
	
	public MyThread10(ObjectService objectService) {
		super();
		this.objectService = objectService;
	}


	@Override
	public void run() {
		super.run();
		this.objectService.methodB();
	}
}
