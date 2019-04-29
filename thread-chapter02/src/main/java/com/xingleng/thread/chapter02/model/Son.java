package com.xingleng.thread.chapter02.model;
/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class Son extends Father {
	synchronized public void operateSonMethod() {
		try {
			while(i>0) {
				i--;
				System.out.println(" son print i="+i);
				Thread.sleep(100);
				this.operateFatherMethod();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
