package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.HasSelfPrivateNum3;

/**
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class MyThread5 extends Thread {
	
	private HasSelfPrivateNum3 numRef;

	public MyThread5(HasSelfPrivateNum3 numRef) {
		super();
		this.numRef = numRef;
	}
	
	@Override
	public void run() {
		super.run();
		numRef.methodA();
	}
}
