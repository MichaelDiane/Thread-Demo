package com.xingleng.thread.chapter02.thread;
/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc [volatile 解决异步死循环示例]
**/
public class MyThread13 extends Thread {
	
  volatile private boolean isRunning = true;
	
	public boolean isRunning() {
		return isRunning;
	}


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


	@Override
	public void run() {
		System.out.println(" 进入 run 了 ");
		while(this.isRunning == true) {
			
		}
		System.out.println("线程被停止");
	}

}
