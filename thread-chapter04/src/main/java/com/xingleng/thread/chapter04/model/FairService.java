package com.xingleng.thread.chapter04.model;
/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示ReentrantLock 创建公平锁/非公平锁 例子演示]
**/

import java.util.concurrent.locks.ReentrantLock;

public class FairService {
	
	private  ReentrantLock lock;

	public FairService(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);//true 创建公平锁,false创建非公平锁
	}
	
	public void lockMethod() {
		
		try {
			
			this.lock.lock();
			
			System.out.println("ThreadName="+Thread.currentThread().getName()+",获得了锁");			
			
		} finally {
			lock.unlock();
		}
		

	}
	
}
