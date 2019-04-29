package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.HasSelfPrivateNum;

/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class MyThread extends Thread {
	private HasSelfPrivateNum numRef;

	public MyThread(HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}
	
	@Override
	public void run() {
		
		super.run();
		numRef.add("a");
		
	}
}
