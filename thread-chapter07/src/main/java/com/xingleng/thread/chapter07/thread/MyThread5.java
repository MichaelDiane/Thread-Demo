package com.xingleng.thread.chapter07.thread;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [ 演示:线程异常处理传递 ]
**/
public class MyThread5 extends Thread {
	
	private String num = "a";
	
	
	public MyThread5() {
		super();
	}

	public MyThread5(ThreadGroup group,String name,String num) {
		super(group, name);
	}
	
	@Override
		public void run() {
			int numInt = Integer.parseInt(num);
			System.out.println("线程打印中~"+ (numInt++));
		}
}
