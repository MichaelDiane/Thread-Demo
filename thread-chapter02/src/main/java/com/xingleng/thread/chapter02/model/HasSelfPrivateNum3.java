package com.xingleng.thread.chapter02.model;

/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc 演示线程 synchronized 同步方法鱼锁对象 示例
**/
public class HasSelfPrivateNum3 {
	
    synchronized public void methodA() {
		 try {
			 System.out.println(" begin methodA threadName="+Thread.currentThread().getName());
			 Thread.sleep(2000);
			 System.out.println(" end endTime="+System.currentTimeMillis());
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
    
    public void methodB() {
		 try {
			 System.out.println(" begin methodB threadName="+Thread.currentThread().getName());
			 Thread.sleep(2000);
			 System.out.println(" end B");
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
    
    synchronized public void methodC() {
		 try {
			 System.out.println(" begin methodC threadName="+Thread.currentThread().getName());
			 Thread.sleep(2000);
			 System.out.println(" end C ");
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
}
