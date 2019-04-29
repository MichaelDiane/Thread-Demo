package com.xingleng.thread.chapter04.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [ 演示:使用 ReentrantLock 结合 Condition 通知部分线程 ]
**/
public class MyService3 {
	
	private Lock lock = new ReentrantLock();
	
	private  Condition condition_a =  lock.newCondition();
	
	private  Condition condition_b =  lock.newCondition();
	
	public void awaitA() {
		try {
			lock.lock(); //先加锁
			System.out.println("begin awaitA 时间为:"+System.currentTimeMillis());
			condition_a.await();//再等待,让线程释放cpu资源
			System.out.println("end awaitA 时间为:"+System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}finally {
			lock.unlock();
		}
	}
	public void awaitB() {
		try {
			
			lock.lock(); //先加锁
			System.out.println("begin awaitB 时间为:"+System.currentTimeMillis());
			condition_b.await();//再等待,让线程释放cpu资源
			System.out.println("end awaitB 时间为:"+System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void signalA() {
		try {
			this.lock.lock();
			System.out.println("signal 时间为:"+System.currentTimeMillis());
			condition_a.signalAll();//唤醒 conditionA的所有等待线程
		} finally {
			lock.unlock();
		}
		
		
	}
	
	public void signalB() {
		try {
			this.lock.lock();
			System.out.println("signal 时间为:"+System.currentTimeMillis());
			condition_b.signalAll();//唤醒 conditionB的所有等待线程
		} finally {
			lock.unlock();
		}
		
	}
	
}
