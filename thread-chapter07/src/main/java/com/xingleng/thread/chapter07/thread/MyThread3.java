package com.xingleng.thread.chapter07.thread;
/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示:线程组内中出现异常处理]
**/
public class MyThread3 extends Thread {
	
	private String num;
	
	public MyThread3(ThreadGroup group,String name,String num) {
		super(group, name);
		this.num = num;
	}
	
	@Override
		public void run() {
			int numInt = Integer.parseInt(num);
			while (true) {
				System.out.println("死循环~"+ Thread.currentThread().getName());
			}
		}
}
