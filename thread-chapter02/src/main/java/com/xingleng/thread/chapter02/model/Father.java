package com.xingleng.thread.chapter02.model;
/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc 演示线程的 重入锁 例子
**/
public class Father {
	
	public int i= 10;
	
	synchronized public void operateFatherMethod() {
		
		try {
				i--;
				System.out.println(" father print i="+i);
				Thread.sleep(100);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	

}
