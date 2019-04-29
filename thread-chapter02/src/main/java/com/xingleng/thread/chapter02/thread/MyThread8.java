package com.xingleng.thread.chapter02.thread;

import com.xingleng.thread.chapter02.model.Son;

/**
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc []
**/
public class MyThread8 extends Thread {
	
	@Override
	public void run() {
		Son son = new Son();
		son.operateSonMethod();
	}
}
