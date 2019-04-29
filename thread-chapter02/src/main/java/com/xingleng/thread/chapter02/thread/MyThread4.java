package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.HasSelfPrivateNum2;

/**
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class MyThread4 extends Thread {
	
	private HasSelfPrivateNum2 numRef;

	public MyThread4(HasSelfPrivateNum2 numRef) {
		super();
		this.numRef = numRef;
	}
	
	@Override
	public void run() {
		super.run();
		numRef.add("b");
	}
}
