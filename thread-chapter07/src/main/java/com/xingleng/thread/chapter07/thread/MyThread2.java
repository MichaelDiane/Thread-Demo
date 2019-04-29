package com.xingleng.thread.chapter07.thread;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示:线程中出现异常处理]
**/
public class MyThread2 extends Thread {
	@Override
	public void run() {
		String userName=null;
		System.out.println(userName.hashCode());
	}
}
