package com.xingleng.thread.chapter03.thread;

import com.xingleng.thread.chapter03.model.MyList2;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 线程之间通过wait() 和 notify() 方法通信例子
**/
public class MyThread3 extends Thread {
	
	private Object lock;

	public MyThread3( Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			synchronized(lock) {
				if(MyList2.size()!=5) {
					System.out.println("Wait() Begin=====>"+System.currentTimeMillis());
					lock.wait();
					System.out.println("Wait() end=====>"+System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
