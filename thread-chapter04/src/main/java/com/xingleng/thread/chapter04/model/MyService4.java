package com.xingleng.thread.chapter04.model;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [ 演示:使用  ReentrantReadWriteLock 演示线程的读写互斥]
**/
public class MyService4 {
	
	private ReentrantReadWriteLock lock = new  ReentrantReadWriteLock();
	
	public void read() {
		try {
			this.lock.readLock().lock();
			System.out.println("获取读锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.lock.readLock().unlock();
		}
	}
	
	public void write() {
		try {
			this.lock.writeLock().lock();
			System.out.println("获取写锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.lock.writeLock().unlock();
		}
	}
	
	
}
