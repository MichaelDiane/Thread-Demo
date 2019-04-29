package com.xingleng.thread.chapter02.runnable;
/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示:通过多线程解决同步死循环问题
**/
public class MyRunnable implements Runnable {
	
	private boolean isContinuePrint = true;
	
	public boolean isContinuePrint() {
		return isContinuePrint;
	}

	public void setContinuePrint(boolean isContinuePrint) {
		this.isContinuePrint = isContinuePrint;
	}

	public void printStringMethod() {
		try {
			while(this.isContinuePrint==true) {
				System.out.println("run printStringMethod threadName="+Thread.currentThread().getName());
			
					Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		this.printStringMethod();
	}

}
