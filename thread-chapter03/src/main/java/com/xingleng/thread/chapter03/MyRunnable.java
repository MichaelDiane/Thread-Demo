package com.xingleng.thread.chapter03;
/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [演示:wait(1ong)方法的线程演示例子]
**/
public class MyRunnable implements Runnable {
	 static private Object object = new Object();
	@Override
	public void run() {
		try {
			synchronized (object) {
				System.out.println("wait begin time="+System.currentTimeMillis());
					object.wait(5000);
				System.out.println("wait end time="+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
