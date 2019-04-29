package com.xingleng.thread.chapter03.thread;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示多线程 join() 演示
**/
public class MyThread7 extends Thread {
	
	@Override
	public void run() {
		try {
			int value =  (int)(Math.random()*10000);
			System.out.println(value);
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
