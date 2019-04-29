package com.xingleng.thread.chapter04.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示:使用 ReentrantLock 结合 Condition 实现等待/通知功能]
**/
public class MyService2 {
	private Lock lock=new ReentrantLock();
	
	private  Condition condition =  lock.newCondition();
	
	public void await() {
		try {
			lock.lock(); //先加锁
			System.out.println("await 时间为:"+System.currentTimeMillis());
			condition.await();//再等待,让线程释放cpu资源
			System.out.println("B");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void signal() {
		this.lock.lock();
		System.out.println("signal 时间为:"+System.currentTimeMillis());
		condition.signal();//唤醒一个线程,即通知
	}
	
}
