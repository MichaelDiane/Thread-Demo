package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread2 extends Thread {
	
	@Override
	public void run() {
		try {
			for (int i = 0; i <10; i++) {
				int time = (int)Math.random()*1000;
					Thread.sleep(time);//线程睡眠时间
					System.out.println("===run==="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
