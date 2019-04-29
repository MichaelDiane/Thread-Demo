package com.xingleng.thread.chapter07.model;

import java.lang.Thread.UncaughtExceptionHandler;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc 线程异常处理传递
**/
public class ObjectUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("对象的异常处理");
		e.printStackTrace();
	}

}
