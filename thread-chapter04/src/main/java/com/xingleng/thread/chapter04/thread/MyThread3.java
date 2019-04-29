package com.xingleng.thread.chapter04.thread;

import com.xingleng.thread.chapter04.model.MyService2;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示:使用 ReentrantLock 结合 Condition 实现等待/通知功能]
**/
public class MyThread3 extends Thread {
	private MyService2 myService2;

	public MyThread3(MyService2 myService2) {
		super();
		this.myService2 = myService2;
	}
	
	@Override
	public void run() {
		this.myService2.await();
	}
	
}
