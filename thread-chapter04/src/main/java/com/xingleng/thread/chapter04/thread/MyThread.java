package com.xingleng.thread.chapter04.thread;

import com.xingleng.thread.chapter04.model.MyService;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示:使用 ReentrantLock 类实现同步]
**/
public class MyThread extends Thread {
	private MyService myService;

	public MyThread(MyService myService) {
		super();
		this.myService = myService;
	}
	
	@Override
	public void run() {
		this.myService.methodA();
	}
	
}
