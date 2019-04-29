package com.xingleng.thread.chapter02.model;
/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc [演示同步代码块的阻碍塞问题]
**/
public class ObjectService {
	public void methodA() {
		try {
			synchronized (this) {
				System.out.println("MethodA begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("MethodA end time="+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void methodB() {
		try {
			synchronized (this) {
				System.out.println("MethodB begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("MethodB end time="+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
