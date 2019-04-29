package com.xingleng.thread.chapter07.group;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示:线程异常处理传递 ]
**/
public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		super.uncaughtException(t, e);
		System.out.println(" 线程组的异常处理! ");
		e.printStackTrace();
	}

}
