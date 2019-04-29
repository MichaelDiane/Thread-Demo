package com.xingleng.thread.chapter07.group;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示线程组中出现异常的处理]
**/
public class MyThreadGroup2 extends ThreadGroup {

	public MyThreadGroup2(String name) {
		super(name);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		super.uncaughtException(t, e);
		this.interrupt();
	}

}
