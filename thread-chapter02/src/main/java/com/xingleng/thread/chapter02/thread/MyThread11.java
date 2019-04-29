package com.xingleng.thread.chapter02.thread;
/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc [死锁演示例子]
**/
public class MyThread11 implements Runnable {
	
	public String userName;
	
	public Object lock1 = new Object();
	
	public Object lock2 = new Object();

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public void run() {
		if("a".equals(userName.trim().toLowerCase())) {
			synchronized (lock1) {
				try {
					System.out.println(" lock1 userName="+userName);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("按照 lock1——> lock2代码顺序演示顺序执行!");
				}
			}
			
		}
		if("b".equals(userName.trim().toLowerCase())) {
			synchronized (lock2) {
				try {
					System.out.println(" lock2 userName="+userName);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("按照 lock2——> lock1代码顺序演示顺序执行!");
				}
			}
		}
	}

}
