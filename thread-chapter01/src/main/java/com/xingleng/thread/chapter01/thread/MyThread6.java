package com.xingleng.thread.chapter01.thread;

/** 
* @author Michael.Zhang
* @version 创建时间：Apr 23, 2019 11:14:06 AM 
* @desc [类说明] 
*/
public class MyThread6 extends Thread {
	
	private  long  count=0;
	
	public MyThread6(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		while(true) {
			count++;
			/***
			 * 此处需要注意在例子 Thread5中并没有此句输出语句,但两者执行效果不同;其根源于println为同步方法,其在执行到该方法时,同步锁并未被释放.故而导致其线程一直处于 “暂停” 中
			 * 这也进一步演示了其方法 suspend() 的缺陷:线程独占问题
			 */
			System.out.println("===由线程" +this.currentThread().getName()+"===计算,count="+count);
		}
	}
	
}
