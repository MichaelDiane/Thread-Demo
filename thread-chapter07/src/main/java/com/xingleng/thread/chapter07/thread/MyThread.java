package com.xingleng.thread.chapter07.thread;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示:查看线程状态]
**/
public class MyThread extends Thread {
	public MyThread() {
		System.out.println(" 构造器方法中的线程状态="+Thread.currentThread().getState() );
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("run()方法中的线程状态="+Thread.currentThread().getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
