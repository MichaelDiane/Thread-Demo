package com.xingleng.thread.chapter04.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示:使用 ReentrantLock 类实现同步]
**/
public class MyService {
	private Lock lock=new ReentrantLock();
	public void methodA() {
		try {
			this.lock.lock();//上锁
			System.out.println("methodA begin threadName="+Thread.currentThread().getName()+"   ,time="+System.currentTimeMillis());
				Thread.sleep(5000);
			System.out.println("methodA end threadName="+Thread.currentThread().getName()+"   ,time="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.lock.unlock();//释放锁
		}
		
	}
	public void methodB() {
		try {
			this.lock.lock();//上锁
			System.out.println("methodB begin threadName="+Thread.currentThread().getName()+"   ,time="+System.currentTimeMillis());
				Thread.sleep(5000);
			System.out.println("methodB end threadName="+Thread.currentThread().getName()+"   ,time="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.lock.unlock();//释放锁
		}
	}
	
}
