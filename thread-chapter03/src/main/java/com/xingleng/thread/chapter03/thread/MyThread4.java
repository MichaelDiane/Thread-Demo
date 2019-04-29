package com.xingleng.thread.chapter03.thread;

import com.xingleng.thread.chapter03.model.MyList2;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 线程之间通过wait() 和 notify() 方法通信例子
**/
public class MyThread4 extends Thread {
	
	private Object lock;

	public MyThread4( Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			synchronized(lock) {
				for (int i = 0; i < 10; i++) {
					MyList2.add();
					if(MyList2.size()==5) {
						lock.notify();
						System.out.println("通知已发送!");
					}
					System.out.println("添加了 "+(i+1)+" 个元素");
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
