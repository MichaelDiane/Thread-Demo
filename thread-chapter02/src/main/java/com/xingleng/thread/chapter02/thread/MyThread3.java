package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.HasSelfPrivateNum2;

/**
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class MyThread3 extends Thread {
	private HasSelfPrivateNum2 numRef;

	public MyThread3(HasSelfPrivateNum2 numRef) {
		super();
		this.numRef = numRef;
	}
	
	@Override
	public void run() {
		super.run();
		numRef.add("a");
	}
}
